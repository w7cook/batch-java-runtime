package batch.sql.results;

public class NullResultSet extends ResultSetLike {
  // Imitate one result to make code usage smooth
  private boolean once = true;

  @Override
  protected boolean _next() {
    if (once) {
      once = false;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Object getObject(String s) {
    throw new Error("Should not access null ResultSet");
  }

  @Override
  public Object getFirst() {
    return getObject(null);
  }
}
