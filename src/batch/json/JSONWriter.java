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

public class JSONWriter implements ForestWriter {

  JsonGenerator json;
  boolean startedObject;

  public JSONWriter(Writer out) throws IOException {
    out.write("Batch 1.0 JSON 1.0\n");
    json = new JsonFactory().createJsonGenerator(out);
  }

  public JSONWriter(JsonGenerator json) throws IOException {
    this.json = json;
  }

  public void put(String field, Object value) {
    DataType type = batch.DataType.fromJava(value);
    try {
      if (!startedObject) {
        json.writeStartObject();
      }
      startedObject = true;
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
        json.writeStringField("*" + type.toString(), TransportHelper.storeData(type, value));
        json.writeEndObject();
      }
      json.flush();
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }

  class ListWriter implements ForestListWriter {
    JsonGenerator json;
    JSONWriter jsonWriter;

    public ListWriter(JsonGenerator json, JSONWriter jsonWriter) {
      this.json = json;
      this.jsonWriter = jsonWriter;
      jsonWriter.startedObject = false;
    }

    @Override
    public ForestWriter newIteration() {
      try {
        if (jsonWriter.startedObject) {
          jsonWriter.startedObject = false;
          json.writeEndObject();
          json.flush();
        }
        return jsonWriter;
      } catch (IOException e) {
        throw new Error("JSON WRITER ERROR!");
      }
    }

    public void complete() {
      try {
        if (jsonWriter.startedObject) {
          json.writeEndObject();
        }
        json.writeEndArray();
        json.flush();
        // Still in parent object
        jsonWriter.startedObject = true;
      } catch (IOException e) {
        throw new Error("JSON WRITER ERROR!");
      }
    }
  }

  @Override
  public ForestListWriter newTable(String field) {
    try {
      json.writeArrayFieldStart(field);
      json.flush();
      return new ListWriter(json, this);
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }

  @Override
  public void complete() {
    try {
      if (!startedObject) {
        json.writeStartObject();
      }
      json.writeEndObject(); // for field 'name'
      json.writeRaw('\n');
      json.flush();
    } catch (IOException e) {
      throw new Error("JSON WRITER ERROR!");
    }
  }
}
