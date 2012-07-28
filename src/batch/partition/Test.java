package batch.partition;

import batch.Op;

public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    CodeModel f = CodeModel.factory;
    f.allowAllTransers = true;

    PExpr l = f.Var("l");
    PExpr r = f.Var("r");
    PExpr z = f.Var("z");
    process(f.Call(r, "frob", l));

    process(f.Call(r, "frob", f.Call(l, "baz")));

    process(f.Call(l, "print", f.Call(r, "foo", l)));

    process(f.Call(l, "print", f.Call(r, "foo", f.Data("foo"))));

    process(f.Prim(Op.SEQ,
        f.Call(l, "print", f.Call(r, "foo", f.Data("foo"))),
        f.Call(l, "print", f.Call(r, "bar", z))));

    process(f.Loop("z", f.Call(r, "items", l), f.Call(l, "print", f.Call(z, "bar"))));
    

  }

  private static void process(PExpr exp) {
    System.out.println("***" + exp.toString());
    Environment env = new Environment(CodeModel.factory);
    env = env.extend("r", null, Place.REMOTE);
    History h = exp.partition(Place.MOBILE, env);
    System.out.println(h.toString());
  }

}
