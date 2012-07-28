package batch.sql.schema;

public interface IRelationship extends IMember {

	public IMember getInverse();

	public boolean singleValued();

	public IEntityType toType();

}