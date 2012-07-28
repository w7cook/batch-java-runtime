// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.ArrayList;
import java.util.List;

import batch.util.BatchFactoryHelper;

public abstract class PartitionFactoryHelper<E> extends BatchFactoryHelper<E> implements PartitionFactory<E> {

	public PartitionFactoryHelper() {
		super();
	}

	@Override
	public E Other(Object external, E... subs) {
		List<E> subList = new ArrayList<E>();
		for (E e : subs)
			subList.add(e);
		return Other(external, subList);
	}
}
