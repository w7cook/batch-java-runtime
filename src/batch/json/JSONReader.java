// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import batch.DataType;
import batch.ExpressionReader;
import batch.util.DynamicFactory;
import batch.util.ExpressionBuilder;
import batch.util.Forest;
import batch.util.TransportHelper;

/*


 */
public class JSONReader extends TransportHelper implements ExpressionReader<Forest> {

	JsonFactory jsonFactory;
	JsonParser jp;
	DynamicFactory<Forest> factory;

	public JSONReader(DynamicFactory<Forest> factory) throws IOException {
		jsonFactory = new JsonFactory();
		this.factory = factory;
	}

	@Override
	public Forest read(Reader in) throws IOException {
		BufferedReader inb = new BufferedReader(in);
		String header = inb.readLine();
		return read(header, inb);
	}

	private void check(JsonToken expected) throws IOException {
		JsonToken next = jp.nextToken();
		if (next != expected)
			throw new Error("EXPECTED OBJECT START");
	}

	@Override
	public Forest read(String header, Reader in) throws IOException {
		if (!header.toLowerCase().equals("batch 1.0 json 1.0"))
			throw new Error("BAD FORMAT");
		jp = jsonFactory.createJsonParser(in);
		check(JsonToken.START_OBJECT);
		return readObject(null, null);
	}

	private Forest readObject(ExpressionBuilder<Forest> parent, String parentField) throws IOException {
		JsonToken token;
		String field = null;
		ExpressionBuilder<Forest> builder = null;
		while ((token = jp.nextToken()) != JsonToken.END_OBJECT) {
			switch (token) {
			case START_OBJECT: // START_OBJECT is returned when encountering '{'
				// which signals starting of an Object value.
				readObject(builder, field);
				break;
			case FIELD_NAME: // FIELD_NAME is returned when a String token is
				// encountered as a field name (same lexical
				// value, different function)
				field = jp.getCurrentName();
				if (builder == null) {
					if (field.charAt(0) == '*') {
						DataType type = DataType.fromString(field.substring(1));
						if (type != null) {
							check(JsonToken.VALUE_STRING);
							String data = jp.getText();
							check(JsonToken.END_OBJECT);
							parent.putField(parentField, loadData(type, data));
							return null;
						}
						else
							throw new IOException("Unkonwn type: " + field);
					}
					else
						builder = factory.make(field);
				}

				break;
			case VALUE_NULL: // VALUE_TRUE is returned when encountering literal
				// "true" in value context
				builder.putField(field, null);
				break;
			case VALUE_TRUE: // VALUE_TRUE is returned when encountering literal
				// "true" in value context
				builder.putField(field, true);
				break;
			case VALUE_FALSE: // VALUE_FALSE is returned when encountering
				// literal "false" in value context
				builder.putField(field, false);
				break;
			case VALUE_NUMBER_FLOAT: // VALUE_NUMBER_INT is returned when a
				// numeric token other that is not an
				// integer is encountered: that is, a
				// number that does have floating point
				// or exponent marker in it, in addition
				// to one or more digits.
				builder.putField(field, jp.getDoubleValue());
				break;
			case VALUE_NUMBER_INT: // VALUE_NUMBER_INT is returned when an
				// integer numeric token is encountered in
				// value context: that is, a number that
				// does not have floating point or exponent
				// marker in it (consists only of an
				// optional sign, followed by one or more
				// digits)
				builder.putField(field, jp.getLongValue());
				break;
			case VALUE_STRING: // VALUE_STRING is returned when a String token
				// is encountered in value context (array
				// element, field value, or root-level
				// stand-alone value)
				builder.putField(field, jp.getText());
				break;
			}
		}
		if (builder == null)
			builder = factory.make(null);
		Forest obj = builder.complete();
		if (parent != null)
			parent.putElement(parentField, obj);
		return obj;
	}
}
