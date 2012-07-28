package batch.sql.schema.javareflect;

import batch.sql.schema.IMember;
import batch.sql.schema.ISchema;

/**
 * The base class representing a field in the schema. Attribute, Relationship,
 * Alias are inherited from this base class.
 */
abstract class Member implements IMember {

	ISchema schmea;
	String name;
	String columnName;

	protected Member(String name, String columnName) {
		super();
		this.name = name;
		this.columnName = columnName;
	}

	public void complete() {
	}

	public String toString() {
		return "Attr-" + name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String columnName() {
		return columnName;
	}

}
