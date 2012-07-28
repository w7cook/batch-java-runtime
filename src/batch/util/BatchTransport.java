// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public interface BatchTransport {

	void write(Forest data, Writer out) throws IOException;

	Forest read(Reader in) throws IOException;
}
