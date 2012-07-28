/*******************************************************************************
 * The accompanying source code is made available to you under the terms of 
 * the UT Research License (this "UTRL"). By installing or using the code, 
 * you are consenting to be bound by the UTRL. See LICENSE.html for a 
 * full copy of the license.
 * 
 * Copyright � 2009, The University of Texas at Austin. All rights reserved.
 * 
 * UNIVERSITY EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES CONCERNING THIS 
 * SOFTWARE AND DOCUMENTATION, INCLUDING ANY WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR ANY PARTICULAR PURPOSE, NON-INFRINGEMENT AND WARRANTIES 
 * OF PERFORMANCE, AND ANY WARRANTY THAT MIGHT OTHERWISE ARISE FROM COURSE 
 * OF DEALING OR USAGE OF TRADE. NO WARRANTY IS EITHER EXPRESS OR IMPLIED 
 * WITH RESPECT TO THE USE OF THE SOFTWARE OR DOCUMENTATION. Under no circumstances 
 * shall University be liable for incidental, special, indirect, direct 
 * or consequential damages or loss of profits, interruption of business, 
 * or related expenses which may arise from use of Software or Documentation, 
 * including but not limited to those resulting from defects in Software 
 * and/or Documentation, or loss or inaccuracy of data of any kind.
 * 
 * Created by: William R. Cook and Eli Tilevich
 * with: Jose Falcon, Marc Fisher II, Ali Ibrahim, Yang Jiao, Ben Wiedermann
 * University of Texas at Austin and Virginia Tech
 ******************************************************************************/
package batch.partition;

import java.util.ArrayList;
import java.util.List;

import batch.Op;

class ExtraString implements ExtraInfo<ExtraString> {
  public ExtraString setExtraInfo(Object info) {
    return this;
  }

  public String foo;

  public ExtraString(String foo) {
    super();
    this.foo = foo;
  }
}

class FormatPartition extends PartitionFactoryHelper<ExtraString> {
  batch.syntax.Format f;

  public FormatPartition() {
    f = new batch.syntax.Format();
  }

  public ExtraString Var(String name) {
    f = new batch.syntax.Format();
    return new ExtraString(f.Var(name));
  }

  public ExtraString Data(Object value) {
    return new ExtraString(f.Data(value));
  }

  public ExtraString Fun(String var, ExtraString body) {
    return new ExtraString(f.Fun(var, body.foo));
  }

  public ExtraString Prim(Op op, List<ExtraString> args) {
    List<String> l = new ArrayList<String>();
    for (ExtraString e : args)
      l.add(e.foo);
    return new ExtraString(f.Prim(op, l));
  }

  @Override
  public ExtraString Prop(ExtraString base, String field) {
    return new ExtraString(f.Prop(base.foo, field));
  }

  @Override
  public ExtraString Assign(Op op, ExtraString target, ExtraString source) {
    return new ExtraString(f.Assign(op, target.foo, source.foo));
  }

  @Override
  public ExtraString Let(String var, ExtraString expression, ExtraString body) {
    return new ExtraString(f.Let(var, expression.foo, body.foo));
  }

  @Override
  public ExtraString If(ExtraString condition, ExtraString thenExp,
      ExtraString elseExp) {
    return new ExtraString(f.If(condition.foo, thenExp.foo, elseExp.foo));
  }

  @Override
  public ExtraString Loop(String var, ExtraString collection, ExtraString body) {
    return new ExtraString(f.Loop(var, collection.foo, body.foo));
  }

  @Override
  public ExtraString Call(ExtraString target, String method,
      List<ExtraString> args) {
    List<String> l = new ArrayList<String>();
    for (ExtraString e : args)
      l.add(e.foo);
    return new ExtraString(f.Call(target.foo, method, l));
  }

  @Override
  public ExtraString In(String location) {
    return new ExtraString(f.In(location));
  }

  @Override
  public ExtraString Out(String location, ExtraString expression) {
    return new ExtraString(f.Out(location, expression.foo));
  }

