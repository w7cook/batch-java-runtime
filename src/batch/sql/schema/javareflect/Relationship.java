package batch.sql.schema.javareflect;

import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.schema.IRelationship;

/**
 * Relationship object in the schema that represents many-to-one, one-to-many
 * relationships. Many-to-Many relationships are represented as relationship
 * alias object.
 */
class Relationship extends Member implements IRelationship {

	boolean many;
	IEntityType toType;
	IMember inverse;
	String inverseName;

	protected Relationship(String name, String columnName,
			boolean many, IEntityType toType, String inverseName) {
		super(name, columnName);
		this.many = many;
		this.toType = toType;
		this.inverseName = inverseName;
	}

	@Override
	public void complete() {
		if (inverseName != null) {
			inverse = toType.getRelationship(inverseName);
  		((Relationship)inverse).setInverse(this);
		}
	}

	public void setInverse(IMember inverse) {
		this.inverse = inverse;
	}

	@Override
	public IMember getInverse() {
		return inverse;
	}

	@Override
	public boolean singleValued() {
		return !many;
	}

	@Override
	public IEntityType toType() {
		return toType;
	}

}