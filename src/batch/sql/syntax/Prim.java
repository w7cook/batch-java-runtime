// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.ArrayList;
import java.util.List;

import batch.Op;
import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.ForestReader;

public class Prim extends ValueExpression {

  Op op;
  List<SQLTranslation> args;

  public Prim(Op op, List<SQLTranslation> args) {
    super();
    this.op = op;
    this.args = args;
    if (op != Op.SEQ)
      for (SQLTranslation s : args)
        s.setValue();
    setValue();
  }

  public <E> E run(BatchFactory<E> f) {
    List<E> trans = new ArrayList<E>();
    for (SQLTranslation x : args)
      trans.add(x.run(f));
    return f.Prim(op, trans);
  }

  @Override
  public SQLTranslation normalize(ISchema schema, SQLQuery query,
      SQLTranslation outerCond, Env env, NormType normType) {
    if (op != Op.SEQ)
      outerCond = null;
    List<SQLTranslation> newargs = new ArrayList<SQLTranslation>();
    for (SQLTranslation x : args) {
      SQLTranslation n = x.normalize(schema, query, outerCond, env, normType);
      newargs.add(n);
    }
    return new Prim(op, newargs);
  }

  public SQLTable getTable() {
    for (SQLTranslation e : args) {
      SQLTable t = e.getTable();
      if (t != null)
        return t;
    }
    return null;
  }

  public String sqlOp(Op op) {
    switch (op) {
    case ADD:
      return "+";
    case SUB:
      return "-";
    case MUL:
      return "*";
    case DIV:
      return "/";
    case MOD:
      return "%";
    case AND:
      return "\nAND ";
    case OR:
      return "\nOR ";
    case NOT:
      return " NOT ";
    case EQ:
      return "=";
    case NE:
      return "!=";
    case LT:
      return "<";
    case GT:
      return ">";
    case LE:
      return "<=";
    case GE:
      return ">=";
    }
    return "INVALID";
  }

  @Override
  public void toSQL(StringBuilder sb, List<Object> params, ForestReader data) {
    if (args.size() == 0) {
      sb.append(op.toString());
    } else {
      sb.append("(");
      int i = 0;
      for (SQLTranslation e : args) {
        if (i > 0 || args.size() == 1)
          sb.append(sqlOp(op));
        e.toSQL(sb, params, data);
        i++;
      }
      sb.append(")");
    }
  }

  public List<SQLTranslation> getArgs() {
    return args;
  }

  public Op getOp() {
    return op;
  }

  @Override
  public SQLTranslation collectInsertArguments(String var, Call call) {
    int i = 0;
    while (i < args.size()) {
      SQLTranslation x = args.get(i).collectInsertArguments(var, call);
      if (x == null)
        args.remove(i);
      else
        args.set(i++, x);
    }
    if (i == 0)
      return null;
    else
      return this;
  }
}
