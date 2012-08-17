package batch.syntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import batch.syntax.Lexer.TokenType;

public class Parser {
  Factory f;
  Lexer in;
  Symbol kind;
  Object data;

  private static int numSymbol;
  private static Map<String, Symbol> special = new HashMap<String, Symbol>();

  public static enum Symbol {
    // from lexer
    EOF(null), ID(null), NUMBER(null), STRING(null),
    // keywords
    VAR("var"), FOR("for"), IN("in"), FUNCTION("function"), IF("if"), ELSE(
        "else"), DATE("date"), TRUE("true"), FALSE("false"), OUTPUT("OUTPUT"), OR(
        "||"), AND("&&"), EQ("=="), NE("!="), LE("<="), LT("<"), GT(">"), GE(
        ">="), SEMI(";"), COMMA(","), ASSIGN("="), LCURLY("{"), RCURLY("}"), LPAREN(
        "("), RPAREN(")"), ADD("+"), SUB("-"), MUL("*"), DIV("/"), DOT("."), NOT(
        "!");

    public final String text;
    public final int index;

    private Symbol(String text) {
      this.text = text;
      this.index = numSymbol++;
      special.put(text, this);
    }
  }

  static public Expression parse(String script) {
    Parser p = new Parser(script);
    return p.main();
  }

  public Parser(String script) {
    Symbol.values(); // required to create the enum!
    f = new batch.syntax.Factory();
    in = new Lexer(script);
    next();
  }

  void next() {
    Lexer.Token current = in.next();
    switch (current.type) {
    case EOF:
      kind = Symbol.EOF;
      data = null;
      break;
    case STRING:
      kind = Symbol.STRING;
      data = current.data;
      break;
    case NUMBER:
      kind = Symbol.NUMBER;
      String str = (String) current.data;
      if (str.indexOf('.') != -1 || str.indexOf('e') != -1)
        data = new Float(str);
      else
        data = new Integer(str);
      break;
    case SYMBOL:
      kind = special.get(current.data);
      if (kind == null) {
        kind = Symbol.ID;
        data = current.data;
      }
    }
  }

  boolean match(Symbol c) {
    if (kind == c) {
      next();
      return true;
    }
    return false;
  }

  String ID() {
    String val = null;
    if (kind == Symbol.ID)
      val = (String) data;
    else
      throw new Error("Expected identifier");
    next();
    return val;
  }

  private String String() {
    String val = null;
    if (kind == Symbol.STRING)
      val = (String) data;
    else
      throw new Error("Expected string");
    next();
    return val;
  }

  private void require(Symbol c) {
    if (!match(c))
      throw new Error("Expected " + c);
  }

  /*
   * 
        if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
            System.out.println(tokenizer.sval);
        } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            System.out.println(tokenizer.nval);
        } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {
            System.out.println();
        }

   */
  Expression main() {
    Expression value = statements();
    if (kind != Symbol.EOF)
      throw new Error("Expected EOF");
    return value;
  }

  Expression statements() {
    Expression value = statement();
    if (match(Symbol.SEMI)) {
      Expression es = statements();
      if (es != null)
        value = f.Prim(batch.Op.SEQ, value, es);
    }
    return value;
  }

  Expression block() {
    require(Symbol.LCURLY);
    Expression e = statements();
    require(Symbol.RCURLY);
    return e;
  }

  Expression statement() {
    if (match(Symbol.FOR)) {
      match(Symbol.LPAREN);
      String v = ID();
      match(Symbol.IN);
      Expression e = expr();
      match(Symbol.RPAREN);
      Expression b = block();
      return f.Loop(v, e, b);
    } else if (match(Symbol.VAR)) {
      String v = ID();
      require(Symbol.ASSIGN);
      Expression e = expr();
      require(Symbol.SEMI);
      Expression b = statements();
      return f.Let(v, e, b);
    } else
      return expr();
  }

  Expression expr() {
    Expression a = and();
    if (match(Symbol.OR)) {
      Expression b = expr();
      return f.Prim(batch.Op.OR, a, b);
    }
    return a;
  }

