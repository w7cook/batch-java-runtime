// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.DataType;
import batch.sql.schema.IAttribute;
import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.schema.IRelationship;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.Forest;

public class SQLField extends ValueExpression {

	private SQLTable table;
	private IMember member;

	public SQLField(SQLTable table, IMember member) {
		super();
		this.table = table;
		this.member = member;
		// TODO: debugging only
		// B.A.W: Commented out, but I think this causes a NPE later.
		if (member == null)
			throw new Error("BAD FIeld");
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Var("[" + member.columnName() + "]");
	}

	@Override
	public SQLTable getTable() {
		if (member instanceof IRelationship) {
			return table.traverse(member);
		} else
			return table;
	}

	public IEntityType getTargetEntity() {
		return ((IRelationship) member).toType();
	}

	public DataType getDataType() {
		if (member instanceof IAttribute) {
			IAttribute attr = (IAttribute) member;
			if (!attr.isKey())
				return attr.getType();
		}
		return null;
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		// SQLQuery query = getQuery();
		// if (query.sqlAction == SQLAction.VALUE) {
		// query.sqlAction = SQLAction.SELECT;
		// query.toSQL(sb, params, data, this);
		// query.sqlAction = SQLAction.VALUE;
		// } else
		toSQLinside(sb, params, data);
	}

	public void toSQLinside(StringBuilder sb, List<Object> params, Forest data) {
		table.toSQL(sb, params, data);
		sb.append('.');
		sb.append(member.columnName());
	}

	public Output invertForAssign() {
		IRelationship rel = (IRelationship) member;
		// SQLTable tab = new SQLTable(query, table.getEntityType());
		return new Output(rel.getInverse().columnName(), table.getKey());
	}

	public SQLQuery getQuery() {
		return table.getQuery();
	}

	@Override
	public SQLTable getBase(Env env) {
		return table.getBase(env);
	}

	public SQLTranslation dot(String field, ISchema schema, SQLQuery query,
			Env env, NormType normType) {
		if (getDataType() != null) {
			// fields of attributes are function calls
			// for example, date.Year
			return new Call(this, field, Call.NoArgs);
		} else {
			return super.dot(field, schema, query, env, normType);
		}
	}
}
