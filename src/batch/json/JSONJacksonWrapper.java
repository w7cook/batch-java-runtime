package batch.json;

import java.io.IOException;
import java.math.BigDecimal;

import org.codehaus.jackson.JsonGenerator;

public class JSONJacksonWrapper implements JSONEncoder {

	JsonGenerator json;

	public JSONJacksonWrapper(JsonGenerator json) throws IOException {
		this.json = json;
	}

	@Override
	public void flush() throws IOException {
		json.writeRaw('\n');
		json.flush();
	}

	@Override
	public void writeArrayFieldStart(String field) throws IOException {
		json.writeArrayFieldStart(field);
	}

	@Override
	public void writeBooleanField(String field, Boolean value)
			throws IOException {
		json.writeBooleanField(field, value);
	}

	@Override
	public void writeEndArray() throws IOException {
		json.writeEndArray();
	}

	@Override
	public void writeEndObject() throws IOException {
		json.writeEndObject();
	}

	@Override
	public void writeFieldName(String field) throws IOException {
		json.writeFieldName(field);
	}

	@Override
	public void writeNullField(String field) throws IOException {
		json.writeNullField(field);
	}

	@Override
	public void writeNumberField(String field, BigDecimal value)
			throws IOException {
		json.writeNumberField(field, value);
	}

	@Override
	public void writeNumberField(String field, double doubleValue)
			throws IOException {
		json.writeNumberField(field, doubleValue);
	}

	@Override
	public void writeObjectFieldStart(String field) throws IOException {
		json.writeObjectFieldStart(field);
	}

	@Override
	public void writeStartObject() throws IOException {
		json.writeStartObject();
	}

	@Override
	public void writeStringField(String string, String tag) throws IOException {
		json.writeStringField(string, tag);
	}

}
