package batch.syntax;

import java.util.Map;

import batch.util.BatchCancel;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public abstract class Evaluate {
	abstract public Object evaluate(Map<String, Object> env, ForestReader inputs,
			ForestWriter results) throws BatchCancel;
}