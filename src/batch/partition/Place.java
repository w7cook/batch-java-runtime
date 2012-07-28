// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

public enum Place {

	MOBILE, LOCAL, REMOTE, UNKNOWN;

	public String toString() {
		switch (this) {
		case MOBILE: return "MOBILE";
		case LOCAL: return "LOCAL";
		case REMOTE: return "REMOTE";
		case UNKNOWN: return "UNKONWN";
		}
		return "BAD";
	}

	Place otherPlace() {
		if (this == Place.REMOTE)
			return Place.LOCAL;
		if (this == Place.LOCAL)
			return Place.REMOTE;
		return Place.MOBILE;
	}

	Place sameAs(Place p2) {
		if (this == p2)
			return this;
		if (this == Place.MOBILE)
			return p2;
		if (p2 == Place.MOBILE)
			return this;
		return Place.UNKNOWN;
	}

	public Place otherwise(Place p2) {
		if (this == Place.UNKNOWN || this == Place.MOBILE)
			return p2;
		return this;
	}
}
