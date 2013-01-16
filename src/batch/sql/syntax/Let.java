// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import batch.sql.schema.ISchema;
import batch.util.BatchFactory;

public class Let extends Base {
	private String var;
	private SQLTranslation exp;
	private SQLTranslation body;


	public Let(String var, SQLTranslation expression, SQLTranslation body) {
		super();
		this.var = var;
		this.exp = expression;
		this.body = body;
		exp.setValue();
	}

  public void setValue() {
    super.setValue();
    body.setValue();
  }


	public <E> E run(BatchFactory<E> f) {
		return f.Let(var, exp.run(f), body.run(f));
	}


	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		// use the outer condition!!!
		SQLTranslation newexp = exp
				.normalize(schema, query, null, env, normType);
		// TODO: this is buggy.. why should I do this?
		// if (exp instanceof Loop)
		// exp = ((Loop)exp).getBody();
		Env nenv = new Env(var, newexp, env);
		if (newexp instanceof SQLQuery) {
		  query = (SQLQuery)newexp;
		  query.isValue = false;
		  query.singleRow = true;
		}
		else
	    query = newexp.getTable().getQuery();

		// WHAT TO DO!!!
		return body.normalize(schema, query, outerCond, nenv, normType);
	}

	@Override
	public SQLTable getTable() {
		throw new Error("should never happen");
	}

	@Override
	public SQLTranslation invertPath(SQLTranslation inverted, Env env, boolean fromChild) {
		Env nenv = new Env(var, exp, env);
		return body.invertPath(inverted, nenv, fromChild);
	}

	@Override
	public SQLTranslation trimLast(Env env) {
		return body.trimLast(env);
	}
}
