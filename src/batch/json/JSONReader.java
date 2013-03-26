// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Iterator;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import batch.DataType;
import batch.util.ForestListWriter;
import batch.util.ForestReader;
import batch.util.ForestReaderHelper;
import batch.util.ForestWriter;
import batch.util.TransportHelper;

/*


 */
public class JSONReader extends ForestReaderHelper {

  JsonParser jp;
  boolean inTable;

  public JSONReader(Reader in) throws IOException {
    BufferedReader buf = new BufferedReader(in);
    String header = buf.readLine();

    if (!header.toLowerCase().equals("batch 1.0 json 1.0"))
      throw new Error("BAD FORMAT");
    JsonFactory jsonFactory;
    jsonFactory = new JsonFactory();
    jp = jsonFactory.createJsonParser(buf);
    check(JsonToken.START_OBJECT);
    inTable = false;
  }

  private JsonToken nextToken() {
    JsonToken next;
    try {
      next = jp.nextToken();
      return next;
    } catch (Exception e) {
      throw new Error("JSON Parser Error");
    }
  }

  private void mustEqual(JsonToken expected, JsonToken given) {
    if (given != expected)
      throw new Error("EXPECTED " + expected + " FOUND " + given);
  }

  private void check(JsonToken expected) {
    mustEqual(expected, nextToken());
  }

  private void checkFieldName(String request) {
    check(JsonToken.FIELD_NAME); // FIELD_NAME is returned when a String token is
    // encountered as a field name (same lexical
    // value, different function)
    try {
      String field = jp.getCurrentName();
      if (!field.equals(request))
        throw new Error("Mismatched field: " + request + " expected but found "
            + field);
    } catch (JsonParseException e) {
      throw new Error("JSON Parser Error");
    } catch (IOException e) {
      throw new Error("JSON Parser Error");
    }
  }

  @Override
  public Object get(String request) {
    checkFieldName(request);
    nextToken();
    return get();
  }

  private Object get() {
    try {
      JsonToken token = jp.getCurrentToken();
      switch (token) {
      case VALUE_NULL: // VALUE_TRUE is returned when encountering literal
        // "true" in value context
        return null;
      case VALUE_TRUE: // VALUE_TRUE is returned when encountering literal
        // "true" in value context
        return true;
      case VALUE_FALSE: // VALUE_FALSE is returned when encountering
        // literal "false" in value context
        return false;
      case VALUE_NUMBER_FLOAT: // VALUE_NUMBER_INT is returned when a
        // numeric token other that is not an
        // integer is encountered: that is, a
        // number that does have floating point
        // or exponent marker in it, in addition
        // to one or more digits.
        return jp.getDoubleValue();
      case VALUE_NUMBER_INT: // VALUE_NUMBER_INT is returned when an
        // integer numeric token is encountered in
        // value context: that is, a number that
        // does not have floating point or exponent
        // marker in it (consists only of an
        // optional sign, followed by one or more
        // digits)
        return jp.getLongValue();
      case VALUE_STRING: // VALUE_STRING is returned when a String token
        // is encountered in value context (array
        // element, field value, or root-level
        // stand-alone value)
        return jp.getText();
      case START_OBJECT:
        check(JsonToken.FIELD_NAME); // FIELD_NAME is returned when a String token is
        // encountered as a field name (same lexical
        // value, different function)
        String field = jp.getCurrentName();
        if (field.charAt(0) == '*') {
          DataType type = DataType.fromString(field.substring(1));
          if (type != null) {
            check(JsonToken.VALUE_STRING);
            String data = jp.getText();
            check(JsonToken.END_OBJECT);
            return TransportHelper.loadData(type, data);
          } else
            throw new Error("Unkonwn type: " + field);
        }

      default:
        throw new Error("JSON Parser Error");
      }
    } catch (JsonParseException e) {
      throw new Error("JSON Parser Error");
    } catch (IOException e) {
      throw new Error("JSON Parser Error");
    }
  }

  class ListReader implements Iterable<ForestReader> {
    JsonParser jp;
    JSONReader reader;
    boolean wasInTable;

    public ListReader(JsonParser jp, JSONReader reader) {
      super();
      this.jp = jp;
      this.reader = reader;
      this.wasInTable = reader.inTable;
      reader.inTable = true;
    }

    @Override
    public Iterator<ForestReader> iterator() {
      return new ReadIterator(jp, reader);
    }

    class ReadIterator implements Iterator<ForestReader> {
      JsonParser jp;
      private boolean hasNext;
      JSONReader reader;
      boolean peeked;

      public ReadIterator(JsonParser jp, JSONReader reader) {
        super();
        this.jp = jp;
        this.reader = reader;
      }

      private void peek() {
        peeked = true;
        while (true)
          try {
            switch (jp.nextToken()) {
            case END_OBJECT:
              break; // continue
            case START_OBJECT:
              hasNext = true;
              return;
            case END_ARRAY:
              reader.inTable = wasInTable;
              hasNext = false;
              return;
            default:
              throw new Error("JSON Reader error");
            }
          } catch (JsonParseException e) {
            throw new Error("JSON Reader error");
          } catch (IOException e) {
            throw new Error("JSON Reader error");
          }
      }

      @Override
      public boolean hasNext() {
        if (!peeked)
          peek();
        return hasNext;
      }

      @Override
      public ForestReader next() {
        peeked = false;
        return reader;
      }

      @Override
      public void remove() {
        throw new Error("CAN'T REMOVE from JSON Reader");
      }
    }
  }

  @Override
  public Iterable<ForestReader> getTable(String request) {
    checkFieldName(request);
    check(JsonToken.START_ARRAY);
    return getTable();
  }

  private Iterable<ForestReader> getTable() {
    return new ListReader(jp, this);
  }

  @Override
  public void complete() {
    if (!inTable) {
      try {
        jp.close();
      } catch (IOException e) {
        throw new Error("JSON Reader error");
      }
    }
  }

  @Override
  public void copyTo(ForestWriter out) {
    while (nextToken() != JsonToken.END_OBJECT) {
      String field;
      try {
        mustEqual(JsonToken.FIELD_NAME, jp.getCurrentToken());
        field = jp.getCurrentName();
        jp.nextToken();
      } catch (JsonParseException e) {
        throw new Error("JSON Parser Error");
      } catch (IOException e) {
        throw new Error("JSON Parser Error");
      }
      if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
        ForestListWriter tableOut = out.newTable(field);
        for (ForestReader in : getTable()) {
          in.copyTo(tableOut.newIteration());
        }
        tableOut.complete();
      } else {
        out.put(field, get());
      }
    }
    out.complete();
  }
}
