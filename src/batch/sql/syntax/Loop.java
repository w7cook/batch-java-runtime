// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import batch.Op;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;

public class Loop extends Base {

	Op op;
	String var;
	SQLTranslation collection;
	SQLTranslation body;
	SQLTranslation testId; // ID for testing

	public Loop(String var, SQLTranslation collection, SQLTranslation body) {
		super();
		this.var = var;
		this.collection = collection;
		this.body = body;
		op = Op.SEQ;
		collection.setValue();
	}
	
  public void setValue() {
    super.setValue();
    body.setValue();
  }

	public Loop setOp(Op op) {
		this.op = op;
		return this;
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Loop(var, collection.run(f), body.run(f));
	}

	public String getVar() {
		return var;
	}

	@Override
	public SQLTranslation getTransformations(SQLTranslation base) {
		return collection.getTransformations(base);
	}

	/*
	 * TODO: FIRST and LAST are missing still
	 */
	public String getAggOp() {
		switch (op) {
		case ADD:
			return "SUM";
		case AVG:
			return "AVG";
		case MIN:
			return "MIN";
		case MAX:
			return "MAX";
		case COUNT:
			return "COUNT";
		case OR:
			return "EXISTS";
		case AND:
			return "NOT EXISTS"; // have to use AND(x,y) = NOT(OR(NOT(x),NOT(y))
		}
		return null;
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery parentQuery,
			SQLTranslation outerCond, Env env, NormType normType) {
		// use the outer condition!!!
		SQLAction sqlAction = SQLAction.NONE;
		if (getAggOp() != null)
			sqlAction = SQLAction.SELECT;
		else if (isValue)
			sqlAction = SQLAction.VALUE;
		SQLQuery query = new SQLQuery(schema, this, sqlAction, isValue,
				parentQuery);
		Env nenv;
		SQLTranslation inv = collection.invertPath(new Var(var), env, true);
		// find the root table that we are connected to
		if (inv != null) {
			// if it has an inverse, then it is not a query off the root
			if (isValue || getAggOp() != null) {
				/*
				 * SQLTable tables = parentQuery.tables.makeNestedRoot(query);
				 * query.setTables(tables); SQLTranslation parenTab =
				 * parentQuery.getTransformations(tables); Env env3 = new
				 * Env(parentQuery.getVar(), parenTab, env);
				 */
				// make a select as a sub-exp
				SQLTable tableFromParent = collection.getBase(env);
				parentQuery = tableFromParent.getQuery();
				query.setContainer(parentQuery);
				SQLTable tables = tableFromParent.makeNestedRoot(query);
				query.setTables(tables);
				Env env3 = new Env(parentQuery.getVar(), tables, env);
				SQLTranslation norm = collection.normalize(schema, query, null, env3,
						NormType.NORMAL);
				nenv = new Env(var, norm.getTable(), env);
			} else {
				// make a separate correlated subquery

				// find out what our table really is
				SQLTranslation simpleCol = collection.withoutTransformations();
				// table from parent is the table for this query, defined in the context
				// of the parent. But we don't want to join it into the parent query
				// (becaise its many-valued)
				SQLTable tableFromParent = simpleCol.getTableNoJoins(env);
				parentQuery = tableFromParent.getQuery();

				query.setContainer(parentQuery);

				// create a base table for us. This is disconnected from the parent
				// query
				SQLTable tables = new SQLTable(query, tableFromParent.getEntityType());
				// set the new table as our base query
				query.setTables(tables);
				// do group-by etc.
				SQLTable tab = collection.getTransformations(tables)
						.normalize(schema, query, null, env, NormType.NORMAL).getTable();

				// correlate subqueries have a master-detail relationship to
				// their parent query. Here we set up the foreign key for this link.
				Env env2 = new Env(var, tables, env);
				SQLTranslation base = inv.normalize(schema, query, null, env2,
						NormType.PARENT);

				// this is really quite subtle
				SQLTranslation invPartial = parentQuery.getTransformations(collection
						.invertPath(new Var(var), env, false));
				// false = return actual parent base table without Calls

				// tab is now the actual value that is iterated over in this loop
				nenv = new Env(var, tab, env);
				nenv = new Env(parentQuery.getVar(), invPartial, nenv);
				// be sure to sort by the parent after everything else
				// setParent must follow the outerQuery.applyTransformations
				query.setParent(base);
				// mark this as a sub-query
				SQLTranslation parentBase = collection.trimLast(env);
				parentQuery.addSubquery(query, parentBase);

				// add the parent where clause here!!!
				if (outerCond != null) {
					// translate the outer query condition down to our table
					// using the inverse of the path
					outerCond.toString();
					SQLTranslation e = outerCond.normalize(schema, query, null, nenv,
							normType);
					query.addWhere(e);
				}
			}
		} else {
			// just query from a table directly
			// need a dummy environment so that it will put things in this query
			SQLTranslation norm = collection.normalize(schema, query, null, env,
					normType);
			SQLTable table = norm.getTable();
			if (table.getQuery() != query) {
				query = table.getQuery();
				query.var = var;
			} else
				query.setTables(table.getRealTable());
			nenv = new Env(var, table, env);
//			if (!isValue && getAggOp() == null)
				env.getRootQuery().addSubquery(query, null);
		}
		query.env = nenv;
		SQLTranslation newbody = body.normalize(schema, query, outerCond, nenv,
				normType);
		return query.finalize(newbody, testId);
	}

	@Override
	public SQLTable getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLTable getTableNoJoins(Env env) {
		return collection.getTableNoJoins(env);
	}

	public void setId(SQLTranslation id) {
		testId = id;
	}

	public SQLTranslation getBody() {
		return body;
	}

	public Op getOp() {
		return op;
	}
}
