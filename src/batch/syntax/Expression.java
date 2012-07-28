package batch.syntax;

import batch.util.BatchFactory;

public interface Expression {
	public abstract <E> E run(BatchFactory<E> f);
}