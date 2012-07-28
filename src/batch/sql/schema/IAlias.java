package batch.sql.schema;

import batch.sql.syntax.Fun;

public interface IAlias extends IMember {

	public abstract Fun getExpr();

}