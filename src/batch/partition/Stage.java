// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;


public class Stage {

	private Place place;
	private PExpr action;
	private String type; // only defined if this stage is mobile
	
	public Stage(Place place, PExpr action) {
		this.place = place;
		this.action = action;
		if (action == null)
			throw new Error("invalid parameter");
	}

	public String toString() {
		return place.toString() + ":" + action.toString();
	}
	
	public Place place() {
		return place;
	}

	public PExpr action() {
		return action;
	}

	public void makeOutput(CodeModel model, String sym, String type2) {
		action = CodeModel.factory.Out(sym, action).setExtraInfo(type2);
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static Stage empty(PartitionFactory<PExpr> factory) {
		return new Stage(Place.MOBILE, factory.Skip());
	}
}
