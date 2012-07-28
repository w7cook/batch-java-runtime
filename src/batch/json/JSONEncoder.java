package batch.json;

import java.io.IOException;
import java.math.BigDecimal;

public interface JSONEncoder {

	void writeStringField(String string, String tag) throws IOException;

	void writeNullField(String field) throws IOException;

	void writeNumberField(String field, BigDecimal value) throws IOException;

	void writeBooleanField(String field, Boolean value) throws IOException;

	void writeNumberField(String field, double doubleValue) throws IOException;

	void writeStartObject() throws IOException;

	void writeEndObject() throws IOException;

	void writeFieldName(String field) throws IOException;

	void writeObjectFieldStart(String field) throws IOException;

	void writeArrayFieldStart(String field) throws IOException;

	void writeEndArray() throws IOException;

	void flush() throws IOException;
}
