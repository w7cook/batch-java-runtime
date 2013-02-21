package batch.util;

import java.math.BigDecimal;

public abstract class ForestReaderHelper implements ForestReader {

  @Override
  public int getByte(String variable) {
    return ((Number) get(variable)).byteValue();
  }

  @Override
  public short getShort(String variable) {
    return ((Number) get(variable)).shortValue();
  }

  @Override
  public int getInteger(String variable) {
    return ((Number) get(variable)).intValue();
  }

  @Override
  public long getLong(String variable) {
    return ((Number) get(variable)).longValue();
  }

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *          the name of the variable
   * @return the object value of the given variable name.
   */
  @Override
  public double getDouble(String variable) {
    return ((Number) get(variable)).doubleValue();
  }

  @Override
  public float getFloat(String variable) {
    return ((Number) get(variable)).floatValue();
  }

  @Override
  public BigDecimal getBigDecimal(String variable) {
    Object val = get(variable);
    if (!(val instanceof BigDecimal)) {
      if (val instanceof Long) {
        val = new BigDecimal(((Number)val).longValue());
      } else {
        val = new BigDecimal(((Number)val).doubleValue());
      }
    }
    return (BigDecimal)val;
  }

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *          the name of the variable
   * @return the object value of the given variable name.
   */
  @Override
  public String getString(String variable) {
    Object val = get(variable);
    if (val == null)
      return null;
    else
      return val.toString();
  }

  @Override
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
  @Override
  public boolean getBoolean(String variable) {
    Object v = get(variable);
    if (v instanceof Boolean)
      return (Boolean) v;
    if (v instanceof Number)
      return !((Number) v).equals(0);
    return Boolean.getBoolean(v.toString());
  }

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *          the name of the variable
   * @return the object value of the given variable name.
   */
  @Override
  public java.sql.Date getDate(String variable) {
    Object val = get(variable);
    if (val instanceof java.sql.Date)
      return (java.sql.Date) val;
    else if (val instanceof java.sql.Timestamp)
      return new java.sql.Date(((java.sql.Timestamp) val).getTime());
    else
      return java.sql.Date.valueOf(val.toString());
  }

  @Override
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
  @Override
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
  @Override
  public java.sql.Timestamp getTimestamp(String variable) {
    return (java.sql.Timestamp) get(variable);
  }

  @Override
  public byte[] getRawData(String variable) {
    return (byte[]) get(variable);
  }
}
