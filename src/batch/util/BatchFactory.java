// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.util.List;

import batch.Op;

public interface BatchFactory<E> {

	// variable reference
	E Var(String name);
	// simple constant (number, string, or date)
	E Data(Object value);
	E Fun(String var, E body);
	// unary and binary operators
	E Prim(Op op, List<E> args);
	// field access
	E Prop(E base, String field);
	// assignment. Target must be Var or Dot
	E Assign(Op op, E target, E source);
	// control flow
	E Let(String var, E expression, E body);
	E If(E condition, E thenExp, E elseExp);
	E Loop(String var, E collection, E body);
	// method invocation
	E Call(E target, String method, List<E> args);
	// reading and writing forest 
	E In(String location);
	E Out(String location, E expression);

	// Helper function
	String RootName();
	E Root();
	E Assign(E target, E source);
	E Prim(Op op, Object... args); // dynamic typing, because new E[] is not legal
	E Call(E target, String method, Object... args);
	E Skip();
}
