// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.util;

import java.io.IOException;

public interface BatchDumper {
	void start(String tag) throws IOException;

	// ordinary fields
	void putAttribute(String field, String value) throws IOException;

	// data fields
	void putData(String string, Object value) throws IOException;

	// object fields
	void putObject(String field, DumpExpression value) throws IOException;

	// for lists
	void beginList(String field) throws IOException;

	void putItem(DumpExpression value) throws IOException;

	void endList() throws IOException;

	void end() throws IOException;

}
