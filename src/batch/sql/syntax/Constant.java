// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.util.BatchFactory;
import batch.util.Forest;

public class Constant extends ValueExpression {

	Object value;

	public Constant(Object value) {
		this.value = value;
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		if (value == null) {
			sb.append("NULL");
		} else if (value instanceof String) {
			sb.append('"');
			// Is this safe??
			String str = (String) value;
//			str = str.replaceAll("\\", "\\\\").replaceAll("\"", "\\\"");
			sb.append(str); 
			sb.append('"');
		} else if (value instanceof java.sql.Date
				|| value instanceof java.sql.Time
				|| value instanceof java.sql.Timestamp) {
			sb.append('\'');
			sb.append(value);
			sb.append('\'');
		} else if (value instanceof java.util.Date) {
			sb.append('\'');
			sb.append(new java.sql.Timestamp(((java.util.Date) value).getTime()));
			sb.append('\'');
		} else {
			sb.append(value.toString());
		}
	}
	public <E> E run(BatchFactory<E> f) {
		return f.Data(value);
	}
}
