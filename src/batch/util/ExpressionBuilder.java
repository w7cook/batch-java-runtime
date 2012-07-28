// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

public interface ExpressionBuilder<E> {
	// ordinary fields (attributes and sub-objects)
	void putField(String field, Object value);

	// named access to elements
	void putElement(String field, E value);
	
	// putting sub-objects by order (not field name)
	void putElement(E value) ;
	
	// complete the object
	E complete();
}
