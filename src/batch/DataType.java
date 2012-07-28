// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

// these are the supported data types
public enum DataType {
  Null, // a null value
  Boolean, // boolean
  String, // String, char
  Integer, // int, short, long, byte
  Float, // double, float
  Decimal, // precise decimal
  Date, Time, Datetime, // dates
  RawData // binary blocks of data
  // Any // unknown
  ;

  public static DataType fromJava(Object value) {
    DataType type = maybeType(value);
    if (type == null)
      throw new Error("Unknown type: " + value.getClass());
    return type;
  }

  public static DataType maybeType(Object value) {
    if (value == null)
      return Null;
    return fromJavaType(value.getClass());
  }

  public static DataType fromJavaType(Type javaType) {
    if (javaType == String.class)
      return String;
    else if (javaType == byte.class || javaType == short.class
        || javaType == long.class || javaType == int.class
        || javaType == Byte.class || javaType == Short.class
        || javaType == Long.class || javaType == Integer.class)
      return Integer;
    else if (javaType == boolean.class || javaType == Boolean.class)
      return Boolean;
    else if (javaType == float.class || javaType == double.class
        || javaType == Float.class || javaType == Double.class)
      return Float;
    else if (javaType == java.math.BigDecimal.class)
      return Decimal;
    else if (javaType == java.sql.Date.class)
      return Date;
    else if (javaType == java.sql.Time.class)
      return Time;
    else if (javaType == java.sql.Timestamp.class
        || javaType == java.util.Date.class)
      return Datetime;
    else if (javaType == byte[].class)
      return RawData;
    else
      return null;
  }

  static Map<String, DataType> typeNames;

  public static DataType fromString(String typeName) {
    if (typeNames == null) {
      typeNames = new HashMap<String, DataType>();
      addName(Null);
      addName(String);
      addName(Integer);
      addName(Boolean);
      addName(Float);
      addName(Decimal);
      addName(Date);
      addName(Time);
      addName(Datetime);
      addName(RawData);
    }
    return typeNames.get(typeName);
  }

  private static void addName(DataType type) {
    typeNames.put(type.toString(), type);
  }

};
