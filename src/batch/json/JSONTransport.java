// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import batch.util.BatchTransport;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class JSONTransport implements	BatchTransport {

	public ForestWriter writer(Writer out) throws IOException {
		return new JSONWriter(out);
	}

	public ForestReader read(Reader in) throws IOException {
		return new JSONReader(in);
	}
}
