// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

@SuppressWarnings("serial")
public class BatchException extends Error {
	public BatchException(Throwable nested) {
		super(nested);
	}
}
