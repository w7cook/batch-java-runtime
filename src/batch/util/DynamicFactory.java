// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

public interface DynamicFactory<E> {
	ExpressionBuilder<E> make(String kind);
}
