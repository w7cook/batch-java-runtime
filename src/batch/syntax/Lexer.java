package batch.syntax;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer implements Iterator<Lexer.Token>, Iterable<Lexer.Token> {
  private static int numToken = 1;

  // based on a tutorial by Gio Carlo Cielo Borje
  public static enum TokenType {
    // Token types cannot have underscores
    // EOF pattern MUST BE FIRST!
    EOF("[ \\t\\f\\r\\n]|/\\*(?:[^*]*(?:\\*[^/]|))*\\*/|//[^\\n\\r]*"),

    SYMBOL("([a-zA-Z][a-zA-Z0-9_]*|\\<=|\\>=|==|\\&\\&|\\|\\||[*+\\-%=<>!(){},;.])"),

    NUMBER("(-?[0-9]+(?:\\.[0-9]*)?(?:[eE][+-]?[0-9]+)?)"),

    STRING("\"((?:[^\\\\\"]|\\\\.|\\\\u[0-9a-fA-F]{4})*)\"");

    public final String pattern;
    public final int index;

    private TokenType(String pattern) {
      this.pattern = pattern;
      this.index = numToken++;
    }
  }

  public static class Token {
    public TokenType type;
    public String data;

    public Token(TokenType type, String data) {
      this.type = type;
      this.data = data;
    }

    @Override
    public String toString() {
      return String.format("%s %s", type.name(), data);
    }
  }

  String input;
  int position;
  int len;
  Matcher matcher;
  Token next;

  public Lexer(String input) {
    // The tokens to return
    this.input = input;
    len = input.length();

    // Lexer logic begins here
    StringBuffer tokenPatternsBuffer = new StringBuffer();
    for (TokenType tokenType : TokenType.values()) {
      if (tokenType == TokenType.EOF)
        tokenPatternsBuffer.append(String.format("(?:%s)*(?:($)", tokenType.pattern));
      else {
        tokenPatternsBuffer.append(String.format("|%s", tokenType.pattern));
      }
    }
    tokenPatternsBuffer.append(")");
    Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer));

    // Begin matching tokens
    matcher = tokenPatterns.matcher(input);
    next(); // get the first token
  }

  public Token next() {
    Token current = next;
    if (!matcher.lookingAt())
      throw new Error("Unknown token " + input.substring(position, Math.min(len, position+5)) + "... after "
          + position);
    for (TokenType t : TokenType.values()) {
      if (matcher.group(t.index) != null) {
        next = new Token(t, matcher.group(t.index));
        break;
      }
    }
    position = matcher.end();
    matcher.region(position, len);
    return current;
  }

  @Override
  public boolean hasNext() {
    return next.type != TokenType.EOF;
  }

  @Override
  public void remove() {
    throw new Error("Can't remove tokens");
  }

  @Override
  public Iterator<Token> iterator() {
    return this;
  }

  public static void test(String input) {
    System.out.println(input);
    Lexer lex = new Lexer(input);
    for (Token token : lex)
      System.out.println(token);
    System.out.println("---------");
  }

  public static void main(String[] args) {
    test("for   (i=3.4; i <= 0.1e10; i=i+1){    //line comment\rforbar.foo(i,2);/*ign/o*re!*/x=\"this \\u2334 \\\"is a tes\"}");
    test("this has $ a bad token");
  }
}