// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import batch.util.BatchTransport;
import batch.util.Forest;

public class JSONTransport implements	BatchTransport {

	public void write(Forest data, Writer out) throws IOException {
		JSONWriter dumper = new JSONWriter(out);
		data.dump(dumper, null);
		dumper.finish();
	}

	public Forest read(Reader in) throws IOException {
		JSONReader reader = new JSONReader(Forest.dynamicFactory);
		return reader.read(in);
	}
}
