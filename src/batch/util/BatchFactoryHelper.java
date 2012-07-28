// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.util.ArrayList;
import java.util.List;

import batch.Op;

public abstract class BatchFactoryHelper<E> implements BatchFactory<E> {

	public static String ROOT_VAR_NAME = "*";
	private E root;
	private E skip;

	public BatchFactoryHelper() {
		this.root = Var(ROOT_VAR_NAME);
		this.skip = Prim(Op.SEQ, new ArrayList<E>());
	}

	@SuppressWarnings("unchecked")
  @Override
	public E Prim(Op op, Object... args) {
		if (args.length == 0 && op == Op.SEQ)
			return Skip();
		if (args.length == 1 && !op.unary())
			return (E)args[0];
		List<E> argList = new ArrayList<E>();
		for (Object arg : args)
			argList.add((E)arg);
		return Prim(op, argList);
	}

	@Override
	public E Prim(Op op, List<E> args) {
		if (args == null || args.size() == 0)
			return Prim(op);
		if (args.size() == 1 && !op.unary())
			return args.get(0);
		else
			return Prim(op, args);
	}

	@SuppressWarnings("unchecked")
  @Override
	public E Call(E target, String method, Object... args) {
		List<E> argList = new ArrayList<E>();
		for (Object arg : args)
			argList.add((E)arg);
		return Call(target, method, argList);
	}

	@Override
	public String RootName() {
		return ROOT_VAR_NAME;
	}

	@Override
	public E Root() {
		return root;
	}

	public E Skip() {
		return skip;
	}

	@Override
	public E Assign(E target, E source) {
		return Assign(Op.SEQ, target, source);
	}

}
