package batch.sql.schema.javareflect;

import batch.sql.schema.IAlias;
import batch.sql.syntax.Fun;

// this is relationshipAlias
class Alias extends Member implements IAlias {

	Fun expr;

	protected Alias(String name, Fun expr) {
		super(name, null);
		this.expr = expr;
	}

	@Override
	public Fun getExpr() {
		return expr;
	}
}
