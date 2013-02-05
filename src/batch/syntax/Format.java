package batch.syntax;

import java.util.List;

import batch.Op;
import batch.util.BatchFactoryHelper;

public class Format extends BatchFactoryHelper<String> {

  @Override
  public String Var(String name) {
    return name;
  }

  @Override
  public String Data(Object value) {
    if (value == null) {
      return "null";
    } else if (value instanceof String) {
      String str = (String) value;
      str = str.replace("\\", "\\\\");
      str = str.replace("\"", "\\\"");
      return "\"" + str + "\"";
    } else if (value instanceof java.sql.Date
        || value instanceof java.util.Date) {
      return "date(\"" + value.toString() + "\")";
    } else if (value instanceof Boolean || value instanceof Number) {
      return value.toString();
    } else
      return "{" + value.toString() + "}";
  }

  @Override
  public String Fun(String var, String body) {
    return "{function(" + var + ") " + body + "}";
  }

  @Override
  public String Prim(Op op, List<String> args) {
    if (args.size() == 0) {
      return "skip";
    } else if (args.size() == 1 && !op.unary()) {
      return args.get(0);
    } else {
      String x = null;
      int n = 0;
      for (int i = 0; i < args.size(); i++) {
        String s = args.get(i);
        if (s == null)
          continue;
        if (op == Op.SEQ && s.startsWith("{")) {
          // strip { and } from s
          s = s.substring(1, s.length() - 1);
        }
        n++;
        if (n == 1)
          x = s;
        else {
          x += ' ';
          x += op.getOpSymbol();
          x += ' ';
          x += s;
        }
      }
      if (op == Op.SEQ) {
        x = "{" + x + "}";
      } else {
        if (n == 1 && op.unary())
          x = "(" + op.getOpSymbol() + x + ")";
        else if (n > 1)
          x = "(" + x + ")";
      }
      return x;
    }
  }

  @Override
  public String Prop(String base, String field) {
    return base + "." + field;
  }

  @Override
  public String Assign(String target, String source) {
    return target + "=" + source;
  }

  @Override
  public String Let(String var, String expression, String body) {
    if (body.startsWith("{")) {
      // strip { and } from body
      body = body.substring(1, body.length() - 1);
    }
    return "{var " + var + "=" + expression + "; " + body + "}";
  }

  @Override
  public String If(String condition, String thenExp, String elseExp) {
    if (elseExp.equals("skip"))
      return "{if (" + condition + ") " + thenExp + "}";
    else
      return "{if (" + condition + ") " + thenExp + " else " + elseExp + "}";
  }

  @Override
  public String Loop(String var, String collection, String body) {
    return "{for (" + var + " in " + collection + ") " + body + "}";
  }

  @Override
  public String Call(String target, String method, List<String> args) {
    String x = target + '.' + method + '(';
    int i = 0;
    for (String e : args) {
      if (i++ > 0)
        x += ", ";
      x += e;
    }
    return x + ")";
  }

  @Override
  public String In(String location) {
    return "INPUT(\"" + location + "\")";
  }

  @Override
  public String Out(String location, String expression) {
    return "OUTPUT(\"" + location + "\", " + expression + ")";
  }

  public static void checkData(Object value) {
    if (value != null
        && !(value instanceof String || value instanceof java.sql.Date
            || value instanceof java.util.Date || value instanceof Boolean || value instanceof Number))
      throw new Error("Invalid Data");
  }
}
