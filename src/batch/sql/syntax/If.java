// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.Op;
import batch.sql.schema.ISchema;
import batch.syntax.Eval;
import batch.util.BatchFactory;
import batch.util.Forest;

public class If extends Base {

	SQLTranslation cond;
	SQLTranslation thenExp;
	SQLTranslation elseExp;

	public If(SQLTranslation cond, SQLTranslation thenExp, SQLTranslation elseExp) {
		super();
		this.cond = cond;
		this.thenExp = thenExp;
		this.elseExp = elseExp;
	}

	public <E> E run(BatchFactory<E> f) {
		return f.If(cond.run(f), thenExp.run(f), elseExp.run(f));
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		boolean optCond = false;
		SQLTranslation newcond = cond
				.normalize(schema, query, null, env, normType);

		if (!(cond instanceof Output)) {
			// cannot optimize if bit is needed
			// note: normalization removed the Output node!
			SQLTable condTable = newcond.getTable();
			if (condTable == null) { // must be a boolean!
				boolean test = ((Boolean) newcond.run(new Eval()).evaluate(null, null, null))
						.booleanValue();
				if (test)
					return thenExp.normalize(schema, query, outerCond, env, normType);
				else
					return elseExp.normalize(schema, query, outerCond, env, normType);
			} else if (Factory.isSkip(elseExp)) {
				query.addWhere(newcond);
				optCond = true;
			} else if (Factory.isSkip(thenExp)) {
				query.addWhere(Factory.factory.Prim(Op.NOT, newcond));
				optCond = true;
			}
		}
		if (optCond) {
			thenExp.normalize(schema, query,
					batch.syntax.Factory.binary(Factory.factory, Op.AND, outerCond, cond), env,
					normType);
			SQLTranslation notCond = Factory.factory.Prim(Op.NOT, cond);
			elseExp.normalize(schema, query,
					batch.syntax.Factory.binary(Factory.factory, Op.AND, outerCond, notCond), env,
					normType);
			return Factory.factory.Skip();
		} else {
			SQLTranslation newthenExp = thenExp.normalize(schema, query, outerCond, env, normType);
			SQLTranslation newelseExp = elseExp.normalize(schema, query, outerCond, env, normType);
			return new If(newcond, newthenExp, newelseExp);
		}
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		sb.append("case when ");
		cond.toSQL(sb, params, data);
		sb.append(" then ");
		thenExp.toSQL(sb, params, data);
		sb.append(" else ");
		elseExp.toSQL(sb, params, data);
		sb.append(" end");
	}

	public SQLTable getTable() {
		throw new Error("TODO");
	}
}
