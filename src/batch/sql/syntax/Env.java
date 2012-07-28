// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.sql.syntax;

public class Env {

	String name;
	SQLTranslation value;
	Env rest;
	SQLQuery rootQuery;

	public Env(SQLQuery rootQuery) {
		this.rootQuery = rootQuery;
	}
	
	public Env(String name, SQLTranslation value, Env rest) {
		super();
		this.name = name;
		this.value = value;
		this.rest = rest;
		this.rootQuery = rest.getRootQuery();
	}

	public SQLQuery getRootQuery() {
		return rootQuery;
	}

	SQLTranslation lookup(String name) {
		if (this.name.equals(name))
			return value;
		else
			return rest.lookup(name);
	}
}
