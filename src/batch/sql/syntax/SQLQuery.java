// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.ArrayList;
import java.util.List;

import batch.Op;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.Forest;

class Sorting {
	public boolean ascending;
	public SQLTranslation value;

	public Sorting(boolean ascending, SQLTranslation value) {
		super();
		this.ascending = ascending;
		this.value = value;
	}
}

public class SQLQuery extends Base {
	Loop loop;
	public String var;
	
	Op op;
	SQLTranslation body;
	boolean singleRow = false;
	boolean isValue = false;
	List<Output> bindings = new ArrayList<Output>();
	List<SQLQuery> subqueries = new ArrayList<SQLQuery>();
	int sortLocation = 0; // where to insert the sorts
	List<Sorting> sorts;
	List<SQLTranslation> groupBy;
	SQLTable tables;
	private SQLTranslation where;
	private Output outputKey;
	SQLTranslation parent;
	SQLQuery parentQuery;
	long limit = -1;
	private boolean distinct;
	// actions
	public SQLAction sqlAction = SQLAction.NONE;
	List<SQLTranslation> actions;
	ISchema schema;
	public Env env;
	public String insertResultName;

	// used for root query
	public SQLQuery(ISchema schema, Loop loop, SQLAction sqlAction, boolean isValue,
			SQLQuery parentQuery) {
		this.schema = schema;
		this.loop = loop;
		this.isValue = isValue;
		this.sqlAction = sqlAction;
		this.parentQuery = parentQuery;
		op = loop.getOp();
		var = loop.getVar();
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Var("[NESTED QUERY]");
	}

	// used for root query
	public SQLQuery(boolean singleRow) {
		this.singleRow = singleRow;
	}

	public void setTables(SQLTable tables) {
		this.tables = tables;
	}

	public void addProjection(Output n) {
		if (sqlAction == SQLAction.NONE || sqlAction == SQLAction.VALUE)
			sqlAction = SQLAction.SELECT;
		else if (sqlAction != SQLAction.SELECT && sqlAction != SQLAction.INSERT)
			throw new Error("Mixed SELECT and " + sqlAction);
		if (getAggOp() != null)
			parentQuery.addProjection(n);
		else {
			// merge a aggregate value in a group-by query into the query
			if (groupBy != null && n.getExpr() instanceof SQLQuery) {
				SQLQuery inner = (SQLQuery) n.getExpr();
				List<SQLTranslation> args = new ArrayList<SQLTranslation>();
				SQLTranslation body = inner.getBody();
				args.add(body instanceof SQLTable ? new Var("*") : body);
				n = new Output(n.getLocation(),
						new Call(batch.sql.syntax.Factory.factory.Root(), inner
								.getAggOp(), args));
			}
			bindings.add(n);
		}
	}

	private String getAggOp() {
		return loop == null ? null : loop.getAggOp();
	}

	private SQLTranslation getBody() {
		return body;
	}

	final static List<SQLTranslation> nullArgs = new ArrayList<SQLTranslation>();

	public void setLimit(long limit) {
		if (this.limit == -1 || limit < this.limit)
			this.limit = limit;
	}

	public void addSubquery(SQLQuery subquery, SQLTranslation parentBase) {
		subqueries.add(subquery);

		if (outputKey == null && parentBase != null) {
			SQLTranslation exp = parentBase.normalize(schema,
					this,
					null,
					env,
					NormType.NORMAL);
			SQLField key = exp.getTable().getRealTable().getKey();
			outputKey = new Output(getSubTag(), key);
			addProjection(outputKey);
		}
		if (outputKey != null)
			addSort(true, outputKey);
	}

	void setContainer(SQLQuery parentQuery) {
		this.parentQuery = parentQuery;
	}

	// parent exp is the key that ties this 
	// query to its parent query
	void setParent(SQLTranslation parent) {
		this.parent = parent; /// new Output("parent", 
		addProjection(new Output("parent", parent));
		addSort(true, new Var("parent"));
		if (groupBy != null)
			groupBy.add(parent);
	}

	void addSort(boolean ascending, SQLTranslation data) {
		if (sorts == null)
			sorts = new ArrayList<Sorting>();
		if (data instanceof Output)
			data = new Var(((Output) data).getLocation());
		sorts.add(sortLocation++, new Sorting(ascending, data));
	}

	public String getSubTag() {
		return "id";
	}

	public List<SQLQuery> getSubqueries() {
		return subqueries;
	}

	public void addWhere(SQLTranslation cond) {
		where = batch.syntax.Factory.binary(Factory.factory, Op.AND, cond, where);
	}

	public void setDistinct() {
		distinct = true;
	}

	public List<Output> getProjections() {
		return bindings;
	}

	//	public String getVar() {
	//		return me.var;
	//	}

	@Override
	public SQLTable getTableNoJoins(Env env) {
		return tables;
	}

	public void addGroupBy(SQLTranslation exp) {
		if (groupBy == null)
			groupBy = new ArrayList<SQLTranslation>();
		groupBy.add(exp);
		if (parent != null)
			groupBy.add(parent);
		outputKey = new Output(getSubTag(), exp);
		addProjection(outputKey);
	}

