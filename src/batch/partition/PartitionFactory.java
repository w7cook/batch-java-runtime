// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.List;

import batch.util.BatchFactory;

public interface PartitionFactory<E> extends BatchFactory<E> {

	public E Other(Object external, E... subs);

	public E Other(Object external, List<E> subs);

	public E DynamicCall(E target, String method, List<E> args);

	public E Mobile(String type, E exp);
	
	public E setExtra(E exp, Object extraKey, Object extraInfo);
}
