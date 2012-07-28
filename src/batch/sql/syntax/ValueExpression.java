// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import batch.sql.schema.ISchema;


public abstract class ValueExpression extends Base {

	@Override
	public SQLTranslation normalize(ISchema schema,
			SQLQuery query,
			SQLTranslation outerCond,
			Env env, NormType normType) {
		return this;
	}

	public SQLTable getTable() {
		return null;
	}
}
