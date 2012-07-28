package batch.util;

import java.io.IOException;

public interface DumpExpression {
	public void dump(BatchDumper d, Object flag) throws IOException;
}
