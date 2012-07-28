// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.Op;
import batch.util.BatchFactory;
import batch.util.BatchFactoryHelper;

public class Factory extends BatchFactoryHelper<SQLTranslation> {

  public static BatchFactory<SQLTranslation> factory = new Factory();

  public Factory() {
  }

  public static boolean isSkip(SQLTranslation target) {
    return target instanceof Prim && ((Prim) target).args.isEmpty();
  }

  public static boolean isRoot(SQLTranslation target) {
    return target instanceof Var
        && ((Var) target).name.equals(batch.sql.syntax.Factory.factory
            .RootName());
  }

  @Override
  public SQLTranslation Assign(SQLTranslation target, SQLTranslation value) {
    return new Assign(target, value);
  }

  @Override
  public SQLTranslation Data(Object c) {
    return new Constant(c);
  }

  @Override
  public SQLTranslation Prop(SQLTranslation base, String field) {
    return new Dot(base, field);
  }

  @Override
  public SQLTranslation If(SQLTranslation cond, SQLTranslation thenExp,
      SQLTranslation elseExp) {
    return new If(cond, thenExp, elseExp);
  }

  @Override
  public SQLTranslation In(String location) {
    return new Input(location);
  }

  @Override
  public SQLTranslation Call(SQLTranslation target, String method,
      List<SQLTranslation> args) {

    if (method.equals("id") && args.size() == 1) {
      Loop q = new Loop("o", target, new Var("o"));
      q.setId(args.get(0));
      return q;
    }
    if (method.equals("where") && args.size() == 1)
      return makeWhere(target, args);
    if (method.startsWith("get") && args.size() == 0)
      return new Dot(target, method.substring(3));
    // TODO: these should be done by the ExprJastJ??
    if (method.equals("after") && args.size() == 1)
      return factory.Prim(Op.GT, target, args.get(0));
    if (method.equals("before") && args.size() == 1)
      return factory.Prim(Op.LT, target, args.get(0));
    // end TODO
    if (method.startsWith("set") && args.size() == 1)
      return new Assign(new Dot(target, method.substring(3)), args.get(0));
    // aggregations
    if (method.equals("average") && args.size() == 1)
      return makeAggregation(target, Op.AVG, args);
    // c.exists(test)
    if (method.equals("exists") && args.size() == 1)
      return makeAggregation(target, Op.OR, args);
    // c.exists()
    if (method.equals("exists") && args.size() == 0)
      return new Loop("x", target, new Constant(true)).setOp(Op.OR);
    // c.all(test)
    if (method.equals("all") && args.size() == 1)
      return makeAggregation(target, Op.AND, args);
    if ((method.equals("sum") || method.equals("dsum")) && args.size() == 1)
      return makeAggregation(target, Op.ADD, args);
    if ((method.equals("min") || method.equals("dmin")) && args.size() == 1)
      return makeAggregation(target, Op.MIN, args);
    if ((method.equals("max") || method.equals("dmax")) && args.size() == 1)
      return makeAggregation(target, Op.MAX, args);
    if (method.equals("count") && args.size() == 0)
      return new Loop("x", target, new Var("x")).setOp(Op.COUNT); // GET THE CODE
    // insert, delete
    return new Call(target, method, args);
  }

  private Loop makeAggregation(SQLTranslation collection, Op op,
      List<SQLTranslation> args) {
    Fun fun = (Fun) args.get(0);
    return new Loop(fun.getVar(), collection, fun.getBody()).setOp(op);
  }

  private Loop makeWhere(SQLTranslation collection, List<SQLTranslation> args) {
    Fun fun = (Fun) args.get(0);
    String var = fun.getVar();
    return new Loop(var, collection, new If(fun.getBody(), new Var(var),
        factory.Skip()));
  }

  @Override
  public SQLTranslation Let(String var, SQLTranslation exp, SQLTranslation body) {
    if (exp instanceof Call) {
      Call call = (Call) exp;
      if (call.method.equals("create")) {
        SQLTranslation x = body.collectInsertArguments(var, call);
        return x == null ? call : Prim(Op.SEQ, call, x);
      }
    }
    return new Let(var, exp, body);
  }

  @Override
  public SQLTranslation Loop(String var, SQLTranslation collection,
      SQLTranslation body) {
    return new Loop(var, collection, body);
  }

  @Override
  public SQLTranslation Prim(Op op, List<SQLTranslation> args) {
    return new Prim(op, args);
  }

  @Override
  public SQLTranslation Out(String label, SQLTranslation exp) {
    return new Output(label, exp);
  }

  @Override
  public SQLTranslation Var(String var) {
    return new Var(var);
  }

  @Override
  public SQLTranslation Fun(String var, SQLTranslation body) {
    return new Fun(var, body);
  }

}
