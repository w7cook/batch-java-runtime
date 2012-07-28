package batch;

import java.io.IOException;
import java.io.Reader;

public interface ExpressionReader<E> {

	public abstract E read(Reader in) throws IOException;

	public abstract E read(String header, Reader in) throws IOException;

}