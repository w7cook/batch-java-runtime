package batch.sql.results;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResultSetStored extends ResultSetLike {
  private final ArrayList<String> columns;
  private final Iterator<Map<String,Object>> iter;
  private Map<String,Object> curr;

  public ResultSetStored(final ResultSet results) throws SQLException {
    try {
      columns = new ArrayList<String>(){{
        ResultSetMetaData md = results.getMetaData();
        int ncolumns = md.getColumnCount();
        for (int x=1; x<=ncolumns; x++) {
          add(md.getColumnLabel(x));
        }
      }};
      iter = new ArrayList<Map<String,Object>>(results.getFetchSize()){{
        while(results.next()) {
          add(new HashMap<String,Object>() {{
            int i = 0;
            for (String column : columns) {
              i++;
              // Getting the first object by column name crashes in some cases
              put(column, results.getObject(i));
            }
          }});
        }
      }}.iterator();
    } finally {
      results.close();
    }
  }

  @Override
  protected boolean _next() {
    if (iter.hasNext()) {
      curr = iter.next();
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Object getObject(String s) throws SQLException {
    if (curr.containsKey(s)) {
      return curr.get(s);
    } else {
      throw new SQLException("ResultSet does not have column: "+ s);
    }
  }

  @Override
  public Object getFirst() throws SQLException {
    return getObject(columns.get(0));
  }
}
