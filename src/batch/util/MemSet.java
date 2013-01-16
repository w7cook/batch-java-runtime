// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import batch.Fun;
import batch.sql.Group;
import batch.sql.Many;

public class MemSet<T> extends Many<T> {

  java.util.List<T> items = new java.util.ArrayList<T>();

  public static <T> MemSet<T> make(T... init) {
    MemSet<T> set = new MemSet<T>();
    for (T val : init)
      set.add(val);
    return set;
  }

  public MemSet() {
  }

  @Override
  public Many<T> distinct() {
    MemSet<T> result = new MemSet<T>();
    for (T elem : this) {
      if (!result.contains(elem))
        result.add(elem);
    }
    return result;
  }

  private boolean contains(T elem) {
    return items.contains(elem);
  }

  public double average(Fun<T, Double> f) {
    double sum = 0;
    int count = 0;
    for (T x : items) {
      count++;
      sum += f.apply(x);
    }
    return sum / count;
  }

  public long sum(Fun<T, Long> f) {
    long sum = 0;
    for (T x : items) {
      sum += f.apply(x);
    }
    return sum;
  }

  public double dsum(Fun<T, Double> f) {
    double sum = 0;
    for (T x : items) {
      sum += f.apply(x);
    }
    return sum;
  }

  public long min(Fun<T, Long> f) {
    long min = 0;
    boolean hasMin = false;
    for (T x : items) {
      if (hasMin)
        min = Math.min(min, f.apply(x));
      else {
        min = f.apply(x);
        hasMin = true;
      }
    }
    return min;
  }

  public double dmin(Fun<T, Double> f) {
    double min = 0;
    boolean hasMin = false;
    for (T x : items) {
      if (hasMin)
        min = Math.min(min, f.apply(x));
      else {
        min = f.apply(x);
        hasMin = true;
      }
    }
    return min;
  }

  public long max(Fun<T, Long> f) {
    long max = 0;
    boolean hasmax = false;
    for (T x : items) {
      if (hasmax)
        max = Math.max(max, f.apply(x));
      else {
        max = f.apply(x);
        hasmax = true;
      }
    }
    return max;
  }

  public double dmax(Fun<T, Double> f) {
    double max = 0;
    boolean hasmax = false;
    for (T x : items) {
      if (hasmax)
        max = Math.max(max, f.apply(x));
      else {
        max = f.apply(x);
        hasmax = true;
      }
    }
    return max;
  }

  public Many<T> first(int n) {
    MemSet<T> result = new MemSet<T>();
    int i = 0;
    for (T x : items) {
      if (++i > n)
        break;
      result.add(x);
    }
    return result;
  }

  public void add(T x) {
    items.add(x);
  }

  public boolean exists() {
    return items.size() > 0;
  }

  public boolean exists(Fun<T, Boolean> f) {
    for (T x : items) {
      if (f.apply(x))
        return true;
    }
    return false;
  }

  public boolean all(Fun<T, Boolean> f) {
    for (T x : items) {
      if (!f.apply(x))
        return false;
    }
    return true;
  }

  public enum Direction {
    ASC, DESC
  }

  @Override
  public int count() {
    return items.size();
  }

  @Override
  public int count(Fun<T, Boolean> f) {
    int num = 0;
    for (T x : items) {
      if (f.apply(x))
        num++;
    }
    return num;
  }

  @Override
  public Iterator<T> iterator() {
    return items.iterator();
  }

  @Override
  public T id(Object id) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
  @Override
  public Many<T> where(Fun<T, Boolean> f) {
  	// TODO Auto-generated method stub
  	return null;
  }
  */

  @Override
  public T create() {
    throw new Error("Can't create in a memory set");
  }

  @Override
  public <P extends Comparable<P>> Many<T> orderBy(Fun<T, P> f) {

    final Fun<T, P> g = f;
    class TComp implements Comparator<T> {
      public int compare(T o1, T o2) {
        return g.apply(o1).compareTo(g.apply(o2));
      }
    }
    Collections.sort(items, new TComp());
    return this;
  }

  @Override
  public <P extends Comparable<P>> Many<T> orderByDescending(Fun<T, P> f) {
    final Fun<T, P> g = f;
    class TComp implements Comparator<T> {
      public int compare(T o1, T o2) {
        return -g.apply(o1).compareTo(g.apply(o2));
      }
    }
    Collections.sort(items, new TComp());
    return this;
  }

  @Override
  public <I> Many<Group<I, T>> groupBy(Fun<T, I> f) {
    Map<I, Many<T>> map = new HashMap<I, Many<T>>();
    for (T item : items) {
      I key = f.apply(item);
      if (map.containsKey(key))
        ((MemSet<T>) map.get(key)).add(item);
      else {
        MemSet<T> vals = new MemSet<T>();
        vals.add(item);
        map.put(key, vals);
      }
    }

    MemSet<Group<I, T>> results = new MemSet<Group<I, T>>();
    for (Entry<I, Many<T>> e : map.entrySet()) {
      results.add(new MemGroup<I, T>(e.getKey(), e.getValue()));
    }

    return results;
  }

  @Override
  public <I> Many<I> project(Fun<T, I> f) {
    MemSet<I> results = new MemSet<I>();
    for (T item : items)
      results.add(f.apply(item));
    return results;
  }

  /*
  @Override
  public Many<T> union(Many<T> s) {
    MemSet<T> ms = new MemSet<T>();
    for (T item : s)
      ms.add(item);
    for (T item : this)
      if (!ms.contains(item))
        ms.add(item);
    return ms;
  }
  
  @Override
  public Many<T> intersect(Many<T> s) {
    MemSet<T> ms = new MemSet<T>();
    for (T item : s)
      if (this.contains(item))
        ms.add(item);
    return ms;
  }
  */
}
