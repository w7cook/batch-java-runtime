package batch.syntax;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import batch.Op;
import batch.util.BatchFactoryHelper;

abstract class TypeGetter {
	abstract public Class<?> getType(Map<String, Class<?>> typeEnv);
}

public class GetType extends BatchFactoryHelper<TypeGetter> {

	@Override
	public TypeGetter Var(final String name) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				return typeEnv.get(name);
			}
		};
	}

	@Override
	public TypeGetter Data(final Object value) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				return value.getClass();
			}
		};
	}

	@Override
	public TypeGetter Fun(final String var, final TypeGetter body) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				typeEnv.put(var, String.class);
				try {
					return body.getType(typeEnv);
				} finally {
					typeEnv.remove(var);
				}
			}
		};
	}

	@Override
	public TypeGetter Prim(final Op op, final List<TypeGetter> args) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				boolean isDouble = false;
				Class<?> next;
				switch (op) {
				case ADD: {
					Class<?>[] actuals = new Class<?>[args.size()];
					boolean isString = false;
					int i = 0;
					for (TypeGetter e : args) {
						Class<?> val = e.getType(typeEnv);
						if (val.equals(String.class))
							isString = true;
						actuals[i++] = val;
					}

					if (isString) {
						return String.class;
					} else {
						for (Class<?> v : actuals) {
							next = v;
							if (!isDouble && (next == Double.class || next == double.class)) {
								isDouble = true;
							}
						}
					}
					break;
				}
				case SUB:
					next = args.get(0).getType(typeEnv);
					if (next.equals(Double.class)) {
						if (args.size() == 1)
							return Double.class;
						isDouble = true;
					} else {
						if (args.size() == 1)
							return Integer.class;
					}
					for (int k = 1; k < args.size(); k++) {
						TypeGetter e = args.get(k);
						next = e.getType(typeEnv);
						if (!isDouble && (next == Double.class || next == double.class)) {
							isDouble = true;
						}
					}
					break;
				case MUL:
					for (TypeGetter e : args) {
						next = e.getType(typeEnv);
						if (!isDouble && (next == Double.class || next == double.class)) {
							isDouble = true;
						}
					}
					break;
				case DIV:
					next = args.get(0).getType(typeEnv);
					if (next == Double.class || next == double.class) {
						if (args.size() == 1)
							return Double.class;
						isDouble = true;
					} else {
						if (args.size() == 1)
							return Integer.class;
					}
					for (int k = 1; k < args.size(); k++) {
						TypeGetter e = args.get(k);
						next = e.getType(typeEnv);
						if (!isDouble && (next == Double.class || next == double.class)) {
							isDouble = true;
						}
					}
					break;
				case AND:
					return Boolean.class;
				case OR:
					return Boolean.class;
				case NOT:
					return Boolean.class;
				case SEQ:
					Class<?> val = null;
					for (TypeGetter e : args)
						val = e.getType(typeEnv);
					return val;
				case NE:
					return Boolean.class;
				case EQ:
					return Boolean.class;
				case LT:
					return Boolean.class;
				case GT:
					return Boolean.class;
				case LE:
					return Boolean.class;
				case GE:
					return Boolean.class;
				default:
					throw new Error("Unknown Operator");
				}
				if (isDouble)
					return Double.class;
				else
					return Integer.class;
			}
		};
	}

	@Override
	public TypeGetter Prop(final TypeGetter base, final String field) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				Class<?> baseType = base.getType(typeEnv);
				AnnotatedElement fieldOrMethod = Eval.lookupField(baseType, field);
				Class<?> result = null;
				if (fieldOrMethod instanceof Field)
					result = ((Field) fieldOrMethod).getType();
				else
					// if (fieldOrMethod instanceof Method)
					result = ((Method) fieldOrMethod).getReturnType();

				return result;
			}
		};
	}

	@Override
	public TypeGetter Assign(final Op op, final TypeGetter target,
			final TypeGetter source) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				// TODO: revisit this
				return Error.class;
			}
		};
	}

	@Override
	public TypeGetter Let(final String var, final TypeGetter expression,
			final TypeGetter body) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				Class<?> expressionType = expression.getType(typeEnv);
				typeEnv.put(var, expressionType);
				try {
					return body.getType(typeEnv);
				} finally {
					typeEnv.remove(var);
				}
			}
		};
	}

	@Override
	public TypeGetter If(final TypeGetter condition, final TypeGetter thenExp,
			final TypeGetter elseExp) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				return thenExp.getType(typeEnv);
			}
		};
	}

	@Override
	public TypeGetter Loop(final String var, final TypeGetter collection,
			final TypeGetter body) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				Class<?> collectionType = collection.getType(typeEnv);
				// TODO: this is wrong. It returns List<SomeType> whereas we should
				// use SomeType
				typeEnv.put(var, collectionType);
				try {
					return body.getType(typeEnv);
				} finally {
					typeEnv.remove(var);
				}
			}
		};
	}

	@Override
	public TypeGetter Call(final TypeGetter target, final String method,
			final List<TypeGetter> args) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				Class<?> receiverType = target.getType(typeEnv);

				Method m = null;
				for (Method scan : receiverType.getMethods()) {
					if (scan.getName().equals(method)
							&& scan.getParameterTypes().length == args.size()) {
						m = scan;
						break;
					}
				}
				if (m == null)
					throw new IllegalStateException("Method not found: " + method);

				return m.getReturnType();
			}
		};
	}

	@Override
	public TypeGetter In(final String location) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				// TODO: Should we pass the input forest to getType?
				return Error.class;
			}
		};
	}

	@Override
	public TypeGetter Out(final String location, final TypeGetter expression) {
		return new TypeGetter() {
			public Class<?> getType(Map<String, Class<?>> typeEnv) {
				return expression.getType(typeEnv);
			}
		};
	}

}
