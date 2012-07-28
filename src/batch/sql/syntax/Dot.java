// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import batch.sql.schema.IAlias;
import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.schema.IRelationship;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;

public class Dot extends ValueExpression {
	SQLTranslation base;
	String field;
	IEntityType actualType;
	boolean singleValued;

	public Dot(SQLTranslation base, String field) {
		super();
		this.base = base;
		this.field = field;
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		if (Factory.isRoot(base)) {
			return new SQLTable(query, schema.getEntity(field));
		} else {
			SQLTranslation newbase = base.normalize(schema, query, null, env, normType);
			return newbase.dot(field, schema, query, env, normType);
		}
	}

	@Override
	public SQLTable getTableNoJoins(Env env) {
		if (Factory.isRoot(base))
			return null;
		else {
			SQLTable baseTable = base.getTableNoJoins(env);
			IEntityType entityType = baseTable.getEntityType();
			IRelationship rel = entityType.getRelationship(field);
			return new SQLTable(baseTable.getQuery(), rel.toType());
		}
	}

	@Override
	public SQLTranslation invertPath(SQLTranslation inverted, Env env, boolean fromChild) {
		SQLTable source = base.getTableNoJoins(env);
		if (source == null)
			return null;
		// special case when the source table does does not
		// have a single primary key: if its a many to
		// many connection table. We cannot use it as the
		// base for a correlated subquery
		if (fromChild && source.IsKeylessTable())
			return base.invertPath(inverted, env, fromChild);
		IEntityType sourceEntity = source.getEntityType();
		IRelationship rel = sourceEntity.getRelationship(field);
		IMember inverse = rel.getInverse();
		SQLTranslation path = inverted;
		if (inverse instanceof IAlias) {
			if (fromChild) {
				Fun fun = ((IAlias) inverse).getExpr();
				path = fun.apply(inverted);
			}
		} else
			path = new Dot(inverted, inverse.getName());
		return base.invertPath(path, env, fromChild);
	}

	public SQLTranslation trimLast(Env env) {
		SQLTable source = base.getTableNoJoins(env);
		// special case when the source table does does not
		// have a single primary key: if its a many to
		// many connection table. We cannot use it as the
		// base for a correlated subquery
		if (source.IsKeylessTable())
			return this;
		else
			return base.trimLast(env);
	}

	@Override
	public SQLTable getBase(Env env) {
		return base.getBase(env);
	}

	public <E> E run(BatchFactory<E> f) {
		return f.Prop(base.run(f), field);
	}

}
