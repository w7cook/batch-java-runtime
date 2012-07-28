package batch.sql.schema.javareflect;

// required for interface

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import batch.sql.schema.IEntityType;
import batch.sql.schema.ISchema;
import batch.sql.syntax.Fun;
import batch.sql.syntax.SQLTranslation;

/**
 * Main Schema class representing the whole schema for the applicaton.
 * 
 */

public class Schema implements ISchema {

	Map<String, EntityType> entities = new HashMap<String, EntityType>();

	public Schema(Class<?> cls) {
		setup(cls);
	}

	public static IEntityType MakeGroupByEntityType(SQLTranslation group, IEntityType itemType, Fun alias) {
		return new EntityType(group, itemType, alias);
	}
	
	public void setup(Class<?> cls) {
		for (Field f : cls.getFields()) {
			String name = f.getName();
			addMember(name, f.getGenericType());
		}
		for (Method m : cls.getMethods()) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String name = m.getName();
			if (name.startsWith("insert") && m.getParameterTypes().length == 1)
				addMember(name, m.getParameterTypes()[0]);
			if (name.startsWith("get") && m.getParameterTypes().length == 0)
				addMember(name, m.getGenericReturnType());
		}
		for (EntityType e : entities.values())
			e.complete();
	}

	private void addMember(String name, Type type) {
		if (type instanceof ParameterizedType) {
			type = ((ParameterizedType) type).getActualTypeArguments()[0];
		}
		entities.put(name, createEntityTypeFromJavaType(type));
	}

	public EntityType createEntityTypeFromJavaType(Type type) {
		Type rawType = type;
		if (type instanceof ParameterizedType)
			rawType = ((ParameterizedType) type).getRawType();
		Class<?> cls = (Class<?>) rawType;
		String name = cls.getSimpleName();
		EntityType e = entities.get(name);
		if (e == null) {
			e = new EntityType(this, name);
			entities.put(name, e);
			e.load(cls);
		}
		return e;
	}

	@Override
	public IEntityType getEntity(String name) {
		IEntityType e = entities.get(name);
		if (e == null)
			throw new Error("Missing entity type " + name);
		return e;
	}
}
