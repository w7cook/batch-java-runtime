
import batch.partition.*;

public class TestPartition {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // Let x = ROOT.foo() in print x
    CodeModel cm = new CodeModel();
    cm.allowAllTransers = true;
    PExpr p = cm.Let("x", cm.Call(cm.Root(), "foo"), cm.Other("FOO", cm.Var("x")));
    History r = p.partition(Place.UNKNOWN, new Environment(cm).extend("ROOT", null, Place.REMOTE));
    System.out.println("GIVEN\n" + p + "\nRESULT\n" + r);
  }

}
