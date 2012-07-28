package batch.sql.schema;

import batch.DataType;

public interface IAttribute extends IMember {

	public DataType getType();

	public boolean isKey();
}