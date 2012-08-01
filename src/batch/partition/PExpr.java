// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.List;


public interface PExpr extends ExtraInfo<PExpr> {

	// partition an exp into a series of commands,
	// with a result in the specified place. If the caller
	// does not care where the result is, use MOBILE
	public History partition(Place place, Environment env);

	// check if a term has an effect.
	public Effects effects();

	// Determines whether a given stage needs to be delayed until
	// the end of a control flow construct. Let delays if the
	// variable is used in the stage. Loop delays if there are
	// effects of if the variable is used. If delays when there
	// is an effect.
	public boolean NeedDelay(Stage action);

	// determines whether or not the control flow operator
	// needs to be replicated in subsequent stages. Loops
	// are always replicated. Ifs are replicated except inside
	// some loops. Let is replicated for mobile values, but
	// / not otherwise.
	public boolean NeedReplicate(History control);

	// used to replicate a control construct
	public PExpr clone(List<PExpr> args);

	// called by loop to notify a sub-exp that it is 
	// in a loop. This is used to eliminate conditionals in 
	// replicated loops where the original returned a filtered data set
	public void inLoop();

	public String asVar();

	public <E> E runExtra(PartitionFactory<E> f);

}