  @Override
  public ExtraString Other(Object external, List<ExtraString> subs) {
    return new ExtraString("[OTHER]");
  }

  @Override
  public ExtraString DynamicCall(ExtraString target, String method,
      List<ExtraString> args) {
    return new ExtraString("[DYNAMIC]");
  }

  @Override
  public ExtraString Mobile(String type, ExtraString exp) {
    return new ExtraString("[MOBILE:" + exp.foo + "]");
  }

}

public class CodeModel extends PartitionFactoryHelper<PExpr> {

  public boolean allowAllTransers = false;

  public CodeModel() {
    factory = this;
  }

  public Stage emptyStage() {
    return new Stage(Place.MOBILE, factory.Skip());
  }

  static public CodeModel factory = new CodeModel();

  // base class for expressions
  public abstract class Base implements PExpr {
    protected Effects cachedEffects = null;
    protected CodeModel model = CodeModel.this;
    protected boolean isValue;
    protected Object extraInfo;

    @Override
    public PExpr clone(List<PExpr> args) {
      return this;
    }

    public PExpr setExtraInfo(Object info) {
      extraInfo = info;
      return this;
    }

    // from Exp
    public Effects effects() {
      if (cachedEffects == null) {
        cachedEffects = computeEffects();
      }
      return cachedEffects;
    }

    protected Effects computeEffects() {
      return Effects.noEffect;
    }

    // see Exp.java for explanations
    public void inLoop() {
    }

    public boolean isInputOutput() {
      return false;
    }

    // see Exp.java for explanations
    public boolean NeedDelay(Stage stage) {
      return false;
    }

    // see Exp.java for explanations
    public boolean NeedReplicate(History control) {
      return false;
    }

    // see Exp.java for explanations
    public History partition(Place place, Environment env) {
      throw new Error("ILLEGAL");
    }

    public String asVar() {
      return null;
    }

    public String toString() {
      FormatPartition f = new FormatPartition();
      ExtraString e = runExtra(f);
      return e.foo;
    }

  }

  // root class for evaluation constructs
  private abstract class Data extends Base {
    // used for output operations at a specific stage
    public History merge_outputs(Environment env, PExpr target, List<PExpr> args) {
      Place place;
      History hsrc;
      if (target != null) {
        hsrc = target.partition(Place.MOBILE, env);
        place = hsrc.last().place();
      } else {
        hsrc = new History(model);
        place = Place.LOCAL;
      }
      HistoryList hl = new HistoryList(model);
      hl.add(hsrc);
      if (args != null)
        for (PExpr e : args)
          hl.add(e.partition(place, env));
      return hl.merge_outputs_at(place, this);
    }
  }

  // root class for control constructs
  private abstract class Control extends Base {

    // partitions a control flow operator (If, Loop, Let).
    // the effects in the args are delayed until the
    // final stage of the source. The var can be null (for If)
    // the desired place specifies where the
    public History partition_control(Environment env, Place desired,
        String controlType, String var, PExpr src, PExpr arg1, PExpr arg2) {
      // partition the source
      History hsrc = src.partition(Place.MOBILE, env);
      if (controlType != null)
        hsrc.last().setType(controlType);
      Place place = hsrc.last().place();
      if (var != null)
        env = env.extend(var, extraInfo, place);
      HistoryList hl = new HistoryList(model);
      hl.add(hsrc);
      place = desired.otherwise(place);
      if (arg1 != null)
        hl.add(arg1.partition(place, env));
      if (arg2 != null)
        hl.add(arg2.partition(place, env));
      return hl.merge_control(this, desired);
      /*
       * [cf (if (and check (check_compose (cadr halign))) (lambda (c x) (f c
       * (cons ''*CONFLICT* x))) f)])
       */
    }

  }

  // conditional, which may be statement or exp

