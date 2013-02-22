package batch.sql.results;

import java.sql.SQLException;

public abstract class ResultSetLike {
  private boolean currExists = false;
  protected abstract boolean _next() throws SQLException;
  public final boolean next() throws SQLException {
    return (currExists = _next());
  }
  public boolean hasCurr() {
    return currExists;
  }
  public abstract Object getObject(String s) throws SQLException;
  public abstract Object getFirst() throws SQLException;
  public void popOrphans() throws SQLException {
    if (hasCurr()) {
      while (getObject("parent") == null && next()) {
        // Called <next> in condition
      }
    }
  }
}