	// Department
	// d.emps
	// d.manager.projects
	// d.manager.projects
	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		toSQL(sb, params, data, null);
	}

	public void toSQL(StringBuilder sb,
			List<Object> params,
			Forest data,
			SQLField bodyField) {
		int count = 0;
		switch (sqlAction) {
		case DELETE:
			/*
			DELETE [LOW_PRIORITY] [QUICK] [IGNORE]
			    tbl_name[.*] [, tbl_name[.*]] ...
			    FROM table_references
			    [WHERE where_condition]
			 */
			sb.append("DELETE ");
			count = 0;
			for (SQLTranslation e : actions) {
				if (++count > 1)
					sb.append(",");
				e.toSQL(sb, params, data);
			}
			outputFrom(sb, params, data);
			return;
		case UPDATE:
			/*
			UPDATE [LOW_PRIORITY] [IGNORE] table_references
			    SET col_name1={expr1|DEFAULT} [, col_name2={expr2|DEFAULT}] ...
			    [WHERE where_condition]
			 */
			sb.append("UPDATE ");
			tables.fromClause(sb);
			sb.append(" SET ");
			count = 0;
			for (SQLTranslation e : actions) {
				if (++count > 1)
					sb.append(",");
				e.toSQL(sb, params, data);
			}
			outputWhere(sb, params, data);
			return;
		case INSERT:
			//INSERT INTO suppliers(supplier_id, supplier_name)
			//SELECT account_no, name
			//FROM customers
			//WHERE city = 'Newark';
			sb.append("INSERT INTO ");
			Call insert = (Call) actions.get(0);
			insert.toSQL(sb, params, data);
			sb.append('\n');
			// fall through
		case VALUE:
		case SELECT:
			SQLAction savedAction = sqlAction;
			boolean aggregate = getAggOp() != null;
			if (aggregate || isValue) {
				if (op == Op.OR)
					sb.append(getAggOp());
				sb.append('(');
			}

			sb.append("SELECT ");
			if (distinct)
				sb.append("DISTINCT ");
			count = 0;
			if (bodyField != null)
				bodyField.toSQLinside(sb, params, data);
			else if (aggregate && op != Op.OR) {
				sb.append(getAggOp());
				sb.append('(');
				if (op == Op.COUNT)
					sb.append('*');
				else
					getBody().toSQL(sb, params, data);
				sb.append(')');
			} else {
				for (SQLTranslation b : bindings) {
					if (++count > 1)
						sb.append(",\n\t");
					else
						sb.append("\n\t");
					b.toSQL(sb, params, data);
				}
				if (count == 0)
					sb.append('*');
			}
			outputFrom(sb, params, data);
			if (aggregate || isValue)
				sb.append(')');
			sqlAction = savedAction;
			return;
		}
	}

	private void outputFrom(StringBuilder sb, List<Object> params, Forest data) {
		if (tables != null) {
			sb.append("\nFROM ");
			tables.fromClause(sb);
		}
		outputWhere(sb, params, data);
	}

	private void outputWhere(StringBuilder sb, List<Object> params, Forest data) {
		if (where != null) {
			sb.append("\nWHERE ");
			where.toSQL(sb, params, data);
		}
		if (groupBy != null) {
			sb.append("\nGROUP BY ");
			int i = 0;
			for (SQLTranslation e : groupBy) {
				if (i++ > 0)
					sb.append(",");
				e.toSQL(sb, params, data);
			}
		}
		if (sorts != null) {
			sb.append("\nORDER BY ");
			int i = 0;
			for (Sorting s : sorts) {
				if (i++ > 0)
					sb.append(",");
				s.value.toSQL(sb, params, data);
				sb.append(s.ascending ? " ASC" : " DESC");
			}
		}
		if (limit >= 0)
			sb.append("\nLIMIT " + limit);
	}

	public SQLTable getTable() {
		return tables;
	}

	public void doAction(SQLAction kind, SQLTranslation table) {
		if (kind == SQLAction.INSERT && sqlAction == SQLAction.SELECT)
			sqlAction = SQLAction.INSERT;
		else if (sqlAction == SQLAction.NONE) {
			sqlAction = kind;
		} else if (sqlAction == SQLAction.INSERT ? kind != SQLAction.SELECT
				: sqlAction != kind)
			throw new Error("Combined actions");
		if (actions == null)
			actions = new ArrayList<SQLTranslation>();
		actions.add(table);
	}

	public SQLAction getAction() {
		return sqlAction;
	}

	public boolean isSingleRow() {
		return singleRow;
	}

	public void setSingleRow() {
		singleRow = true;
	}

	public SQLTranslation normalize(ISchema schema,
			SQLQuery query,
			SQLTranslation outerCond,
			Env env,
			NormType normType) {
		return this;
	}

	public SQLTranslation finalize(SQLTranslation body, SQLTranslation testId) {
		this.body = body;
		if (op == Op.AND) {
			// have to use AND(x,y) = NOT(OR(NOT(x),NOT(y))
			where = Factory.factory.Prim(Op.NOT, where);
			op = Op.OR;
		}
		if (op == Op.OR) {
			addWhere(body);
		}
		if (testId != null) {
			SQLTranslation id = testId.normalize(schema,
					this,
					null,
					env,
					NormType.NORMAL);
			addWhere(Factory.factory.Prim(Op.EQ,
					env.lookup(getVar()).getTable().getKey(),
					id));
		}
		if (isValue || getAggOp() != null)
		{
			body.getTable();
			return this;
		}
		else
			return env.lookup(getVar());
	}

	public String getVar() {
		return var;
	}

	public void resetSortOrder() {
		sortLocation = 0; // start parents sorting above ours!
	}

	public void toString(StringBuilder sb) {
		try {
			toSQL(sb, null, null);			
		} catch (Error x) {
			sb.append("ERROR");
		}
	}

	@Override
	public SQLTranslation getTransformations(SQLTranslation base) {
		return loop.getTransformations(base);
	}
	
	/*
	public SQLTranslation dot(String field, ISchema schema, SQLQuery query,
			Env env, NormType normType) {
		body = new Dot(body, field).normalize(schema, query, null, env, normType);
		return this;
	}
	*/

}
