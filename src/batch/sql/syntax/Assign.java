// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

import java.util.List;

import batch.sql.schema.ISchema;
import batch.util.BatchFactory;
import batch.util.ForestReader;

public class Assign extends Base {

  SQLTranslation target;
  SQLTranslation source;

  public Assign(SQLTranslation target, SQLTranslation source) {
    this.target = target;
    this.source = source;
    target.setValue();
    source.setValue();
  }

  @Override
  public SQLTranslation normalize(ISchema schema, SQLQuery query,
      SQLTranslation outerCond, Env env, NormType normType) {
    SQLTranslation targ = target.normalize(schema, query, null, env, normType);
    SQLTranslation src = source.normalize(schema, query, null, env, normType);
    SQLQuery q;
    Assign newAction;
    if (targ instanceof SQLQuery) {
      q = (SQLQuery) targ;
      newAction = new Assign(q.body, src);
    } else {
      newAction = new Assign(targ, src);
      q = targ.getTable().getQuery();
    }
    q.doAction(SQLAction.UPDATE, newAction);
    return this;
  }

  @Override
  public void toSQL(StringBuilder sb, List<Object> params, ForestReader data) {
    target.toSQL(sb, params, data);
    sb.append('=');
    source.toSQL(sb, params, data);
  }

  public SQLTable getTable() {
    throw new Error("TODO");
  }

  @Override
  public <E> E run(BatchFactory<E> f) {
    return f.Assign(target.run(f), source.run(f));
  }

  @Override
  public SQLTranslation collectInsertArguments(String var, Call call) {
    if (target instanceof Dot && ((Dot) target).base instanceof Var
        && ((Var) ((Dot) target).base).name.equals(var)) {

      call.args.add(new Output(((Dot) target).field, source));
      return null;
    } else
      return this;
  }
}
