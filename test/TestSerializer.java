// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import batch.Op;
import batch.json.JSONTransport;
import batch.json.JSONWriter;
import batch.syntax.Parser;
import batch.syntax.Format;
import batch.util.BatchFactory;
import batch.util.BatchTransport;
import batch.util.ForestListWriter;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class TestSerializer {

  public <E> List<E> generateExpressions(BatchFactory<E> f) {
    List<E> r = new ArrayList<E>();

    // DO NOT ADD TESTS AT THE TOP OF THE LIST!!! //
    r.add(f.Out("g1", (f.Prim(Op.AND, f.Data(true), f.Data(true)))));
    r.add(f.Out("g1", (f.Prim(Op.EQ, f.Data("&<>'\"quote"), f.Data("simple")))));
    r.add(f.Out("g1", (f.Prim(Op.EQ, f.Data("bad\n"), f.Data("[})(;!")))));
    r.add(f.Out("g1", (f.Prim(Op.AND, f.Data(false), f.Data(true)))));
    r.add(f.Out("g1", (f.Prim(Op.ADD, f.Data((long) 23), f.Data(234.345)))));
    // r.add(f.Data(new byte[] { 0, 23, 34, 34, 45, 45, 3, 2, 23 }));
    //		r.add(f.Data(new Date(1992, 11, 2)));
    r.add(f.Data(java.sql.Date.valueOf("1998-11-21")));
    r.add(makeExp(f));
    return r;
  }

  // method invocation
  @SuppressWarnings("deprecation")
  <E> E makeExp(BatchFactory<E> f) {
    E target = f.Prop(f.Var("xx"), "foo");
    E a1 = f.Data(new Date(1992, 11, 2));
    E b1 = f.Data("test\n\rbadstring{}!!\n\"'<>foo");
    E b2 = f.Var("mm");
    E a2 = f.Prim(Op.ADD, f.Data(33), f.Data(3.14));
    E call = f.Call(target, "bar", a1, a2);
    E s1 = f.Assign(f.Var("xx"), a2);
    E s2 = f.Prim(Op.SEQ, f.Assign(target, a1), call);
    E c = f.Prim(Op.EQ, b1, b2);
    E test = f.If(c, s1, s2);
    E let = f.Let("vv", f.Data(35), test);
    E loop = f.Loop("xx", f.Var("cc"), let);
    return loop;
  }

  @SuppressWarnings("deprecation")
  void writeForest(Writer stream) throws IOException {
    ForestWriter x = new JSONWriter(stream);
    x.put("a", "test string <>'\";&");
    x.put("b", 23);
    x.put("c", 23.34);
    x.put("d", new Date(1992, 11, 2));
    x.put("e", true);
    x.put("n", null);
    ForestListWriter iter = x.newTable("m");
    for (int i = 0; i < 3; i++) {
      ForestWriter y = iter.newIteration();
      y.put("x", i);
      y.put("y", "test " + i);
      y.put("z", 10 * 10 * i);
      y.complete();
    }
    iter.complete();
    x.complete();
  }

  //@Test
  public void testJSON() throws IOException {
    // generate expressions JSONTransport<SQLTranslation> trans = new
    // JSONTransport<SQLTranslation>();
    test(new JSONTransport());
  }

  //@Test
  public void testXML() throws IOException {
    // generate expressions
    //	test(new XMLTransport());
  }

  //@Test
  public void testScript() {
    Format formatter = new Format();
    for (String script : generateExpressions(formatter)) {
      System.out.println("OUT: " + script);
      String e2;
      e2 = Parser.parse(script, formatter);
      System.out.println("CHK: " + e2);
      if (!script.equals(e2)) {
        System.out.println("Script Error");
      }
    }
  }

  public void test(BatchTransport trans) throws IOException {
    // iterate
    // dump exp
    StringWriter out = new StringWriter();
    writeForest(out);
    String x = out.toString();

    System.out.println(x);

    Reader in = new StringReader(x);
    // read exp
    ForestReader e2 = trans.read(in);

    StringWriter out2 = new StringWriter();
    trans.writer(out2);
    String x2 = out.toString();

    // the read expressions should equal the original
    if (!x.equals(x2)) {
      System.out.println("Error");
      System.out.println(x);
      System.out.println(x2);
    }
  }

  public static void main(String[] args) throws IOException {
    TestSerializer t = new TestSerializer();
    t.testScript();
    t.testJSON();
    t.testXML();
  }
}
