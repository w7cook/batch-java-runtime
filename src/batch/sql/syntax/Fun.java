// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import batch.util.BatchFactory;


public class Fun extends ValueExpression {
	String var;
	SQLTranslation body;
	
	public Fun(String var, SQLTranslation body) {
		super();
		this.var = var;
		this.body = body;
	}

	public String getVar() {
		return var;
	}

	public SQLTranslation getBody() {
		return body;
	}

	public SQLTranslation apply(SQLTranslation value) {
		return batch.sql.syntax.Factory.factory.Let(var, value, body);
	}

  @Override
  public <E> E run(BatchFactory<E> f) {
    return f.Fun(var, body.run(f));
  }

}
