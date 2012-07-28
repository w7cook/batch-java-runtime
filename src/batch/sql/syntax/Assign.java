// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.Op;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.Forest;

public class Assign extends Action {

	Op op;
	SQLTranslation target;
	SQLTranslation source;

	public Assign(Op op, SQLTranslation target, SQLTranslation source) {
		this.op = op;
		this.target = target;
		this.source = source;
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		SQLTranslation targ = target.normalize(schema, query, null, env, normType);
		SQLTranslation src = source.normalize(schema, query, null, env, normType);
		Assign newAction = new Assign(op, targ, src);
		targ.getTable().getQuery().doAction(SQLAction.UPDATE, newAction);
		return this;
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		target.toSQL(sb, params, data);
		sb.append('=');
		source.toSQL(sb, params, data);
	}

	public SQLTable getTable() {
		throw new Error("TODO");
	}

	@Override
	public <E> E run(BatchFactory<E> f) {
		return f.Assign(op, target.run(f), source.run(f));
	}

	@Override
	public SQLTranslation collectInsertArguments(String var, Call call) {
		if (target instanceof Dot && ((Dot) target).base instanceof Var
				&& ((Var) ((Dot) target).base).name.equals(var)) {
			
			call.args.add(new Output(((Dot) target).field, source));
			return null;
		} else
			return this;
	}
}
