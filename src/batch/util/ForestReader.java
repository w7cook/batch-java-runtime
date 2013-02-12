package batch.util;


public interface ForestReader {

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  Object get(String variable);

  int getByte(String variable);

  short getShort(String variable);

  int getInteger(String variable);

  long getLong(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  double getDouble(String variable);

  float getFloat(String variable);

  java.math.BigDecimal getBigDecimal(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  String getString(String variable);

  char getCharacter(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  boolean getBoolean(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  java.sql.Date getDate(String variable);

  java.util.Date getUtilDate(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  java.sql.Time getTime(String variable);

  /**
   * Retrieves the object value of the given variable name.
   * 
   * @param variable
   *            the name of the variable
   * @return the object value of the given variable name.
   */
  java.sql.Timestamp getTimestamp(String variable);

  byte[] getRawData(String variable);

  /**
   * Retrieves the iteration of the given variable name.
   * 
   * @param variable
   *            the name of the variable.
   * @return the iteration object of the given variable name.
   */
  Iterable<ForestReader> getTable(String variable);

  void complete();

  void copyTo(ForestWriter out);
}