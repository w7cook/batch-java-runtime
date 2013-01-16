// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.ForestReader;

public class Var extends ValueExpression {

	String name;

	public Var(String name) {
		super();
		this.name = name;
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Var(name);
	}

	@Override
	public SQLTable getTableNoJoins(Env env) {
		if (Factory.isRoot(this))
			return null;
		else
			return env.lookup(name).getTableNoJoins(env);
	}
	
	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query, SQLTranslation outerCond, Env env, NormType normType) {
		return env.lookup(name).normalize(schema, query, null, env, NormType.EXTERNAL);
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, ForestReader data) {
		sb.append(name);
	}

	@Override
	public SQLTranslation invertPath(SQLTranslation inverted, Env env, boolean fromChild) {
		return inverted;
	}

	@Override
	public SQLTranslation trimLast(Env env) {
		return this;
	}

	@Override
	public SQLTable getBase(Env env) {
		return (SQLTable)env.lookup(name).getBase(env);
	}
}
