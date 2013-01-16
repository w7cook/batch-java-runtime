// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql;

import batch.Fun;

public abstract class Many<T> implements Iterable<T> {

	abstract public Many<T> distinct();

	abstract public Many<T> first(int n);	
	
	abstract public T id(Object id);
	
	abstract public T create();

  abstract public <P extends Comparable<P>> Many<T> orderBy(Fun<T, P> f);
  abstract public <P extends Comparable<P>> Many<T> orderByDescending(Fun<T, P> f);

	abstract public int count();

	abstract public int count(Fun<T, Boolean> f);

	abstract public double average(Fun<T, Double> f);
	
	abstract public long sum(Fun<T, Long> f);
	abstract public double dsum(Fun<T, Double> f);

	abstract public long min(Fun<T, Long> f);
	abstract public double dmin(Fun<T, Double> f);

	abstract public long max(Fun<T, Long> f);
	abstract public double dmax(Fun<T, Double> f);

	abstract public boolean exists();

	abstract public boolean exists(Fun<T, Boolean> f);

	abstract public boolean all(Fun<T, Boolean> f);

	abstract public <I> Many<I> project(Fun<T,I> f);

	abstract public <I> Many<Group<I, T>> groupBy(Fun<T, I> f);
}

/*
Many<T> range(int n, int m);

	abstract public Many<T> where(Fun<T, Boolean> f);
	
abstract public Many<T> union(Many<T> s);

abstract public Many<T> intersect(Many<T> s);
*/