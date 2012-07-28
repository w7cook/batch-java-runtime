// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.io.IOException;

import batch.DataType;

public abstract class TransportHelper {

	public String storeData(DataType type, Object value) throws IOException {
		if (type == DataType.Datetime && 
				value instanceof java.util.Date) {
			// make sure it formats correctly
			value = new java.sql.Timestamp(((java.util.Date) value).getTime());
		}
		else if (type == DataType.RawData) {
		  value = javax.xml.bind.DatatypeConverter.printBase64Binary((byte[]) value);
		}
		return String.valueOf(value);
	}

	protected Object loadData(String typeName, String data) throws IOException {
		DataType type = DataType.valueOf(typeName);
		if (type == null)
			throw new IOException("Unknown type " + type);
		return loadData(type, data);
	}

	protected Object loadData(DataType type, String data) throws IOException {
		switch (type) {
		case String:
			return data;
		case Integer:
			return Long.valueOf(data);
		case Boolean:
			return Boolean.valueOf(data);
		case Float:
			return Double.valueOf(data);
		case Date:
			return java.sql.Date.valueOf(data);
		case Time:
			return java.sql.Time.valueOf(data);
		case RawData:
      return javax.xml.bind.DatatypeConverter.parseBase64Binary(data);
		case Datetime:
			return java.sql.Timestamp.valueOf(data);
		case Decimal:
			return new java.math.BigDecimal(data);
		}
		return null;
	}
}
