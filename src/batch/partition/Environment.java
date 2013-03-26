// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.List;

public class Environment {

	CodeModel model;

	public Environment(CodeModel model) {
		this.model = model;
	}

	public Environment extend(
      String var,
      List<CodeModel.KeyValuePair<Object,Object>> info,
      Place place) {
		return new ExtendedEnvironment(model, var, info, place, this);
	}

	public History lookup(
      String name,
      List<CodeModel.KeyValuePair<Object,Object>> extras) {
	  // allow undefined variables
		return new History(model).add(new Stage(Place.LOCAL, CodeModel.factory
				.Var(name).setExtras(extras)));
	}
}

class ExtendedEnvironment extends Environment {

	String varName;
	PExpr var;
	Place place;
	Environment next;

	public ExtendedEnvironment(
      CodeModel model,
      String name,
      List<CodeModel.KeyValuePair<Object,Object>> extras,
      Place place,
			Environment next) {
		super(model);
		this.varName = name;
		this.var = CodeModel.factory.Var(name).setExtras(extras);
		this.place = place;
		this.next = next;
	}

	public Environment extend(
      String var,
      List<CodeModel.KeyValuePair<Object,Object>> info, Place place) {
		return new ExtendedEnvironment(model, var, info, place, this);
	}

	public History lookup(
      String name,
      List<CodeModel.KeyValuePair<Object,Object>> extras) {
		if (name.equals(varName))
			return new History(model).add(new Stage(place, var));
		else
			return next.lookup(name, extras);
	}
}
