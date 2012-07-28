// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql;


public abstract class Group<S, T> {
	public S Key;
	public Many<T> Items;
}

