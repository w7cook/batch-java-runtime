// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.util.BatchFactory;
import batch.util.ForestReader;

public class Input extends ValueExpression {

	String location;
	
	public Input(String location) {
		this.location = location;
		setValue();
	}

	public <E> E run(BatchFactory<E> f) {
		return f.In(location);
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, ForestReader data) {
		if (params != null) {
			params.add(data.get(location));
			sb.append("?");
		} else {
			Object param = data.get(location);
			new Constant(param).toSQL(sb, params, data);
		}
	}

}
