// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.xml;

import java.io.IOException;
import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import batch.DataType;
import batch.util.BatchDumper;
import batch.util.DumpExpression;
import batch.util.TransportHelper;

public class XMLWriter extends TransportHelper implements BatchDumper {

	XMLStreamWriter xml;
	boolean explicitFields;

	XMLWriter(Writer out, boolean explicitFields) throws IOException {
		this.explicitFields = explicitFields;
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		try {
			xml = factory.createXMLStreamWriter(out);
			xml.writeStartDocument();
			String root = "batch";
			xml.writeDTD("<!DOCTYPE " + root + " PUBLIC \"" + root
					+ "\" \"http://cs.utexas.edu/wcook/batch.dtd\">");
			xml.writeStartElement(root);
		} catch (XMLStreamException e) {
			throw new IOException("Error opening XML", e);
		}
	}

	public void finish() throws IOException {
		try {
			xml.writeEndDocument();
			xml.flush();
		} catch (XMLStreamException e) {
			throw new IOException("XML writer", e);
		}
	}

	@Override
	public void start(String tag) throws IOException {
		try {
			if (tag == null)
				tag = "data";
			xml.writeStartElement(tag);
		} catch (XMLStreamException e) {
			throw new IOException("XML writer", e);
		}
	}

	@Override
	public void end() throws IOException {
		try {
			xml.writeEndElement(); // for field 'name'
		} catch (XMLStreamException e) {
			throw new IOException("XML writer", e);
		}
	}

	@Override
	public void putAttribute(String field, String value) throws IOException {
		try {
			xml.writeAttribute(field, value.toString());
		} catch (XMLStreamException e) {
			throw new IOException("XML writer", e);
		}
	}

	@Override
	public void putData(String field, Object v) throws IOException {
		try {
			xml.writeStartElement(field);
			DataType type = DataType.fromJava(v);
			xml.writeAttribute("TYPE", type.toString());
			String value = storeData(type, v);
			if (type != DataType.Null)
				xml.writeCharacters(value);
			xml.writeEndElement(); // for field 'name'
		} catch (XMLStreamException e) {
			throw new IOException("XML writer", e);
		}
	}

	@Override
	public void putObject(String field, DumpExpression value)
			throws IOException {
		if (explicitFields)
			start(field);
		value.dump(this, null);
		if (explicitFields)
			end();
	}

	@Override
	public void beginList(String field) throws IOException {
		if (explicitFields)
			start(field);
	}

	@Override
	public void putItem(DumpExpression value) throws IOException {
		value.dump(this, null);
	}

	@Override
	public void endList() throws IOException {
		if (explicitFields)
			end();
	}
}
