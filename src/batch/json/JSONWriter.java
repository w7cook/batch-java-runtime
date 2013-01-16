// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import batch.DataType;
import batch.util.ForestListWriter;
import batch.util.ForestWriter;
import batch.util.TransportHelper;

public class JSONWriter extends TransportHelper implements ForestWriter {

  JsonGenerator json;

  public JSONWriter(Writer out) throws IOException {
    out.write("Batch 1.0 JSON 1.0\n");
    json = new JsonFactory().createJsonGenerator(out);
    json.writeStartObject();
  }

  public JSONWriter(JsonGenerator json) throws IOException {
    this.json = json;
    json.writeStartObject();
  }

  public void put(String field, Object value) {
    DataType type = batch.DataType.fromJava(value);
    try {
      switch (type) {
      case Null:
        json.writeNullField(field);
        break;
      case String:
        json.writeStringField(field, (String) value);
        break;
      case Integer:
        json.writeNumberField(field, ((Number) value).longValue());
        break;
      case Boolean:
        json.writeBooleanField(field, (Boolean) value);
        break;
      case Float:
        json.writeNumberField(field, ((Number) value).doubleValue());
        break;
      case Decimal:
        json.writeNumberField(field, (java.math.BigDecimal) value);
        break;
      default:
        json.writeObjectFieldStart(field);
        json.writeStringField("*" + type.toString(), storeData(type, value));
        json.writeEndObject();
      }
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }

  class ListWriter implements ForestListWriter {
    JsonGenerator json;
    JSONWriter jsonWriter;
    int count = 0;

    public ListWriter(JsonGenerator json, JSONWriter jsonWriter) {
      this.json = json;
      this.jsonWriter = jsonWriter;
    }

    @Override
    public ForestWriter newIteration() {
      try {
//        if (count++ > 0)
//          json.writeEndObject();
        json.writeStartObject();
        return jsonWriter;
      } catch (IOException e) {
        throw new Error("JSON WRITER ERROR!");
      }
    }

    public void complete() {
      try {
        json.writeEndArray();
      } catch (IOException e) {
        throw new Error("JSON WRITER ERROR!");
      }
    }
  }

  @Override
  public ForestListWriter newTable(String field) {
    try {
      json.writeArrayFieldStart(field);
      return new ListWriter(json, this);
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }

  @Override
  public void complete() {
    try {
      json.writeEndObject(); // for field 'name'
      json.writeRaw('\n');
      json.flush();
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }
}