  Expression and() {
    Expression a = comp();
    if (match(Symbol.AND)) {
      Expression b = and();
      return f.Prim(batch.Op.AND, a, b);
    }
    return a;
  }

  Expression comp() {
    Expression a = term();
    batch.Op op = compop();
    if (op != null) {
      Expression b = comp();
      return f.Prim(op, a, b);
    }
    return a;
  }

  batch.Op compop() {
    if (match(Symbol.EQ))
      return batch.Op.EQ;
    if (match(Symbol.NE))
      return batch.Op.NE;
    if (match(Symbol.LE))
      return batch.Op.LE;
    if (match(Symbol.LT))
      return batch.Op.LT;
    if (match(Symbol.GT))
      return batch.Op.GT;
    if (match(Symbol.GE))
      return batch.Op.GE;
    return null;
  }

  Expression term() {
    Expression a = factor();
    batch.Op op = addop();
    if (op != null) {
      Expression b = term();
      return f.Prim(op, a, b);
    }
    return a;
  }

  batch.Op addop() {
    if (match(Symbol.ADD))
      return batch.Op.ADD;
    if (match(Symbol.SUB))
      return batch.Op.SUB;
    return null;
  }

  Expression factor() {
    Expression a = base();
    batch.Op op = mulop();
    if (op != null) {
      Expression b = factor();
      return f.Prim(op, a, b);
    }
    return a;
  }

  batch.Op mulop() {
    if (match(Symbol.MUL))
      return batch.Op.MUL;
    if (match(Symbol.DIV))
      return batch.Op.DIV;
    return null;
  }

  Expression base() {
    Expression e;
    switch (kind) {
    case NUMBER:
      Object d = data;
      next();
      return f.Data(d);
    case NOT: {
      next();
      e = base();
      return f.Prim(batch.Op.NOT, e);
    }
    case LPAREN: {
      next();
      e = expr();
      match(Symbol.RPAREN);
      return e;
    }
    case STRING: {
      String str = (String) data;
      str = str.replace("\\\"", "\"");
      str = str.replace("\\\\", "\\");
      // TODO: handle unicode characters!???
      next();
      return f.Data(str);
    }
    case FUNCTION: {
      next();
      match(Symbol.LPAREN);
      String v = ID();
      match(Symbol.RPAREN);
      e = block();
      return f.Fun(v, e);
    }
    case IF: {
      next();
      match(Symbol.LPAREN);
      Expression a = expr();
      match(Symbol.RPAREN);
      Expression b = block();
      if (match(Symbol.ELSE)) {
        Expression c = block();
        return f.If(a, b, c);
      }
      return f.If(a, b, f.Skip());
    }
    case DATE: {
      next();
      match(Symbol.LPAREN);
      String str = String();
      match(Symbol.RPAREN);
      return f.Data(java.sql.Date.valueOf(str));
    }
    case TRUE:
      next();
      return f.Data(true);
    case FALSE:
      next();
      return f.Data(false);
    default: {
      Expression a = prim();
      if (match(Symbol.ASSIGN)) {
        Expression b = expr();
        return f.Assign(a, b);
      }
      return a;
    }
    }
  }

  Expression prim() {
    if (match(Symbol.OUTPUT)) {
      match(Symbol.LPAREN);
      String str = String();
      match(Symbol.COMMA);
      Expression e = expr();
      match(Symbol.RPAREN);
      return f.Out(str, e);
    } else {
      Expression value = f.Var(ID());
      return access(value);
    }
  }

  // Prop and Call
  Expression access(Expression value) {
    String field = null;
    if (match(Symbol.DOT)) {
      field = ID();
      if (match(Symbol.LPAREN)) {
        List<Expression> args = new ArrayList<Expression>();
        if (!match(Symbol.RPAREN)) {
          Expression e = expr();
          args.add(e);
          while (match(Symbol.COMMA)) {
            e = expr();
            args.add(e);
          }
          match(Symbol.RPAREN);
          value = f.Call(value, field, args);
        }
      } else
        value = f.Prop(value, field);
    }
    return field == null ? value : access(value);
  }

}