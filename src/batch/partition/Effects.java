// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ListEffects extends Effects {

	Map<String, Effect> vars;

	public ListEffects(Effect heap, Map<String, Effect> vars) {
		super(heap, null);
		this.vars = vars;
	}

	public Iterator<String> vars() {
		return vars.keySet().iterator();
	}

	public Effect getVarEffect(String name) {
		Effect effect = vars.get(name);
		if (effect == null)
			effect = Effect.NONE;
		return effect;
	}

	public boolean hasWriteEffect() {
		for (Effect effect : vars.values())
			if (effect == Effect.WRITE)
				return true;
		return false;
	}

}

class AppendIterator<T> implements Iterator<T> {
	Iterator<T> a;
	Iterator<T> b;

	AppendIterator(Iterator<T> a, Iterator<T> b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean hasNext() {
		if (a.hasNext())
			return true;
		else if (b != null) {
			a = b;
			b = null;
			return a.hasNext();
		}
		return false;
	}

	@Override
	public T next() {
		return a.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}

class UnionEffects extends Effects {
	Effects next2;

	public UnionEffects(Effects next, Effects next2) {
		super(next.heapEffect().merge(next2.heapEffect()), next);
		this.next2 = next2;
	}

	public Effect getVarEffect(String name) {
		return next.getVarEffect(name).merge(next2.getVarEffect(name));
	}

	public Iterator<String> vars() {
		return new AppendIterator<String>(next.vars(), next2.vars());
	}

	public boolean hasWriteEffect() {
		return next.hasWriteEffect() || next2.hasWriteEffect();
	}
}

public class Effects {

	public static Effects noEffect = new Effects(Effect.NONE, null);
	public static Effects readHeap = new Effects(Effect.READ, null);
	public static Effects writeHeap = new Effects(Effect.WRITE, null);
	Effect heap;
	Effects next;

	public Effects(Effect heap, Effects next) {
		super();
		this.heap = heap;
		this.next = next;
	}

	// add new effects
	public Effects readVar(String name) {
		if (getVarEffect(name) != Effect.NONE)
			return this;
		else
			return updateVar(name, Effect.READ);
	}

	public Effects writeVar(String name) {
		if (getVarEffect(name) == Effect.WRITE)
			return this;
		else
			return updateVar(name, Effect.WRITE);
	}

	public Effects removeVar(String name) {
		if (getVarEffect(name) == Effect.NONE)
			return this;
		else
			return updateVar(name, Effect.NONE);
	}

	private Effects updateVar(String name, Effect effect) {
		Map<String, Effect> vars = new HashMap<String, Effect>();
		Iterator<String> it = this.vars();
		while (it.hasNext()) {
			String s = it.next();
			vars.put(s, getVarEffect(s));
		}
		vars.put(name, effect);
		return new ListEffects(heap, vars);
	}

	public Effects readHeap() {
		return new Effects(heap.merge(Effect.READ), this);
	}

	public Effects writeHeap() {
		return new Effects(heap.merge(Effect.WRITE), this);
	}

	// test for effects
	public boolean hasWriteEffect() {
		return heapEffect() == Effect.WRITE
				|| (next != null && next.hasWriteEffect());
	}

	public Effect heapEffect() {
		return heap;
	}

	public Effect getVarEffect(String name) {
		if (next == null)
			return Effect.NONE;
		else
			return next.getVarEffect(name);
	}

	static ArrayList<String> emptyStringList = new ArrayList<String>();

	public Iterator<String> vars() {
		if (next != null)
			return next.vars();
		else
			return emptyStringList.iterator();
	}

	public Effects union(Effects other) {
		if (this == noEffect)
			return other;
		else if (other == noEffect)
			return this;
		else
			return new UnionEffects(this, other);
	}

	public boolean conflicts(Effects other) {
		if (this.heapEffect().conflicts(other.heapEffect()))
			return true;

		Iterator<String> it = this.vars();
		while (it.hasNext()) {
			String s = it.next();
			if (getVarEffect(s).conflicts(other.getVarEffect(s)))
				return true;
		}
		return false;
	}

}
