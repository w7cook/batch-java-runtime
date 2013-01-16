// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.xml;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import batch.util.BatchTransport;
import batch.util.Forest;

public class XMLTransport implements
		BatchTransport {

	public Forest writer(Writer out) throws IOException {
		XMLWriter dumper = new XMLWriter(out, false);
		data.dump(dumper, null);
		dumper.finish();
	}

	@Override
	public Forest read(Reader in) throws IOException {
		XMLReader<Forest> reader = new XMLReader<Forest>(Forest.dynamicFactory, true);
		return reader.read(in);
	}

}