  // FACTORY
  @Override
  public PExpr Assign(final Op op, final PExpr target, final PExpr source) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Assign(op, args.get(0), args.get(1))
            .setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Assign(op, target.runExtra(f), source.runExtra(f))
            .setExtraInfo(extraInfo);
      }

      // align outputs and then perform assignment
      public History partition(Place desired, Environment env) {
        List<PExpr> args = new ArrayList<PExpr>();
        args.add(source);
        return merge_outputs(env, target, args);
      }

      // from Exp
      public Effects computeEffects() {
        Effects effects = target.effects().union(source.effects());

        String name = target.asVar();
        if (name != null)
          return effects.writeVar(name);
        else
          return effects.writeHeap();
      }
    };
  }

  @Override
  public PExpr Data(final Object value) {
    return new Data() {

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Data(value).setExtraInfo(extraInfo);
      }

      public History partition(Place desired, Environment env) {
        Stage stage = new Stage(Place.MOBILE, this);
        // note: this does not work for JastAddJ. In that
        // case, variables and constants must be wrapped in a Mobile node
        // this is just a default implementation
        // stage.setType(value.getClass().getName());
        return new History(model).add(stage);
      }
    };

  }

  // just perform a field access at the end of the exp
  @Override
  public PExpr Prop(final PExpr base, final String field) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Prop(args.get(0), field).setExtraInfo(
            extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Prop(base.runExtra(f), field).setExtraInfo(extraInfo);
      }

      public History partition(Place desired, Environment env) {
        return merge_outputs(env, base, null);
      }

      public Effects computeEffects() {
        return base.effects().union(Effects.readHeap);
      }
    };
  }

  @Override
  public PExpr If(final PExpr condition, final PExpr thenExp,
      final PExpr elseExp) {
    return new Control() {
      boolean optimizeLoop;

      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.If(args.get(0), args.get(1), args.get(2))
            .setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.If(condition.runExtra(f), thenExp.runExtra(f),
            elseExp.runExtra(f)).setExtraInfo(extraInfo);
      }

      public void inLoop() {
        if (thenExp == factory.Skip() || elseExp == factory.Skip())
          if (!condition.effects().hasWriteEffect()) {
            optimizeLoop = true;
            thenExp.inLoop();
            elseExp.inLoop();
          } else
            System.out.println("WARNING: effect in If prevents optimization");
      }

      // delay If branches as long as there is a side effect
      public boolean NeedDelay(Stage stage) {
        return stage.action().effects().hasWriteEffect();
      }

      // replicate if we are not directly inside a loop
      public boolean NeedReplicate(History control) {
        if (!optimizeLoop) {
          control.do_promote();
          return true;
        }
        return false;
      }

      // delay effects until condition is known, then replicate
      public History partition(Place desired, Environment env) {
        return partition_control(env, isValue ? desired : Place.UNKNOWN,
            "Boolean", // type is boolean
            null, condition, thenExp, elseExp);
      }

      public Effects computeEffects() {
        return condition.effects().union(
            thenExp.effects().union(elseExp.effects()));
      }

    };
  }

  @Override
  public PExpr Call(final PExpr target, final String method,
      final List<PExpr> args) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        List<PExpr> rest = new ArrayList<PExpr>();
        for (int i = 1/* yes this should be 1 */; i < args.size(); i++)
          rest.add(args.get(i));
        return CodeModel.factory.Call(args.get(0), method, rest).setExtraInfo(
            extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        List<E> trans = new ArrayList<E>();
        for (int i = 0; i < args.size(); i++)
          trans.add(args.get(i).runExtra(f));
        return f.Call(target.runExtra(f), method, trans)
            .setExtraInfo(extraInfo);
      }

      public History partition(Place desired, Environment env) {
        return merge_outputs(env, target, args);
      }

      // from Exp
      public Effects computeEffects() {
        Effects effects = target.effects();
        if (!method.startsWith("get"))
          effects = effects.union(Effects.writeHeap);
        for (PExpr e : args)
          effects = effects.union(e.effects());
        return effects;
      }
    };
  }

  @Override
  public PExpr DynamicCall(final PExpr target, final String method,
      final List<PExpr> args) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        List<PExpr> rest = new ArrayList<PExpr>();
        for (int i = 1/* yes this should be 1 */; i < args.size(); i++)
          rest.add(args.get(i));
        return CodeModel.factory.DynamicCall(args.get(0), method, rest)
            .setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        List<E> trans = new ArrayList<E>();
        for (int i = 0; i < args.size(); i++)
          trans.add(args.get(i).runExtra(f));
        return f.DynamicCall(target.runExtra(f), method, trans).setExtraInfo(
            extraInfo);
      }

      public History partition(Place desired, Environment env) {
        History hsrc = target.partition(Place.LOCAL, env);
        // hsrc.delay(hsrc.length() - 1, 1);
        DynamicCallInfo info = (DynamicCallInfo) extraInfo;
        hsrc.last().setPlace(Place.REMOTE);

        HistoryList hl = new HistoryList(model);
        hl.add(hsrc);
        int i = 0;
        for (PExpr e : args)
          hl.add(e.partition(info.arguments.get(i++), env));

        hl.prepare_merge(Place.REMOTE);
        History h = hl.merge_simple(hl.length() - 1, CodeModel.factory.Skip(),
            this, null);
        if (info.returns == Place.LOCAL)
          h.add(new Stage(Place.LOCAL, this));
        return h;
      }
    };
  }

  @Override
  public PExpr Let(final String var, final PExpr expression, final PExpr body) {
    return new Control() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Let(var, args.get(0), args.get(1))
            .setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Let(var, expression.runExtra(f), body.runExtra(f))
            .setExtraInfo(extraInfo);
      }

      @Override
      public void inLoop() {
        if (!expression.effects().hasWriteEffect())
          body.inLoop();
        // else if (body instanceof CodeModel.If) // TODO: send message!
        // System.out
        // .println("WARNING: effect in let prevents optimization");
      }

      // only delay Let body based on variable
      public boolean NeedDelay(Stage stage) {
        return effects().getVarEffect(var) != Effect.NONE;
      }

      public boolean NeedReplicate(History control) {
        if (control.last().getType() != null) {
          control.do_promote();
          return true;
        }
        return false;
      }

      public History partition(Place desired, Environment env) {
        return partition_control(env, isValue ? desired : Place.UNKNOWN, null,
            var, expression, body, null);
      }

      @Override
      protected Effects computeEffects() {
        return expression.effects().union(body.effects().removeVar(var));
      }

    };
  }

  public PExpr Other(final Object obj, final List<PExpr> args) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Other(obj, args).setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        List<E> trans = new ArrayList<E>();
        for (int i = 0; i < args.size(); i++)
          trans.add(args.get(i).runExtra(f));
        return f.Other(obj, trans).setExtraInfo(extraInfo);
      }

      public History partition(Place desired, Environment env) {
        HistoryList hl = new HistoryList(model);
        for (PExpr e : args)
          hl.add(e.partition(Place.LOCAL, env));
        if (hl.numHistories() == 0)
          hl.add(env.lookup("*LOCAL*", null)); // TODO: what is this?
        History result = hl.merge_outputs_at(Place.LOCAL, this);
        result.last().setPlace(Place.LOCAL);
        return result;
      }

      // from Exp
      public Effects computeEffects() {
        Effects effects = Effects.writeHeap;
        for (PExpr e : args)
          effects = effects.union(e.effects());
        return effects;
        // TODO: allow the to identify if we have effect?
      }
    };
  }

  @Override
  public PExpr Loop(final String var, final PExpr collection, final PExpr body) {
    body.inLoop();
    return new Control() {

      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Loop(var, args.get(0), args.get(1))
            .setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Loop(var, collection.runExtra(f), body.runExtra(f))
            .setExtraInfo(extraInfo);
      }

      // delay based on effects or use of variable
      public boolean NeedDelay(Stage stage) {
        return stage.action().effects().hasWriteEffect()
            || stage.action().effects().getVarEffect(var) != Effect.NONE;
      }

      // always replicate loops
      public boolean NeedReplicate(History control) {
        control.add(model.emptyStage());
        return true;
      }

      public History partition(Place desired, Environment env) {
        return partition_control(env, isValue ? desired : Place.UNKNOWN, null,
            var, collection, body, null);
      }

      public Effects computeEffects() {
        return collection.effects().union(body.effects().removeVar(var));
      }

    };
  }

  @Override
  public PExpr Prim(final Op op, final List<PExpr> args) {
    if (op == Op.SEQ) {
      for (int i = args.size(); i-- > 0; )
        if (args.get(i) == Skip())
          args.remove(i);
    }
    return new Base() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Prim(op, args).setExtraInfo(extraInfo);
        /*
         * List<PExpr> rest = new ArrayList<PExpr>(); for (int i = 0; i <
         * args.size(); i++) { if (op == Op.SEQ && args.get(i) instanceof
         * CodeModel.Prim) { Prim sub = (Prim) args.get(i); List<PExpr> subArgs
         * = sub.getArgs(); if (sub.getOp() == op) { for (PExpr o : subArgs)
         * rest.add(o); continue; } else if (subArgs.size() == 0) continue; }
         * rest.add(args.get(i)); } return CodeModel.factory.Prim(op, rest);
         */
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        List<E> trans = new ArrayList<E>();
        for (int i = 0; i < args.size(); i++)
          trans.add(args.get(i).runExtra(f));
        return f.Prim(op, trans).setExtraInfo(extraInfo);
      }

      public History partition(Place desired, Environment env) {
        HistoryList hl = new HistoryList(model);
        for (PExpr e : args)
          hl.add(e.partition(desired, env));
        if (op == Op.SEQ) {
          hl.align();
          return hl.merge_simple(0, this, this, this);
        } else
          return hl.merge_outputs_at(desired, this);
      }

      @Override
      protected Effects computeEffects() {
        Effects effects = Effects.noEffect;
        for (PExpr e : args)
          effects = effects.union(e.effects());
        return effects;
      }
    };
  }

  public PExpr In(final String location) {
    return new Data() {
      @Override
      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.In(location).setExtraInfo(extraInfo);
      }
    };
  }

  public PExpr Out(final String location, final PExpr expression) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Out(location, args.get(0)).setExtraInfo(
            extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Out(location, expression.runExtra(f)).setExtraInfo(extraInfo);
      }
    };
  }

  public PExpr Out(String type, String label, PExpr exp) {
    return Out(label, exp);
  }

  @Override
  public PExpr Mobile(final String type, final PExpr expression) {
    return new Data() {
      public Effects computeEffects() {
        return expression.effects();
      }

      public History partition(Place desired, Environment env) {
        History h = expression.partition(Place.UNKNOWN, env);
        h.last().setType(type);
        return h;
      }

      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Mobile(type, args.get(0)).setExtraInfo(
            extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Mobile(type, expression.runExtra(f)).setExtraInfo(
            extraInfo);
      }

    };
  }

  @Override
  public PExpr Var(final String name) {
    return new Data() {

      public History partition(Place desired, Environment env) {
        return env.lookup(name, extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Var(name).setExtraInfo(extraInfo);
      }

      @Override
      protected Effects computeEffects() {
        return Effects.noEffect.readVar(name);
      }

      public String asVar() {
        return name;
      }
    };
  }

  @Override
  public PExpr Fun(final String var, final PExpr body) {
    return new Data() {
      public PExpr clone(List<PExpr> args) {
        return CodeModel.factory.Fun(var, body).setExtraInfo(extraInfo);
      }

      public <E extends ExtraInfo<E>> E runExtra(PartitionFactory<E> f) {
        return f.Fun(var, body.runExtra(f)).setExtraInfo(extraInfo);
      }

      // see Exp.java for explanations
      public History partition(Place place, Environment env) {
        Environment nenv = env.extend(var, extraInfo, place);
        History hsrc = body.partition(place, nenv);
        HistoryList hl = new HistoryList(model);
        hl.add(hsrc);
        return hl.merge_outputs_at(place, this);
      }
    };
  }

}
