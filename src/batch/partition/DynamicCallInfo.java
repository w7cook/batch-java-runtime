// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.List;

public class DynamicCallInfo {
  public static final Object TYPE_INFO_KEY = new Object();

	public Place returns;
	public List<Place> arguments;
	public DynamicCallInfo(Place returns, List<Place> arguments) {
		super();
		this.returns = returns;
		this.arguments = arguments;
	}
}
