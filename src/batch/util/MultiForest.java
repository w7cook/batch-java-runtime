// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiForest implements Iterable<Forest> {

	// instance variables
	private List<Forest> iterations;
	private Forest parent;
	/**
	 * Default constructor
	 * @param forest 
	 */
	public MultiForest(Forest parent) {
		this.iterations = new ArrayList<Forest>();
		this.parent = parent;
	}

	@Override
	public Iterator<Forest> iterator() {
		return new Iterator<Forest>() {
			// iterations iterator
			final Iterator<Forest> innerItr = iterations.iterator();

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

	/**
	 * Creates a new Forest object and adds it to the iteration list.
	 * 
	 * @return a new Forest object.
	 */
	public Forest newIteration() {
		final Forest itr = new Forest();
		add(itr);
		return itr;
	}

	public void add(Forest itr) {
		itr.setParent(parent);
		iterations.add(itr);
	}

	/**
	 * Retrieves the Forest object for the given index.
	 * 
	 * @param index
	 *            the iteration index.
	 * @return the Forest object for the given index.
	 */
	public Forest getIteration(int index) {
		return iterations.get(index);
	}

	/**
	 * Returns the total number of iterations.
	 * 
	 * @return the total number of iterations.
	 */
	public int getNumberOfIterations() {
		return iterations.size();
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

	public void putItems(BatchDumper d) throws IOException {
		for (Forest t : iterations)
			d.putItem(t);
	}
}
