// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;

import batch.DataType;
import batch.util.BatchDumper;
import batch.util.DumpExpression;
import batch.util.TransportHelper;

public class JSONWriter extends TransportHelper implements BatchDumper {

	JSONEncoder json;
	private String replaceField;

	public JSONWriter(Writer out) throws IOException {
		out.write("Batch 1.0 JSON 1.0\n");
		json = new JSONJacksonWrapper(new JsonFactory()
				.createJsonGenerator(out));
	}

	public JSONWriter(JSONEncoder json) throws IOException {
		this.json = json;
	}

	private String getField(String field) {
		if (replaceField != null) {
			field = replaceField;
			replaceField = null;
		}
		return field;
	}

	public void finish() throws IOException {
		json.flush();
	}

	@Override
	public void start(String tag) throws IOException {
		json.writeStartObject();
		if (tag != null)
			replaceField = tag;
	}

	@Override
	public void end() throws IOException {
		json.writeEndObject(); // for field 'name'
	}

	@Override
	public void putAttribute(String field, String value) throws IOException {
		json.writeStringField(getField(field), value.toString());
	}

	@Override
	public void putData(String field, Object value) throws IOException {
		DataType type = batch.DataType.fromJava(value);
		switch (type) {
		case Null:
			json.writeNullField(getField(field));
			break;
		case String:
			json.writeStringField(getField(field), (String) value);
			break;
		case Integer:
			json
					.writeNumberField(getField(field), ((Number) value)
							.longValue());
			break;
		case Boolean:
			json.writeBooleanField(getField(field), (Boolean) value);
			break;
		case Float:
			json.writeNumberField(getField(field), ((Number) value)
					.doubleValue());
			break;
		case Decimal:
			json.writeNumberField(getField(field),
							(java.math.BigDecimal) value);
			break;
		default:
			json.writeObjectFieldStart(getField(field));
			json.writeStringField("*" + type.toString(), storeData(type, value));
			json.writeEndObject();
		}
	}

	@Override
	public void putObject(String field, DumpExpression value)
			throws IOException {
		json.writeFieldName(getField(field));
		value.dump(this, null);
		// json.writeEndObject();
	}

	@Override
	public void beginList(String field) throws IOException {
		json.writeArrayFieldStart(getField(field));
	}

	@Override
	public void putItem(DumpExpression value) throws IOException {
		value.dump(this, null);
	}

	@Override
	public void endList() throws IOException {
		json.writeEndArray();
	}
}
