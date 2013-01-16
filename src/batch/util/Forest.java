// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// integer, double, decimal, date, time, datetime, string, blob


public class Forest implements ForestReader, ForestWriter {

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
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *          the name of the variable
   * @return the object value of the given variable name.
   */
  public Object get(String variable) {
    Object val = values.get(variable);
    if (val == null && parent != null)
      val = parent.get(variable);
    if (val instanceof Error)
      throw (Error) val;
    else if (val instanceof RuntimeException)
      throw (RuntimeException) val;
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
   *          the name of the variable
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
   *          the name of the variable
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
   *          the name of the variable
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
   *          the name of the variable
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
   *          the name of the variable
   * @return the object value of the given variable name.
   */
  public java.sql.Time getTime(String variable) {
    return (java.sql.Time) get(variable);
  }

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *          the name of the variable
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
   *          the name of the variable.
   * @return the iteration object of the given variable name.
   */
  public Iterable<ForestReader> getTable(String variable) {
    MultiForest mf = iterations.get(variable);
    if (mf == null && parent != null)
      return parent.getTable(variable);
    else
      return mf;
  }

  // only used for when you want to read and write
  public Iterator<Forest> getForestIteration(String variable) {
    MultiForest mf = iterations.get(variable);
    if (mf == null && parent != null)
      return parent.getForestIteration(variable);
    else
      return mf.forestIterator();
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

  /**
   * Creates a new iteration object and inserts it into the iteration store for
   * the given variable name.
   * 
   * @param variable
   *          the name of the variable.
   * @return a new iteration object for the given variable name.
   */
  @Override
  public ForestListWriter newTable(String variable) {
    return newForestIteration(variable);
  }

  public MultiForest newForestIteration(String variable) {
    final MultiForest iteration = new MultiForest(this);
    iterations.put(variable, iteration);
    return iteration;
  }

  @Override
  public void complete() {
    // TODO Auto-generated method stub
    
  }

  public void copyTo(ForestWriter out) {
    for (Map.Entry<String, Object> e : values.entrySet())
      out.put(e.getKey(), e.getValue());
    for (Map.Entry<String, MultiForest> e : iterations.entrySet())
      e.getValue().copyTo( out.newTable(e.getKey()));
  }

}
