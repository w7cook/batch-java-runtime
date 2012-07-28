package batch.sql.schema.javareflect;

import batch.DataType;
import batch.sql.schema.IAttribute;

/**
 * Attribute Object that represents the normal fields in schema.
 */
class Attribute extends Member implements IAttribute {
	
	DataType type;
	public boolean isKey;
	
	@Override
	public DataType getType() {
		return type;
	}

	protected Attribute(String name, String columnName, DataType type) {
		super(name, columnName);
		this.type = type;
	}

	@Override
	public boolean isKey() {
		return isKey;
	}

}
