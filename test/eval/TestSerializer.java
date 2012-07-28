// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.eval;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import batch.Op;
import batch.json.JSONTransport;
import batch.syntax.BatchScriptParser;
import batch.syntax.Expression;
import batch.syntax.Format;
import batch.util.BatchFactory;
import batch.util.BatchTransport;
import batch.util.Forest;
import batch.util.MultiForest;
import batch.xml.XMLTransport;

public class TestSerializer {

	private BatchFactory<Expression> f = new batch.syntax.Factory();

	public List<Expression> generateExpressions() {
		List<Expression> r = new ArrayList<Expression>();

		// DO NOT ADD TESTS AT THE TOP OF THE LIST!!! //
		r.add(output(f.Prim(Op.AND, f.Data(true), f.Data(true))));
		r.add(output(f.Prim(Op.EQ, f.Data("&<>'\"quote"), f.Data("simple"))));
		r.add(output(f.Prim(Op.EQ, f.Data("bad\n"), f.Data("[})(;!"))));
		r.add(output(f.Prim(Op.AND, f.Data(false), f.Data(true))));
		r.add(output(f.Prim(Op.ADD, f.Data((long) 23), f.Data(234.345))));
		// r.add(f.Data(new byte[] { 0, 23, 34, 34, 45, 45, 3, 2, 23 }));
//		r.add(f.Data(new Date(1992, 11, 2)));
		r.add(f.Data(java.sql.Date.valueOf("1998-11-21")));
		r.add(makeExp());
		return r;
	}

	private Expression output(Expression expr) {
		return f.Out("g1", expr);
	}

	// method invocation
	@SuppressWarnings("deprecation")
	Expression makeExp() {
		Expression target = f.Prop(f.Var("xx"), "foo");
		Expression a1 = f.Data(new Date(1992, 11, 2));
		Expression b1 = f.Data("test\n\rbadstring{}!!\n\"'<>foo");
		Expression b2 = f.Var("mm");
		Expression a2 = f.Prim(Op.ADD, f.Data(33), f.Data(3.14));
		Expression call = f.Call(target, "bar", a1, a2);
		Expression s1 = f.Assign(f.Var("xx"), a2);
		Expression s2 = f.Prim(Op.SEQ, f.Assign(target, a1), call);
		Expression c = f.Prim(Op.EQ, b1, b2);
		Expression test = f.If(c, s1, s2);
		Expression let = f.Let("vv", f.Data(35), test);
		Expression loop = f.Loop("xx", f.Var("cc"), let);
		return loop;
	}

	@SuppressWarnings("deprecation")
	Forest makeForest() {
		Forest x = new Forest();
		x.put("a", "test string <>'\";&");
		x.put("b", 23);
		x.put("c", 23.34);
		x.put("d", new Date(1992, 11, 2));
		x.put("e", true);
		x.put("n", null);
		MultiForest m = x.newCollection("m");
		for (int i = 0; i < 3; i++) {
			Forest a = m.newIteration();
			a.put("x", i);
			a.put("y", "test " + i);
			a.put("z", 10 * 10 * i);
		}
		return x;
	}

	@Test
	public void testJSON() throws IOException {
		// generate expressions JSONTransport<SQLTranslation> trans = new
		// JSONTransport<SQLTranslation>();
		test(new JSONTransport());
	}

	@Test
	public void testXML() throws IOException {
		// generate expressions
		test(new XMLTransport());
	}

	@Test
	public void testScript() throws RecognitionException {
		Format formatter = new Format();
		for (Expression e : generateExpressions()) {
			String script = e.run(formatter);
			System.out.println("OUT: " + script);
			Expression e2;
			e2 = BatchScriptParser.parse(script);
			String script2 = e2.run(formatter);
			System.out.println("CHK: " + script2);
			Assert.assertEquals(script, script2);
		}
	}

	public void test(BatchTransport trans) throws IOException {
		checkForest(trans, makeForest());
	}

	private void checkForest(BatchTransport trans, Forest expr)
			throws IOException {
		// iterate
		// dump exp
		StringWriter out = new StringWriter();
		trans.write(expr, out);
		String x = out.toString();

		System.out.println(x);

		Reader in = new StringReader(x);
		// read exp
		Forest e2 = trans.read(in);

		StringWriter out2 = new StringWriter();
		trans.write(e2, out2);
		String x2 = out.toString();

		// the read expressions should equal the original
		Assert.assertEquals(x, x2);
		// System.out.println(e1);
	}

}
