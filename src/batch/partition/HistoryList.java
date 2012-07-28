// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoryList implements java.lang.Iterable<History> {
	public List<History> items = new ArrayList<History>();

	CodeModel model;

	public HistoryList(CodeModel model) {
		this.model = model;
	}

	int length() {
		int max = 0;
		for (History h : this)
			max = Math.max(max, h.length());
		return max;
	}

	public int numHistories() {
		return items.size();
	}

	public void add(History h) {
		items.add(h);
	}

	@Override
	public Iterator<History> iterator() {
		return items.iterator();
	}

	public History get(int i) {
		return items.get(i);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (History s : items) {
			sb.append("--- " + i + " ---\n");
			sb.append(s.toString());
		}
		sb.append("*****\n");
		return sb.toString();
	}

	public Place all_same(int step) {
		Place result = Place.MOBILE;
		for (History h : items)
			result = result.sameAs(h.get(step).place());
		return result;
	}

	public Place pick_place() {
		Place p = all_same_longest(-1);
		if (p == Place.UNKNOWN) {
			if (length() % 2 == 0)
				return Place.LOCAL;
			else
				return Place.REMOTE;
		}
		return p;
	}

	// are the longest histories all the same place at a given step?
	public Place all_same_longest(int step) {
		Place result = Place.MOBILE;
		int length = length();
		for (History h : items)
			if (h.length() == length)
				result = result.sameAs(h.get(step).place());
		return result;
	}

	private void delay_place(int step, Place place) {
		for (History h : this)
			h.delay_place(step, place);
	}

	// make sure each history is same length, delaying as necessary
	void fill_history() {
		int overallLen = length();
		for (History h : this)
			h.extendLast(overallLen);
	}

	History merge_simple(int to, PExpr before, PExpr eq, PExpr after) {
		History result = new History(model);
		for (int step = 0; step < length(); step++) {
			Place place = all_same(step).otherwise(Place.MOBILE);
			List<PExpr> args = new ArrayList<PExpr>();
			for (History h : this)
				args.add(h.get(step).action());
			PExpr e;
			if (step < to) {
				e = before.clone(args);
			} else if (step == to) {
				e = eq.clone(args);
			} else {
				e = after.clone(args);
			}
			result.add(new Stage(place, e));
		}
		return result.trim();
	}

	public void align_control(PExpr test, Place desired) {
		align();
		int controlStage = get(0).length() - 1;
		// this may get the stages out of alignment
		for (History h : this)
			h.delay_until(test, controlStage);
		// last stage
		Place place = get(0).get(controlStage).place();
		if (place == Place.MOBILE)
			place = all_same(controlStage);
		if (place == Place.UNKNOWN)
			place = Place.LOCAL;
		// now they are back in alignment
		for (History h : this)
			h.delay_place(controlStage, place);
		// output is needed (for if or let)
		if (desired != Place.UNKNOWN && desired != Place.MOBILE) {
			for (int i = 1; i < numHistories(); i++)
				get(i).promote_output(desired);
			fill_history();
		}
		align_effects(true);
	}

	public void align() {
		delay_place(0, all_same_longest(0).otherwise(Place.LOCAL));
	}

	public History merge_control(PExpr make, Place desired) {
		align_control(make, desired);
		int len = length();
		History control = get(0);
		int controlLen = control.length();
		History result;
		PExpr before = CodeModel.factory.Skip();
		PExpr after = CodeModel.factory.Skip();
		if (len > controlLen && make.NeedReplicate(control)) {
			// replicate
			for (int i = controlLen + 1; i < len; i++)
				control.add(control.last());
			after = make;
		}
		result = merge_simple(controlLen - 1, before, make, after);
		return result;
	}

	// align the final stages
	public History merge_outputs_at(Place required, PExpr last) {
		prepare_merge(required);
		return merge_simple(length() - 1, CodeModel.factory.Skip(), last, null);
	}

	void prepare_merge(Place required) {
		Place place = required.otherwise(pick_place());
		for (History h : this)
			h.promote_output(place);
		// all must end with same place now
		align(); // align the first stages
		align_effects(false);
		// now they are alligned
		fill_history();
	}

	private void align_effects(boolean onlyWithFirst) {
		ArrayList<Effects> effects = new ArrayList<Effects>();
		int col = 0;
		for (History h : this) {
			if (col > 0)
				for (int step = 0; step < h.length(); step++) {
					while (effects.size() <= h.length() + 2)
						effects.add(Effects.noEffect);
					Effects baseEffects = effects.get(step + 2);
					Effects stepEffects = h.get(step).action().effects();
					if (baseEffects.conflicts(stepEffects))
						h.delay(step, 2);
				}
			if (col == 0 || !onlyWithFirst)
				for (int step = effects.size(); --step >= 0; ) {
					Effects stepEffects = h.get(step).action().effects();
					effects.set(step, effects.get(step).union(stepEffects));
				}
			col++;
		}

	}
}
