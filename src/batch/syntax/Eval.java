package batch.syntax;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import batch.Op;
import batch.util.BatchCancel;
import batch.util.BatchException;
import batch.util.BatchFactoryHelper;
import batch.util.ForestListWriter;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class Eval extends BatchFactoryHelper<Evaluate> {

	public Eval() {
	}

	public static AnnotatedElement lookupField(Type baseType, String field) {
		if (baseType instanceof ParameterizedType)
			baseType = ((ParameterizedType) baseType).getRawType();
		if (baseType instanceof Class<?>) {
			Class<?> cls = (Class<?>) baseType;
			try {
				return cls.getField(field);
			} catch (NoSuchFieldException e) {
			}
			String method = "get" + field.substring(0, 1).toUpperCase()
					+ field.substring(1);
			try {
				return cls.getMethod(method);
			} catch (NoSuchMethodException e1) {
			}
		}
		throw new Error("Unknown field " + field);
	}

	@Override
	public Evaluate Var(final String name) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				return env.get(name);
			}
		};
	}

	@Override
	public Evaluate Data(final Object value) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				return value;
			}
		};
	}

	@Override
	public Evaluate Fun(final String var, final Evaluate body) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				Map<String, Object> nenv = new HashMap<String, Object>();
				nenv.putAll(env);
				return new FunClosure<Evaluate>(var, body, nenv, inputs);
			}
		};
	}

	@Override
	public Evaluate Prim(final Op op, final List<Evaluate> args) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {

				boolean isDouble = false;
				double doubleValue = 0;
				long intValue = 0;
				Number next;
				switch (op) {
				case ADD: {
					Object[] actuals = new Object[args.size()];
					boolean isString = false;
					int i = 0;
					for (Evaluate e : args) {
						Object val = e.evaluate(env, inputs, results);
						if (val instanceof String)
							isString = true;
						actuals[i++] = val;
					}

					if (isString) {
						StringBuilder buf = new StringBuilder();
						for (Object v : actuals)
							buf.append(String.valueOf(v));
						return buf.toString();
					} else {
						for (Object v : actuals) {
							next = (Number) v;
							if (!isDouble && next instanceof Double) {
								doubleValue = intValue;
								isDouble = true;
							}
							if (isDouble)
								doubleValue += next.doubleValue();
							else
								intValue += next.intValue();
						}
					}
					break;
				}
				case SUB:
					next = (Number) args.get(0).evaluate(env, inputs, results);
					if (next instanceof Double) {
						doubleValue = next.doubleValue();
						if (args.size() == 1)
							return -doubleValue;
						isDouble = true;
					} else {
						intValue = next.intValue();
						if (args.size() == 1)
							return -intValue;
					}
					for (int k = 1; k < args.size(); k++) {
						Evaluate e = args.get(k);
						next = (Number) e.evaluate(env, inputs, results);
						if (!isDouble && next instanceof Double) {
							doubleValue = intValue;
							isDouble = true;
						}
						if (isDouble)
							doubleValue -= next.doubleValue();
						else
							intValue -= next.intValue();
					}
					break;
				case MUL:
					intValue = 1;
					for (Evaluate e : args) {
						next = (Number) e.evaluate(env, inputs, results);
						if (!isDouble && next instanceof Double) {
							doubleValue = intValue;
							isDouble = true;
						}
						if (isDouble)
							doubleValue *= next.doubleValue();
						else
							intValue *= next.intValue();
					}
					break;
				case DIV:
					next = (Number) args.get(0).evaluate(env, inputs, results);
					if (next instanceof Double) {
						doubleValue = next.doubleValue();
						if (args.size() == 1)
							return 1 / doubleValue;
						isDouble = true;
					} else {
						intValue = next.intValue();
						if (args.size() == 1)
							return 1 / intValue;
					}
					for (int k = 1; k < args.size(); k++) {
						Evaluate e = args.get(k);
						next = (Number) e.evaluate(env, inputs, results);
						if (!isDouble && next instanceof Double) {
							doubleValue = intValue;
							isDouble = true;
						}
						if (isDouble)
							doubleValue /= next.doubleValue();
						else
							intValue /= next.intValue();
					}
					break;
				case AND:
					for (Evaluate e : args)
						if (!(Boolean) e.evaluate(env, inputs, results))
							return false;
					return true;
				case OR:
					for (Evaluate e : args)
						if ((Boolean) e.evaluate(env, inputs, results))
							return true;
					return false;
				case NOT:
					return !(Boolean) args.get(0).evaluate(env, inputs, results);
				case SEQ:
					Object val = null;
					for (Evaluate e : args)
						val = e.evaluate(env, inputs, results);
					return val;
				case NE:
					return doOp(env, inputs, results);
				case EQ:
					return doOp(env, inputs, results);
				case LT:
					return doOp(env, inputs, results);
				case GT:
					return doOp(env, inputs, results);
				case LE:
					return doOp(env, inputs, results);
				case GE:
					return doOp(env, inputs, results);
				default:
					throw new Error("Unknown Operator");
				}
				if (isDouble)
					return doubleValue;
				else
					return intValue;
			}

			private boolean doOp(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				Object left = args.get(0).evaluate(env, inputs, results);
				Object right = args.get(1).evaluate(env, inputs, results);
				// largest must come first!!
				if (left instanceof String || right instanceof String) {
					String a = left.toString();
					String b = right.toString();
					int c = a.compareTo(b);
					switch (op) {
					case EQ:
						return c == 0;
					case NE:
						return c != 0;
					case LT:
						return c < 0;
					case GT:
						return c > 0;
					case LE:
						return c <= 0;
					case GE:
						return c >= 0;
					}
				}
				if (left instanceof BigDecimal || right instanceof BigDecimal) {
					BigDecimal a = toBigDecimal(left);
					BigDecimal b = toBigDecimal(right);
					int c = a.compareTo(b);
					switch (op) {
					case EQ:
						return c == 0;
					case NE:
						return c != 0;
					case LT:
						return c < 0;
					case GT:
						return c > 0;
					case LE:
						return c <= 0;
					case GE:
						return c >= 0;
					}
				} else if (left instanceof Double || right instanceof Double
						|| left instanceof Float || right instanceof Float) {
					double a = ((Number) left).doubleValue();
					double b = ((Number) right).doubleValue();
					switch (op) {
					case EQ:
						return a == b;
					case NE:
						return a != b;
					case LT:
						return a < b;
					case GT:
						return a > b;
					case LE:
						return a <= b;
					case GE:
						return a >= b;
					}
				} else if (left instanceof Long || right instanceof Long
						|| left instanceof Integer || right instanceof Integer
						|| left instanceof Short || right instanceof Short
						|| left instanceof Byte || right instanceof Byte) {
					long a = ((Number) left).longValue();
					long b = ((Number) right).longValue();
					switch (op) {
					case EQ:
						return a == b;
					case NE:
						return a != b;
					case LT:
						return a < b;
					case GT:
						return a > b;
					case LE:
						return a <= b;
					case GE:
						return a >= b;
					}
				} else if (op == Op.EQ) {
					if (left == null || right == null)
						return left == right;
					else {
						return left.equals(right);
					}
				} else if (op == Op.NE) {
					if (left == null || right == null)
						return left != right;
					else {
						return !left.equals(right);
					}
				}
				throw new Error();
			}

			private BigDecimal toBigDecimal(Object n) {
				if (n instanceof BigDecimal)
					return (BigDecimal) n;
				if (n instanceof Long || n instanceof Integer || n instanceof Short
						|| n instanceof Byte) {
				 	return new BigDecimal(((Number) n).longValue());
				} else if (n instanceof Double)
					return new BigDecimal(((Number) n).doubleValue());
				else
					throw new Error("Invalid type");
			}

		};
	}

	@Override
	public Evaluate Prop(final Evaluate base, final String field) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {

				final Object val = base.evaluate(env, inputs, results);
				Class<?> cls = val.getClass();
				AnnotatedElement fieldOrMethod = Eval.lookupField(cls, field);
				Object result = null;
				try {
					if (fieldOrMethod instanceof Field)
						result = ((Field) fieldOrMethod).get(val);
					else
						// if (fieldOrMethod instanceof Method)
						result = ((Method) fieldOrMethod).invoke(val, new Object[0]);
				} catch (InvocationTargetException ite) {
					throw new BatchException(ite.getCause());
				} catch (Throwable e) {
					throw new BatchException(e);
				}

				return result;
			}
		};
	}

	@Override
	public Evaluate Assign(final Evaluate target,
			final Evaluate source) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				// TODO: revisit this
				throw new Error("TODO!");
			}
		};
	}

	@Override
	public Evaluate Let(final String var, final Evaluate expression,
			final Evaluate body) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {

				final Object prevVal = env.get(var);
				final Object val = expression.evaluate(env, inputs, results);

				env.put(var, val);
				try {
					return body.evaluate(env, inputs, results);
				} finally {
					if (prevVal == null) {
						env.remove(var);
					} else {
						env.put(var, prevVal);
					}
				}
			}
		};
	}

	@Override
	public Evaluate If(final Evaluate condition, final Evaluate thenExp,
			final Evaluate elseExp) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				final boolean cond = (Boolean) condition.evaluate(env, inputs, results);
				Object val = null;
				if (cond) {
					val = thenExp.evaluate(env, inputs, results);
				} else {
					val = elseExp.evaluate(env, inputs, results);
				}
				return val;
			}
		};
	}

	@Override
	public Evaluate Loop(final String var, final Evaluate collection,
			final Evaluate body) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {

				// Execute Loop
				Iterable<?> coll;
				Object colOrArray = collection.evaluate(env, inputs,
            results);
				if (colOrArray instanceof Iterable)
				  coll = (Iterable<?>) colOrArray;
				else {
				  coll = new ArrayIterator(colOrArray);
				}
				
        ForestListWriter iter = results.newTable(var);
				for (Object o : coll) {
					// set the loop variable to the current value in the environment
					env.put(var, o);
					// create a new loop iteration
					// evaluate the body
					body.evaluate(env, inputs, iter.newIteration());
				}
				iter.complete();

				// remove the loop variable from the environment
				env.remove(var);

				return null;
			}
		};
	}

	@Override
	public Evaluate Call(final Evaluate target, final String method,
			final List<Evaluate> args) {
		return new Evaluate() {
			@SuppressWarnings("unchecked")
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {

				// Evaluate receiver and parameters
				Object receiver = target.evaluate(env, inputs, results); // dynamic ?
				// null

				System.out.println("Calling " + method);

				// Find method to invoke
				// Assume no method overloading
				if (receiver == null) { // !dynamic &&
					throw new IllegalStateException("Null receiver: " + target.toString());
				}

				Method m = null;
				// Method mAllow = null;
				Method[] mtds = receiver.getClass().getMethods();
				for (Method scan : mtds) {
					if (scan.getName().equals(method)
							&& scan.getParameterTypes().length == args.size()) {
						m = scan;
						break;
					}
				}
				if (m == null)
					throw new IllegalStateException("Method not found: " + method);

				// Fix parameter types if necessary
				Object[] parameters = new Object[args.size()];
				Class<?>[] parameterTypes = m.getParameterTypes();
				for (int i = 0; i < parameterTypes.length; i++) {
					Class<?> paramClass = parameterTypes[i];
					final Object param = args.get(i).evaluate(env, inputs, results);

					if (paramClass.isArray()
							&& !paramClass.isAssignableFrom(param.getClass())) {
						Object[] paramArray = (Object[]) param;
						Object[] newParamArray = (Object[]) Array.newInstance(
								paramClass.getComponentType(), paramArray.length);
						for (int j = 0; j < paramArray.length; j++) {
							newParamArray[j] = paramArray[j];
						}
						parameters[i] = newParamArray;
					} else if (paramClass == int.class || paramClass == Integer.class) {
						parameters[i] = ((Number) param).intValue();
					} else if (paramClass == long.class || paramClass == Long.class) {
						parameters[i] = ((Number) param).longValue();
					} else if (paramClass == short.class || paramClass == Short.class) {
						parameters[i] = ((Number) param).shortValue();
					} else if (paramClass == float.class || paramClass == Float.class) {
						parameters[i] = ((Number) param).floatValue();
					} else if (paramClass == double.class || paramClass == Double.class) {
						parameters[i] = ((Number) param).doubleValue();
					} else if (paramClass == batch.Fun.class) {
						parameters[i] = new batch.Fun<Object, Object>() {
							FunClosure<Evaluate> fun;
							{
								this.fun = (FunClosure<Evaluate>) param;
							}

							@Override
							public Object apply(Object x) {
								return fun.apply(x, null);
							}
						};
					} else
						parameters[i] = param;
				}

				// Invoke method and bind value in environment
				Object val = null;
				// Boolean allow;
				try {
					val = m.invoke(receiver, parameters);
				} catch (InvocationTargetException ite) {
					throw new BatchException(ite.getCause());
				} catch (Throwable e) {
					throw new BatchException(e);
				}
				return val;
			}
		};
	}

	@Override
	public Evaluate In(final String location) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				Object val = inputs.get(location);
				if (val instanceof Throwable)
					throw new Error(((Throwable) val).getMessage());
				return val;
			}
		};
	}

	@Override
	public Evaluate Out(final String location, final Evaluate expression) {
		return new Evaluate() {
			public Object evaluate(Map<String, Object> env, ForestReader inputs,
					ForestWriter results) {
				try {
				  Object result = expression.evaluate(env, inputs, results);
					results.put(location, result);
	        return result;
				} catch (BatchException e) {
					// these are actual exceptions from scripts
					results.put(location, e);
					throw new BatchCancel(); // end the batch
				}
			}
		};
	}

}
