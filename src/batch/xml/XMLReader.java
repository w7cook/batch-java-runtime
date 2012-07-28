// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import batch.util.DynamicFactory;
import batch.util.ExpressionBuilder;
import batch.util.TransportHelper;

/*


 */
public class XMLReader<E> extends TransportHelper {

	XMLInputFactory xmlFactory;
	XMLStreamReader xml;
	DynamicFactory<E> factory;
	boolean explicitFields;

	XMLReader(DynamicFactory<E> factory, boolean explicitFields) {
		this.explicitFields = explicitFields;
		xmlFactory = XMLInputFactory.newInstance();
		this.factory = factory;
	}

	public E read(Reader in) throws IOException {
		BufferedReader inb = new BufferedReader(in);
		try {
			xml = xmlFactory.createXMLStreamReader(inb);
		} catch (XMLStreamException e) {
			throw new IOException("XML reader", e);
		}
		check(XMLStreamConstants.DTD); // TODO: check the DTD
		check(XMLStreamConstants.START_ELEMENT); // skip over root element
		check(XMLStreamConstants.START_ELEMENT);
		return readObject();
	}

	private void check(int expected) throws IOException {
		try {
			int token = xml.next();
			if (token == expected)
				return;
			throw new IOException("EXPECTED OBJECT START");
		} catch (XMLStreamException e) {
			throw new IOException("XML reader", e);
		}
	}

	public E read(String version, Reader in) throws IOException {
		return readObject();
	}

	private E readObject() throws IOException {
		ExpressionBuilder<E> builder = factory.make(xml.getLocalName());
		int num = xml.getAttributeCount();
		for (int i = 0; i < num; i++) {
			String attr = xml.getAttributeLocalName(i);
			builder.putField(attr, xml.getAttributeValue(i));
		}
		// for data
		String type = null;
		String field = null;

		int token;
		try {
			while ((token = xml.next()) != XMLStreamConstants.END_ELEMENT) {
				switch (token) {
				case XMLStreamConstants.START_ELEMENT:
					// which signals starting of an Object value.
					type = xml.getAttributeValue(null, "TYPE");
					if (type != null) {
						field = xml.getLocalName();
						if (type.equals("null")) {
							builder.putField(field, null);
							check(XMLStreamConstants.END_ELEMENT);
						}
					} else if (explicitFields) {
						field = xml.getLocalName();
						// read in possible array of values!
						while (xml.next() == XMLStreamConstants.START_ELEMENT)
							builder.putElement(field, readObject());
						// check(XMLStreamConstants.END_ELEMENT);
					} else {
						while (xml.getEventType() == XMLStreamConstants.START_ELEMENT)
							builder.putElement(readObject());
					}
					break;
				case XMLStreamConstants.CHARACTERS:
				case XMLStreamConstants.CDATA:
					if (type == null)
						throw new IOException("Unexpected data");

					String text = xml.getText();
					for (;;) {
						token = xml.next();
						if (token == XMLStreamConstants.CHARACTERS
								|| token == XMLStreamConstants.CDATA)
							text += xml.getText();
						else
							break;
					}
					Object value = loadData(type, text);
					builder.putField(field, value);
					// check(XMLStreamConstants.END_ELEMENT);
					break;
				case XMLStreamConstants.END_DOCUMENT:
					throw new IOException("Unexpected end");
				}
			}
		} catch (XMLStreamException e) {
			throw new IOException("XML reader", e);
		}
		return builder.complete();
	}
}
