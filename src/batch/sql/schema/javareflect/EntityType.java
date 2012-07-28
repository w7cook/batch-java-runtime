package batch.sql.schema.javareflect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import batch.DataType;
import batch.sql.Column;
import batch.sql.Inverse;
import batch.sql.schema.IAttribute;
import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.syntax.Fun;
import batch.sql.syntax.SQLTranslation;

class EntityType implements IEntityType {

	Schema schema;
	String name;
	String tableName;
	IAttribute key;
	Map<String, Member> members = new HashMap<String, Member>();

	public EntityType(Schema schema, String name) {
		this.schema = schema;
		this.name = name;
	}

	// this is used to create the virtual entity
	// representing a GroupBy value, with 
	// a Key and Items properties
	public EntityType(SQLTranslation group, IEntityType itemType, Fun alias) {
		members.put("Key", new Alias("Key", new Fun("x", group)));
		Relationship rel = new Relationship("Items", null, true, itemType, null);
		rel.setInverse(new Alias("INV", alias));
		members.put("Items", rel);
	}
	
	public String toString() {
		return "Entity-" + name;
	}

	public void load(Class<?> cls) {
		batch.sql.Entity annot = cls.getAnnotation(batch.sql.Entity.class);
		if (annot != null)
			tableName = annot.name();
		else
			tableName = name;
		for (Field f : cls.getFields()) {
			String name = f.getName();
			addMember(name, f.getGenericType(), f);
		}
		for (Method m : cls.getMethods()) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String name = m.getName();
			if (name.startsWith("get") && m.getParameterTypes().length == 0)
				addMember(name, m.getGenericReturnType(), m);
		}
	}

	void complete() {
		for (Member m : members.values()) {
			m.complete();
			if (key == null
					&& m instanceof Attribute
					&& (m.getName().startsWith(tableName) || m.getName()
							.startsWith(name)))
				key = (IAttribute) m;
		}
	}

	private void addMember(String name, Type type, AnnotatedElement elem) {
		// TODO Auto-generated method stub
		boolean manyValued = false;
		if (type instanceof ParameterizedType) {
			manyValued = true;
			type = ((ParameterizedType) type).getActualTypeArguments()[0];
		}
		String columnName = null;
		Column column = elem.getAnnotation(Column.class);
		if (column != null)
			columnName = column.name();
		else if (!manyValued)
			columnName = name.startsWith("get") ? name.substring(3) : name;

		DataType primType = DataType.fromJavaType(type);
		if (primType != null) {
			if (columnName == null)
				columnName = name;
			Attribute attr = new Attribute(name, columnName, primType);
			members.put(name, attr);
			if (elem.isAnnotationPresent(batch.sql.Id.class)) {
				key = attr;
				attr.isKey = true;
			}
		} else {
			Inverse inverse = elem.getAnnotation(Inverse.class);
			String inverseName = null;
			if (inverse != null)
				inverseName = inverse.value();

			IEntityType toEntity = schema.createEntityTypeFromJavaType(type);
			members.put(name, new Relationship(name,
					columnName,
					manyValued,
					toEntity,
					inverseName));
		}
	}

	@Override
	public IMember get(String name) {
		IMember mem = members.get(name);
		if (mem == null)
			throw new Error("Unknow field: " + name + " of " + this.name);
		return mem;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public Relationship getRelationship(String name) {
		IMember m = members.get(name);
		if (m instanceof Relationship)
			return (Relationship) m;
  	throw new Error("missing relationship " + name);
	}

	@Override
	public IAttribute getKey() {
		return key;
	}

}