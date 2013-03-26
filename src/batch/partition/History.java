// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class History implements java.lang.Iterable<Stage> {

	public List<Stage> stages = new ArrayList<Stage>();
	CodeModel model;

	public History(CodeModel model) {
		this.model = model;
	}

	public History add(Stage stage) {
		stages.add(stage);
		return this;
	}

	public Stage first() {
		return get(0);
	}

	public Stage last() {
		return get(stages.size() - 1);
	}

	public int length() {
		return stages.size();
	}

	public Stage get(int step) {
		if (step < 0)
			step += length();
		if (step < 0 || step >= length())
			return model.emptyStage();
		else
			return stages.get(step);
	}

	@Override
	public Iterator<Stage> iterator() {
		return stages.iterator();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Stage s : stages) {
			sb.append(s.toString());
			sb.append('\n');
		}
		return sb.toString();
	}

	void extendLast(int len) {
		if (length() > 0)
			while (length() < len)
				stages.add(length() - 1, model.emptyStage());
	}

	static public int counter = 0;

	// //////////////////////////////////////////////////////////////////////
	// general output promotion
	void promote_output(Place desired) {
		if (last().place().sameAs(desired) == Place.UNKNOWN) {
			if (model.allowAllTransers || last().getType() != null)
				do_promote();
			else
				throw new Error("Can't transfer " + last().action());
		}
	}

	public void do_promote() {
		String type = last().getType();
		String sym = "g" + counter++;
		last().makeOutput(model, sym, type);
		add(new Stage(Place.MOBILE, 
      CodeModel.factory.In(sym).setExtra(DynamicCallInfo.TYPE_INFO_KEY,type)));
	}

	// delay a behavior until a stage where it can be executed // used for
	// input/control flow dependencies
	void delay_place(int step, Place desired) {
		if (get(step).place().sameAs(desired) == Place.UNKNOWN)
			delay(step, 1);
	}

	public void delay(int step, int num) {
		while (num-- > 0)
			stages.add(step, model.emptyStage());
	}

	public void delay_until(PExpr test, int pos) {
		for (int step = 0; step < pos; step++)
			if (test.NeedDelay(get(step))) {
				delay(step, pos - step);
				return;
			}
	}

	public History trim() {
		PExpr skip = CodeModel.factory.Skip();
		while (length() > 0 && first().action() == skip)
			stages.remove(0);
		while (length() > 0 && last().action() == skip)
			stages.remove(length() - 1);
		return this;
	}

}
