// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.Forest;

/**
 * A Named exp indicates that the result of evaluating the inner
 * exp should be harvested in the forest.
 */
public class Output extends ValueExpression {

	private String location;
	private SQLTranslation exp;

	public Output(String location, SQLTranslation expr) {
		super();
		this.location = location;
		this.exp = expr;
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Out(location, exp.run(f));
	}

	public SQLTranslation getExpr() {
		return exp;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		SQLTranslation newexpr = exp.normalize(schema, query, outerCond, env,
				normType);
		SQLTable t = newexpr.getTable();
		// put in the right query, or the nearest query
		SQLQuery q = (t == null) ? query : t.getQuery();
		if (q.sqlAction == SQLAction.VALUE)
			q = query;
		if (newexpr instanceof SQLTable)
			newexpr = ((SQLTable)newexpr).getKey();
  	q.addProjection(new Output(location, newexpr));
		return newexpr;
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		SQLTranslation out = exp;

		// TODO: how do I get the type of a fiel???
		if (out instanceof Prim) {
			if (((Prim) out).getOp().isBoolean()) {
				BatchFactory<SQLTranslation> f = Factory.factory;
				out = f.If(out, f.Data(1), f.Data(0));
			}
		}

		out.toSQL(sb, params, data);
		sb.append(" AS ");
		sb.append(location);
	}

	public SQLTable getTable() {
		return exp.getTable();
	}

	@Override
	public SQLTranslation collectInsertArguments(String var, Call call) {
		if (exp instanceof Dot && ((Dot) exp).base instanceof Var
				&& ((Var) ((Dot) exp).base).name.equals(var)) {
			// check that the field is a key
			call.insertResultName = location;
			return null;
		} else
			return this;
	}
}
