// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.ArrayList;
import java.util.List;

import batch.sql.schema.IEntityType;
import batch.sql.schema.ISchema;
import batch.sql.schema.javareflect.Schema;
import batch.sql.syntax.SQLTranslation.SQLAction;
import batch.util.BatchFactory;
import batch.util.ForestReader;

public class Call extends ValueExpression {

	SQLTranslation target;
	String method;
	List<SQLTranslation> args;
	public String insertResultName; // used for location of insert

	public static final List<SQLTranslation> NoArgs = new ArrayList<SQLTranslation>();

	public Call(SQLTranslation target, String method, List<SQLTranslation> args) {
		super();
		this.target = target;
		this.method = method;
		this.args = args;
		target.setValue();
		for (SQLTranslation s : args)
		  s.setValue();
	}

	@Override
	public SQLTranslation normalize(ISchema schema, SQLQuery query,
			SQLTranslation outerCond, Env env, NormType normType) {
		if (method.startsWith("create")) {
			// root.Table.create() -- create at base
			// obj.items.create() -- create in a collection
			List<SQLTranslation> newargs = new ArrayList<SQLTranslation>();
			IEntityType entity;
			SQLTranslation newtarget = target.normalize(schema, query, null, env, normType);
			if (newtarget instanceof SQLField) {
				SQLField field = (SQLField) newtarget;
				entity = field.getTargetEntity();
				Output setbase = field.invertForAssign();
				SQLTranslation na = setbase.normalize(schema, query, null, env,
						normType);
				newargs.add(new Output(setbase.getLocation(), na));
			} else if (newtarget instanceof SQLTable)
				entity = ((SQLTable) newtarget).getEntityType();
			else
				throw new Error("invalid insert");
			// must set the action before
			for (SQLTranslation a : args) {
				SQLTranslation na = a.normalize(schema, query, null, env, normType);
				Output out = (Output) a;
				String loc = out.getLocation();
				String field = entity.get(loc).columnName();
				newargs.add(new Output(field, na));
			}
			Call act = new Call(batch.sql.syntax.Factory.factory.Root(), entity.getTableName(),
					newargs);
			query.doAction(SQLAction.INSERT, act);
			query.insertResultName = insertResultName;
			return batch.sql.syntax.Factory.factory.Root();
		} else if (method.equals("delete")) {
			SQLTranslation newtarget = target.normalize(schema, query, null, env,
					normType);
			query.doAction(SQLAction.DELETE, newtarget);
			return Factory.factory.Skip();
    } else if (method.equals("project")) {
      SQLTranslation newtarget = target.normalize(schema, query, null, env,
          normType);
      Fun fun = (Fun) args.get(0);
      SQLTranslation item = newtarget.getTable();
      SQLTranslation result = fun.apply(item).normalize(schema, query, null,
          env, normType);
      return result;
		} else
			return doCall(schema, query, env, target, normType);
	}

	private SQLTranslation doCall(ISchema schema, SQLQuery query, Env env,
			SQLTranslation targetIn, NormType normType) throws Error {
		SQLTranslation target = batch.sql.syntax.Factory.factory.Root();
		if (targetIn != target) {
			// methods that require a target
			target = targetIn.normalize(schema, query, null, env, normType);
			boolean asc;
			if ((asc = method.equals("orderBy")) || method.equals("orderByDescending")) {
				Fun fun = (Fun) args.get(0);
				SQLTranslation item = target.getTable();
				SQLTranslation order = fun.apply(item).normalize(schema, query, null,
						env, normType);
				query.addSort(asc, order);
				return target;
			} else if (method.equals("groupBy")) {
				Fun fun = (Fun) args.get(0);
				SQLTable baseTable = target.getTable();
				SQLTranslation group = fun.apply(baseTable).normalize(schema, query,
						null, env, normType);
				if (normType != NormType.EXTERNAL)
					query.addGroupBy(group);
				return baseTable.new GroupByTable(query, Schema.MakeGroupByEntityType(
						group, baseTable.getEntityType(), fun), baseTable);
			} else if (method.equals("distinct")) {
				query.setDistinct();
				return target;
			} else if (method.equals("first")) {
				long limit = ((Number) args.get(0).run(new batch.syntax.Eval())
						.evaluate(null, null, null)).longValue();
				query.setLimit(limit);
				return target;
			}
		}
		List<SQLTranslation> args = new ArrayList<SQLTranslation>();
		for (SQLTranslation a : args)
			args.add(a.normalize(schema, query, null, env, normType));
		return new Call(target, method, args);
	}

	@Override
	public SQLTranslation invertPath(SQLTranslation inverted, Env env,
			boolean fromChild) {
		if (fromChild)
			return target.invertPath(inverted, env, fromChild);
		else
			return new Call(target.invertPath(inverted, env, fromChild), method, args);
	}

	public SQLTranslation trimLast(Env env) {
		return target.trimLast(env);
	}

	@Override
	public SQLTable getTableNoJoins(Env env) {
		return (SQLTable) doCall(null, null, env, target.getTableNoJoins(env),
				NormType.EXTERNAL);
	}

	@Override
	public SQLTable getBase(Env env) {
		return target.getBase(env);
	}

	@Override
	public SQLTranslation getTransformations(SQLTranslation base) {
		return new Call(target.getTransformations(base), method, args);
	}

	@Override
	public SQLTranslation withoutTransformations() {
		return target.withoutTransformations();
	}

	@Override
	public void toSQL(StringBuilder sb, List<Object> params, ForestReader data) {
		sb.append(method);
		sb.append('(');
		int i = 0;
		if (!Factory.isRoot(target)) {
			target.toSQL(sb, params, data);
			i++;
		}
		for (SQLTranslation a : args) {
			if (i++ > 0)
				sb.append(',');
			if (a instanceof Output)
				sb.append(((Output) a).getLocation());
			else
				a.toSQL(sb, params, data);
		}
		sb.append(')');
	}

	public SQLTable getTable() {
		return target.getTable();
	}

	@Override
	public <E> E run(BatchFactory<E> f) {
		List<E> trans = new ArrayList<E>();
		for (SQLTranslation x : args)
			trans.add(x.run(f));
		return f.Call(target.run(f), method, trans);
	}
}
