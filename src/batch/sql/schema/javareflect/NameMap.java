package batch.sql.schema.javareflect;

import java.util.HashMap;

/**
 * Named Map
 * 
 * Implements a name map, i.e. a map where the keys are case-insensitive
 * strings.
 */
@SuppressWarnings("serial")
class NameMap<T> extends HashMap<String, T> {
	/**
	 * Override get to use case-insensitive keys.
	 */
	public T get(String key) {
		return super.get(key.toLowerCase());
	}

	/**
	 * Override put to include run-time type checking and use of
	 * case-insensitive keys.
	 */
	@Override
	public T put(String key, T value) {
		return super.put(key.toLowerCase(), value);
	}
}
