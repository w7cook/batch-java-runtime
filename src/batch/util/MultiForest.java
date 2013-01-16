// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiForest implements Iterable<ForestReader>, ForestListWriter {

  // instance variables
  private List<Forest> iterations;
  private Forest parent;

  /**
   * Default constructor
   * 
   * @param forest
   */
  public MultiForest(Forest parent) {
    this.iterations = new ArrayList<Forest>();
    this.parent = parent;
  }

  @Override
  public Iterator<ForestReader> iterator() {
    return new Iterator<ForestReader>() {
      // iterations iterator
      final Iterator<Forest> innerItr = forestIterator();

      @Override
      public boolean hasNext() {
        return innerItr.hasNext();
      }

      @Override
      public Forest next() {
        return innerItr.next();
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  public Iterator<Forest> forestIterator() {
    return iterations.iterator();
  }

  /**
   * Creates a new Forest object and adds it to the iteration list.
   * 
   * @return a new Forest object.
   */
  @Override
  public Forest newIteration() {
    final Forest itr = new Forest();
    itr.setParent(parent);
    iterations.add(itr);
    return itr;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (Forest t : iterations) {
      sb.append("\n" + i + ":");
      sb.append(t.toString());
      i++;
    }
    return sb.toString();
  }

  @Override
  public void complete() {
    // nothing to do here
  }

  public void copyTo(ForestListWriter list) {
    for (Forest f : iterations)
      f.copyTo(list.newIteration());
  }

}
