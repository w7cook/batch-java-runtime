// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.syntax;

import java.util.Map;

import batch.util.Forest;

public class FunClosure<E extends Evaluate> {
	String var;
	Map<String, Object> env;
	E body;
	Forest inputs;

	public FunClosure(String var, E body, Map<String, Object> env, Forest inputs) {
		this.var = var;
		this.body = body;
		this.env = env;
		this.inputs = inputs;
	}

	public Object apply(Object arg, Forest results) {
		env.put(var, arg);
		return body.evaluate(env, inputs, results);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("COSURE(");
		sb.append(var);
		sb.append(")");
		return sb.toString();
	}
}
