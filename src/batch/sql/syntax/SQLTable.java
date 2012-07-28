// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import batch.Op;
import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.schema.IRelationship;
import batch.util.BatchFactory;
import batch.util.Forest;

public class SQLTable extends ValueExpression {

	// what i need is a TABLE, and a
	// relationship to some other table

	// base.RELATIONSHIP
	public static int tagNum = 1;

	// query that uses this table
	SQLQuery query;

	// abstract model
	IEntityType type;
	String synonym;

	Map<IRelationship, SQLTable> joins = new HashMap<IRelationship, SQLTable>();

	// if a join
	SQLField from;
	SQLField self;

	public SQLTable(SQLQuery query, IEntityType type) {
		this(query, type, "T" + tagNum++);
	}

	protected SQLTable(SQLQuery query, IEntityType type, String synonym) {
		super();
		this.query = query;
		this.type = type;
		this.synonym = synonym;
	}
	
	public <E> E run(BatchFactory<E> f) {
		return f.Var(type.getTableName() + "@" + synonym);
	}


	private void setJoin(SQLField from, SQLField self) {
		this.from = from;
		this.self = self;
	}

	public SQLTable makeJoin(IRelationship joinField) {
		SQLTable toTable = joins.get(joinField);
		if (toTable == null) {
			IEntityType toType = joinField.toType();
			toTable = new SQLTable(query, toType);
			SQLField jFromColumm;
			SQLField jToColumn;
			if (joinField.singleValued()) {
				// this field is single-valued: many-to-one
				jFromColumm = new SQLField(this, joinField);
				jToColumn = toTable.getKey();
			} else {
				jFromColumm = getKey();
				IMember inverseField = joinField.getInverse();
				jToColumn = new SQLField(toTable, inverseField);
			}
			toTable.setJoin(jFromColumm, jToColumn);
		}
		return toTable;
	}

	public boolean addJoin(IRelationship joinField, SQLTable table) {
		if (joins.get(joinField) == null) {
			joins.put(joinField, table);
			return true;
		}
		return false;
	}

	@Override
	public SQLTable getTable() {
		return this;
	}

	@Override
	public SQLTable getTableNoJoins(Env env) {
		return this; // do NOT Return real table
	}

	public SQLTable getRealTable() {
		return this;
	}

	public void fromClause(StringBuilder sb) {
		makeSynonym(sb);
		for (SQLTable sub : joins.values())
			sub.joinClause(sb);
	}

	private void makeSynonym(StringBuilder sb) {
		sb.append(type.getTableName());
		sb.append(" ");
		sb.append(synonym);
	}

	private void joinClause(StringBuilder sb) {
		sb.append("\nINNER JOIN ");
		makeSynonym(sb);
		sb.append(" ON ");
		makeJoinCondition(this).toSQL(sb, null, null);
		for (SQLTable sub : joins.values())
			sub.joinClause(sb);
	}

	private SQLTranslation makeJoinCondition(SQLTable fromTable) {
		// this=one, other=many
		return Factory.factory.Prim(Op.EQ, self, from);
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		sb.append(synonym);
	}

	public IEntityType getEntityType() {
		return type;
	}

	public SQLQuery getQuery() {
		return query;
	}

	public String getKeyColumm() {
		return type.getKey().getName();
	}

	public SQLField getKey() {
		if (type.getKey() == null)
			return null;
		else
			return new SQLField(this, type.getKey());
	}

	// make an foreign table, used for aggregations where an 
	// inner table uses a table in an outer table
	public SQLTable makeNestedRoot(SQLQuery subQuery) {
		return new OuterTable(subQuery, type, synonym);
	}

	public SQLTable traverse(IMember member) {
		SQLTable newTable = makeJoin((IRelationship) member);
		// this is a small optimization, to use a foreign key instead
		// of a primary key
		// TODO: this doesn't quite work... it optimized too
		// often, and sometimes the field is used to get the 
		// table of the target
		// if (column.equals(table.getKeyColumm()))
		//	  return new SQLField(baseTable, baseTable.getJoinColumn(me.field));
		addJoin((IRelationship) member, newTable);
		return newTable;
	}

	@Override
	public SQLTable getBase(Env env) {
		return this;
	}

	public boolean IsKeylessTable() {
		return getKey() == null;
	}

	////////////////

	// this table represents a table from an outer query
	// we use a "where" clause to join with it, instead of a regular join
	class OuterTable extends SQLTable {
		SQLTable baseTable;

		protected OuterTable(SQLQuery query, IEntityType type, String synonym) {
			super(query, type, synonym);
		}

		public void fromClause(StringBuilder sb) {
			if (baseTable != null)
				baseTable.fromClause(sb);
			else
				super.fromClause(sb);
		}

		@Override
		public boolean addJoin(IRelationship joinField, SQLTable table) {
			if (baseTable == null) {
				baseTable = table;
				query.addWhere(table.makeJoinCondition(this));
				return true;
			} else
				return baseTable.addJoin(joinField, table);
		}

		public SQLTable makeJoin(IRelationship joinField) {
			if (baseTable != null)
				return baseTable.makeJoin(joinField);
			else
				return super.makeJoin(joinField);
		}

	}

	// this table represents a table from an outer query
	// we use a "where" clause to join with it, instead of a regular join
	public class GroupByTable extends SQLTable {
		// for fake group-by tables
		SQLTable realTable;

		protected GroupByTable(SQLQuery query, IEntityType type,
				SQLTable realTable) {
			super(query, type, "VirtualGroupBy");
			this.realTable = realTable;
		}

		// make an foreign table, used for aggregations where an 
		// inner table uses a table in an outer table
		public SQLTable makeNestedRoot(SQLQuery subQuery) {
			return this;
		}

		// can only traverse the items member
		public SQLTable traverse(IMember member) {
			return realTable;
		}

		public SQLTable getRealTable() {
			return realTable;
		}

		public void fromClause(StringBuilder sb) {
			realTable.fromClause(sb);
		}

		public boolean IsKeylessTable() {
			return false;
		}
	}
}
