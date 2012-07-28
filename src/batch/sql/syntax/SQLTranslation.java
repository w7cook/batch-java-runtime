package batch.sql.syntax;

import java.util.List;

import batch.sql.schema.ISchema;
import batch.syntax.Expression;
import batch.util.Forest;

public interface SQLTranslation extends Expression {
	public enum NormType {
		NORMAL, PARENT, EXTERNAL
	}

	public enum SQLAction {
		NONE, VALUE, SELECT, INSERT, UPDATE, DELETE
	}

	public abstract SQLTable getTable();

	public abstract SQLTranslation invertPath(SQLTranslation inverted, Env env,
			boolean fromChild);

	public abstract SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType);

	public abstract void toSQL(StringBuilder sb, List<Object> params, Forest data);

	public abstract SQLTable getTableNoJoins(Env env);

	public abstract SQLTable getBase(Env env);

	public abstract SQLTranslation withoutTransformations();

	public abstract SQLTranslation getTransformations(SQLTranslation base);

	public abstract SQLTranslation trimLast(Env env);

	public abstract SQLTranslation collectInsertArguments(String var,
			batch.sql.syntax.Call call);

	public abstract SQLTranslation dot(String field, ISchema schema,
			SQLQuery query, Env env, NormType normType);

}