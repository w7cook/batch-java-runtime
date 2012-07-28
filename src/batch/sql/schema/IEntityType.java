package batch.sql.schema;

public interface IEntityType {

	 public String getTableName();

	 public IMember get(String name);

	 public IRelationship getRelationship(String name);

	 public IAttribute getKey();

}