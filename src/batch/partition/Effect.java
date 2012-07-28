// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

public enum Effect {
	NONE, READ, WRITE;

	public Effect merge(Effect other) {
		if (this == NONE || other == WRITE)
			return other;
		else if (other == NONE || this == WRITE)
			return this;
		else
			return READ;
	}

	public boolean conflicts(Effect other) {
		return (this == READ && other == WRITE)
				|| (this == WRITE && other == READ)
				|| (this == WRITE && other == WRITE);
	}
};
