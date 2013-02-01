package batch.sql;

public class SQLForestItem {
  public static enum SQLForestItemType {
    ELEMENT,
    START_TABLE,
    START_ITERATION,
    END_ITERATION,
    END_TABLE,
    END,
  }

  public SQLForestItemType type;
  public String name;
  public Object value;

  public SQLForestItem set(
        SQLForestItemType type, 
        String name,
        Object value
      ) {
    this.type = type;
    this.name = name;
    this.value = value;
    return this;
  }

  public String toString() {
    return type + "#" + name + ": " + value;
  }
}
