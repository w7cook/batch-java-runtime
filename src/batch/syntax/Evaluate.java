package batch.syntax;

import java.util.Map;

import batch.util.BatchCancel;
import batch.util.Forest;

public abstract class Evaluate {
	abstract public Object evaluate(Map<String, Object> env, Forest inputs,
			Forest results) throws BatchCancel;
}