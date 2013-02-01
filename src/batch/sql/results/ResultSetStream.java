package batch.sql.results;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetStream extends ResultSetLike {
  private final ResultSet results;

  public ResultSetStream(ResultSet results) {
    this.results = results;
  }

  @Override
  protected boolean _next() throws SQLException {
    try {
      return results.next();
    } catch(SQLException e) {
      results.close();
      throw e;
    }
  }

  @Override
  public Object getObject(String s) throws SQLException {
    try {
      return results.getObject(s);
    } catch(SQLException e) {
      results.close();
      throw e;
    }
  }

  @Override
  public Object getFirst() throws SQLException {
    try {
      return results.getObject(1);
    } catch(SQLException e) {
      results.close();
      throw e;
    }
  }
}
