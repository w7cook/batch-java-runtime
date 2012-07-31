// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// integer, double, decimal, date, time, datetime, string, blob

class ForestFactory implements DynamicFactory<Forest> {
	public Forest make(String kind) {
		return new Forest();
	}
}

public class Forest implements ExpressionBuilder<Forest>, DumpExpression {

	public static DynamicFactory<Forest> dynamicFactory = new ForestFactory();

	// instance variables
	private Map<String, Object> values;
	private Map<String, MultiForest> iterations;
	private Forest parent;

	/**
	 * Default constructor
	 */
	public Forest() {
		this.values = new HashMap<String, Object>();
		this.iterations = new HashMap<String, MultiForest>();
	}

	public void setParent(Forest parent) {
		this.parent = parent;
	}

	public void put(String name, Object value) {
// Feature: ENUM turned off
//		if (value instanceof Enum)
//			value = value.toString();
		values.put(name, value);
	}

	/**
	 * Puts a variable/value pair into the values store.
	 * 
	 * @param variable
	 *            the name of the variable.
	 * @param value
	 *            the value of the variable.
	 */
	public void putField(String variable, Object value) {
		values.put(variable, value);
	}

	public void putElement(String field, Forest value) {
		MultiForest list = iterations.get(field);
		if (list == null) {
			list = new MultiForest(this);
			iterations.put(field, list);
		}
		value.setParent(this);
		list.add(value);
	}

	public void putElement(Forest value) {
		throw new Error("cannot add unnamed elements into a forest");
	}

	/**
	 * Creates a new iteration object and inserts it into the iteration store
	 * for the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable.
	 * @return a new iteration object for the given variable name.
	 */
	public MultiForest newCollection(String variable) {
		final MultiForest iteration = new MultiForest(this);
		iterations.put(variable, iteration);
		return iteration;
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public Object get(String variable) {
		Object val = values.get(variable);
    if (val == null && parent != null)
      val = parent.get(variable);
    if (val instanceof Error)
      throw (Error)val;
    else if (val instanceof RuntimeException)
      throw (RuntimeException)val;
    else
      return val;
	}

	public int getByte(String variable) {
		return ((java.lang.Number) get(variable)).byteValue();
	}

	public short getShort(String variable) {
		return ((java.lang.Number) get(variable)).shortValue();
	}

	public int getInteger(String variable) {
		return ((java.lang.Number) get(variable)).intValue();
	}

	public long getLong(String variable) {
		return ((java.lang.Number) get(variable)).longValue();
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public double getDouble(String variable) {
		return ((java.lang.Number) get(variable)).doubleValue();
	}

	public float getFloat(String variable) {
		return ((java.lang.Number) get(variable)).floatValue();
	}

	public java.math.BigDecimal getBigDecimal(String variable) {
		return (java.math.BigDecimal) get(variable);
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public String getString(String variable) {
		Object val = get(variable);
		if (val == null)
			return null;
		else
			return val.toString();
	}

	public char getCharacter(String variable) {
		return get(variable).toString().charAt(0);
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public boolean getBoolean(String variable) {
		Object v = get(variable);
		if (v instanceof java.lang.Boolean)
			return (java.lang.Boolean) v;
		if (v instanceof java.lang.Number)
			return !((java.lang.Number) v).equals(0);
		return java.lang.Boolean.getBoolean(v.toString());
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public java.sql.Date getDate(String variable) {
		Object val = get(variable);
		if (val instanceof java.sql.Date)
			return (java.sql.Date) val;
		else if (val instanceof java.sql.Timestamp)
			return new java.sql.Date(((java.sql.Timestamp) val).getTime());
		else
			return java.sql.Date.valueOf(val.toString());
	}

	public java.util.Date getUtilDate(String variable) {
		return (java.util.Date) get(variable);
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public java.sql.Time getTime(String variable) {
		return (java.sql.Time) get(variable);
	}

	/**
	 * Retrieves the object value of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable
	 * @return the object value of the given variable name.
	 */
	public java.sql.Timestamp getTimestamp(String variable) {
		return (java.sql.Timestamp) get(variable);
	}

	public byte[] getRawData(String variable) {
		return (byte[]) get(variable);
	}

	/**
	 * Retrieves the iteration of the given variable name.
	 * 
	 * @param variable
	 *            the name of the variable.
	 * @return the iteration object of the given variable name.
	 */
	public MultiForest getIteration(String variable) {
		MultiForest mf = iterations.get(variable);
		if (mf == null && parent != null)
			mf = parent.getIteration(variable);
		return mf;
	}

	public boolean isEmpty() {
		return values.size() == 0 && iterations.size() == 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (values.size() > 0)
			sb.append(values.toString());
		if (iterations.size() > 0)
			sb.append(iterations.toString());
		return sb.toString();
	}

	public Forest complete() {
		return this;
	}

	public void dump(BatchDumper d, Object flag) throws IOException {
	  if (!isEmpty()) {
  		d.start(null);
  		for (Map.Entry<String, Object> entry : values.entrySet())
  			d.putData(entry.getKey(), entry.getValue());
  		for (Map.Entry<String, MultiForest> entry : iterations.entrySet()) {
  			d.beginList(entry.getKey());
  			entry.getValue().putItems(d);
  			d.endList();
  		}
  		d.end();
	  }
	}
}
