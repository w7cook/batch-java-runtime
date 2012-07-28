// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.syntax;

import java.util.ArrayList;
import java.util.List;

import batch.Op;
import batch.util.BatchFactory;
import batch.util.BatchFactoryHelper;

public class Factory extends BatchFactoryHelper<Expression> {

	@Override
	public Expression Assign(final Expression target,
			final Expression source) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Assign(target.run(f), source.run(f));
			}
		};
	}

	@Override
	public Expression Data(final Object value) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Data(value);
			}
		};
	}

	@Override
	public Expression Prop(final Expression base, final String field) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Prop(base.run(f), field);
			}
		};
	}

	@Override
	public Expression If(final Expression cond, final Expression thenExp, final Expression elseExp) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.If(cond.run(f), thenExp.run(f), elseExp.run(f));
			}
		};
	}

	@Override
	public Expression In(final String location) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.In(location);
			}
		};
	}

	@Override
	public Expression Call(final Expression target, final String method, final List<Expression> args) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				List<E> trans = new ArrayList<E>();
				for (Expression x : args)
					trans.add(x.run(f));
				return f.Call(target.run(f), method, trans);
			}
		};
	}

	@Override
	public Expression Let(final String var, final Expression exp, final Expression body) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Let(var, exp.run(f), body.run(f));
			}
		};
	}

	@Override
	public Expression Loop(final String var, final Expression collection, final Expression body) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Loop(var, collection.run(f), body.run(f));
			}
		};
	}

	@Override
	public Expression Prim(final Op op, final List<Expression> args) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				List<E> trans = new ArrayList<E>();
				for (Expression x : args)
					trans.add(x.run(f));
				return f.Prim(op, trans);
			}
		};
	}

	@Override
	public Expression Out(final String location, final Expression exp) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Out(location, exp.run(f));
			}
		};
	}

	@Override
	public Expression Var(final String name) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Var(name);
			}
		};
	}

	@Override
	public Expression Fun(final String var, final Expression body) {
		return new Expression() {
			public <E> E run(BatchFactory<E> f) {
				return f.Fun(var, body.run(f));
			}
		};
	}

	public static <E> E binary(BatchFactory<E> factory, Op op, E c1, E c2) {
		if (c1 == null)
			return c2;
		if (c2 == null)
			return c1;
		List<E> args = new ArrayList<E>(2);
		args.add(c1);
		args.add(c2);
		return factory.Prim(op, args);
	}

}
