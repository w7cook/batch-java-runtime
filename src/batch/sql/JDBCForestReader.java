package batch.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import batch.sql.results.NullResultSet;
import batch.sql.results.QueryResults;
import batch.sql.results.ResultLevelStack;
import batch.sql.results.ResultLevelStack.ResultLevel;
import batch.sql.results.ResultSetLike;
import batch.sql.results.ResultSetStored;
import batch.sql.results.ResultSetStream;
import batch.sql.syntax.SQLQuery;
import batch.sql.syntax.SQLTranslation.SQLAction;
import static batch.sql.SQLForestItem.SQLForestItemType.*;
import batch.util.ForestListWriter;
import batch.util.ForestReader;
import batch.util.ForestReaderHelper;
import batch.util.ForestWriter;

/**
 * Assumes read once in order.
 * For out of order, use copyTo(new Forest())
 */
public class JDBCForestReader extends ForestReaderHelper implements Iterator<SQLForestItem>, Iterable<SQLForestItem> {

  final boolean usePrepared = true;
  final Connection conn;
  final Statement stmt;
  final DatabaseMetaData dbMeta;
  final ForestReader data;
  final Iterator<SQLQuery> remainingQueries;
  final ResultLevelStack levels = new ResultLevelStack();
  boolean inTable = false;

  // "jdbc:mysql://localhost/test?user=monty&password=greatsqldb"
  public JDBCForestReader(
        final SQLQuery rootQuery,
        ForestReader data,
        String url
      ) {
    // Setup connection
    try {
      conn = DriverManager.getConnection(url);
      batch.sql.syntax.SQLTable.tagNum = 1;
      if (!usePrepared) {
        stmt = conn.createStatement();
      } else {
        stmt = null;
      }
      dbMeta = conn.getMetaData();
      if (!dbMeta.getDatabaseProductName().equals("MySQL")) {
        System.err.println("WARNING: Streaming results not implemented for " + dbMeta.getDatabaseProductName());
      }
    } catch (SQLException e) {
      // avoid warnings about variables like conn not being initialized
      throw new Error(this.<String>handleError(e));
    }

    // Setup iteration values
    this.data = data;
    switch (rootQuery.getAction()) {
    case INSERT:
    case UPDATE:
    case DELETE:
    case SELECT:
      remainingQueries = new ArrayList<SQLQuery>() {{
        add(rootQuery);
      }}.iterator();
      break;
    default:
      remainingQueries = rootQuery.getSubqueries().iterator();
    }
  }

  private QueryResults startQueries(final SQLQuery q, ForestReader data) throws SQLException {
    return startQueries(q, data, true);
  }

  private QueryResults startQueries(
        final SQLQuery q,
        ForestReader data,
        boolean isLastOfParent
      ) throws SQLException {
    final ResultSet results;
    List<SQLQuery> subQueries = q.getSubqueries();
    boolean shouldStream = subQueries.isEmpty() && isLastOfParent;
    switch (q.getAction()) {
    case INSERT:
      results = executeUpdate(q, data, shouldStream, true);
      break;
    case UPDATE:
    case DELETE:
      // Update and Delete don't have results
      executeUpdate(q, data, shouldStream, false);
      shouldBe(subQueries.isEmpty());
      return null;
    case SELECT:
      results = executeQuery(q, data, shouldStream);
      break;
    default:
      results = null;
    }
    // Determine how to store results.
    final ResultSetLike rsl;
    if (results == null) {
      rsl = new NullResultSet();
    } else if (shouldStream) {
      // Keep last results streaming
      rsl = new ResultSetStream(results);
    } else {
      // Store results locally since we can't keep multiple result sets open
      rsl = new ResultSetStored(results);
    }
    // Execute sub queries
    Iterator<SQLQuery> subIt = subQueries.iterator();
    List<QueryResults> subs = new ArrayList<QueryResults>(subQueries.size());
    while(subIt.hasNext()) {
      SQLQuery sub = subIt.next();
      subs.add(startQueries(sub, data, isLastOfParent && !subIt.hasNext()));
    }
    rsl.next();
    return new QueryResults(rsl, q, subs);
  }

  private ResultSet executeQuery(
        SQLQuery q,
        ForestReader data,
        boolean shouldStream
      ) throws SQLException {
    ResultSet qr;
    if (!usePrepared) {
      setToStream(stmt, shouldStream);
      String sql = SQLBatch.getSQL(q, null, data);
      qr = stmt.executeQuery(sql);
    } else {
      List<Object> params = new ArrayList<Object>();
      String sql = SQLBatch.getSQL(q, params, data);
      PreparedStatement pstmt = conn.prepareStatement(sql);
      setToStream(pstmt, shouldStream);
      int i = 1;
      for (Object param : params)
        pstmt.setObject(i++, param);
      qr = pstmt.executeQuery();
    }
    return qr;
  }

  private ResultSet executeUpdate(SQLQuery q, ForestReader data, boolean shouldStream, boolean returnKeys)
      throws SQLException {
    int num;
    ResultSet result = null;
    int autoGeneratedKeys = returnKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;
    if (!usePrepared) {
      setToStream(stmt, shouldStream);
      String sql = SQLBatch.getSQL(q, null, data);
      num = stmt.executeUpdate(sql, autoGeneratedKeys);
      if (returnKeys) 
        result = stmt.getGeneratedKeys();
    } else {
      List<Object> params = new ArrayList<Object>();
      String sql = SQLBatch.getSQL(q, params, data);
      PreparedStatement pstmt = conn.prepareStatement(sql, autoGeneratedKeys);
      setToStream(pstmt, shouldStream);
      int i = 1;
      for (Object param : params)
        pstmt.setObject(i++, param);
      num = pstmt.executeUpdate();
      if (returnKeys) 
        result = pstmt.getGeneratedKeys();
    }
    System.out.println("Affected " + num + " rows");
    return result;
  }

  protected void setToStream(Statement stmt, boolean shouldStream) {
    try {
      String dbName = dbMeta.getDatabaseProductName();
      if (dbName.equals("MySQL")) {
        if (shouldStream) {
          stmt.setFetchSize(Integer.MIN_VALUE);
        } else {
          stmt.setFetchSize(0);
        }
      }
    } catch (SQLException e) {
      handleError(e);
    }
  }

  /**************************
   * Iterable interface
   *************************/

  public Iterator<SQLForestItem> iterator() {
    return this;
  }

  /**************************
   * Iterator interface
   *************************/

  private boolean peeked = false;
  @Override
  public boolean hasNext() {
    if (!peeked) {
      peeked = true;
      step();
    }
    return _next.type != END;
  }

  // Reuse to not create tons of objects
  @Override
  public SQLForestItem next() {
    if (!peeked) {
      step();
    } else {
      peeked = false;
    }
    if (_next.type == END) {
      throw new NoSuchElementException();
    }
    return _next;
  }

  private final SQLForestItem _next = new SQLForestItem();
  private boolean startedTable = false;
  private boolean startedIteration = false;
  private boolean endedIteration = false;
  private SQLForestItem step() {
    try {
      if (levels.isEmpty()) {
        if (!remainingQueries.hasNext()) {
          return _next.set(END, null, null);
        }
        QueryResults queryResults = startQueries(remainingQueries.next(), data);
        if (queryResults != null) {
          levels.push(queryResults, null);
        }
        return step();
      }
      QueryResults queryResults = levels.peek().queryResults;
      SQLQuery q = queryResults.query;
      ResultSetLike results = queryResults.results;
      Object currParent = levels.peek().currParent;
      boolean isPartOfTable = !q.isSingleRow();
      if (!startedTable && isPartOfTable) {
        startedTable = true;
        return _next.set(START_TABLE, q.getVar(), null);
      }
      if (currParent != null) {
        results.popOrphans();
      }
      if (!results.hasCurr()
          ||
          (currParent != null && !currParent.equals(results.getObject("parent")))) {
        levels.pop();
        if (isPartOfTable) {
          startedTable = false;
          return _next.set(END_TABLE, null, null);
        } else {
          return step();
        }
      }
      if (!startedIteration && isPartOfTable) {
        startedIteration = true;
        return _next.set(START_ITERATION, null, null);
      }
      
      ResultLevel level = levels.peek();
      if (!level.wroteElements) {
        if (q.getAction() == SQLAction.INSERT) {
          level.wroteElements = true;
          return _next.set(
            ELEMENT,
            q.insertResultName,
            results.getFirst()
          );
        } else {
          if (level.remainingProjections == null) {
            level.remainingProjections = queryResults.query.getProjections().iterator();
          }
          if (level.remainingProjections.hasNext()) {
            String name = level.remainingProjections.next().getLocation();
            return _next.set(
              ELEMENT,
              name,
              results.getObject(name)
            );
          } else {
            level.wroteElements = true;
          }
        }
      }

      if (level.remainingSubs == null) {
        level.remainingSubs = queryResults.subs.iterator();
      }
      if (level.remainingSubs.hasNext()) {
        Object subsParent = isPartOfTable ? results.getObject(q.getSubTag()) : null;
        QueryResults sub = level.remainingSubs.next();
        levels.push(
          sub,
          subsParent
        );
        return step();
      }
      
      if (!endedIteration && isPartOfTable) {
        endedIteration = true;
        return _next.set(END_ITERATION, null, null);
      }
      
      level.remainingSubs = null;
      level.remainingProjections = null;
      level.wroteElements = false;
      startedIteration = false;
      endedIteration = false;
      results.next();
      return step();
    } catch (SQLException e) {
      return handleError(e);
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  /**************************
   * ForestReader interface
   *************************/

  @Override
  public Object get(String variable) {
    SQLForestItem next = next();
    shouldBe(next.type == ELEMENT && next.name.equals(variable));
    return next.value;
  }

  @Override
  public Iterable<ForestReader> getTable(String variable) {
    {
      SQLForestItem first = next();
      shouldBe(first.type == START_TABLE && first.name.equals(variable));
    }
    final JDBCForestReader reader = this;
    shouldBe(reader.hasNext());
    final boolean wasInTable = reader.inTable;
    reader.inTable = true;
    return new Iterable<ForestReader>() {
      public Iterator<ForestReader> iterator() {
        return new Iterator<ForestReader>() {
          private boolean first = true;
          private boolean peeked = false;
          private void step() {
            if (!first) {
              reader.next();
              shouldBe(reader._next.type == END_ITERATION);
            }
            reader.next();
            shouldBe(reader._next.type != END);
            if (reader._next.type == END_TABLE) {
              reader.inTable = wasInTable;
            }
          }
          public boolean hasNext() {
            if (!peeked) {
              peeked = true;
              step();
            }
            return reader._next.type != END_TABLE;
          }
          public ForestReader next() {
            if (!peeked) {
              step();
            } else {
              peeked = false;
            }
            first = false;
            if (reader._next.type != START_ITERATION) {
              throw new NoSuchElementException();
            }
            return reader;
          }
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  @Override
  public void complete() {
    if (!inTable) {
      if(_next.type != END) {
        // Finish any empty-result queries
        step();
      }
      shouldBe(_next.type == END);
      cleanUp();
    }
  }

  private void cleanUp() {
    // it is a good idea to release
    // resources in a finally{} block
    // in reverse-order of their creation
    // if they are no-longer needed

    if (stmt != null) {
      try {
        stmt.close();
      } catch (SQLException sqlEx) {
      } // ignore
    }

    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException sqlEx) {
      } // ignore
    }
  }

  @Override
  public void copyTo(final ForestWriter out) {
    boolean nextIteration = false;
    Stack<ForestWriter> writers = new Stack<ForestWriter>() {{
      push(out);
    }};
    Stack<ForestListWriter> listWriters = new Stack<ForestListWriter>();

    for (SQLForestItem item : this) {
      // manage writers
      switch(item.type) {
      case ELEMENT:
      case START_TABLE:
          // be sure to start iterations
          if (nextIteration) {
            writers.push(listWriters.peek().newIteration());
            nextIteration = false;
          }
          break;
      case START_ITERATION:
          nextIteration = true;
          break;
      case END_ITERATION:
          if (!nextIteration) {
            // added element to iteration so pop writer
            writers.pop().complete();
          }
          break;
      }

      // manage listWriters
      switch (item.type) {
      case START_TABLE:
          listWriters.push(writers.peek().newTable(item.name));
          break;
      case END_TABLE:
          listWriters.pop().complete();
          break;
      }

      // write values
      switch (item.type) {
      case ELEMENT:
          writers.peek().put(item.name, item.value);
          break;
      }
    }
    out.complete();
    complete();
  }

  /**************************
   * Error handlers
   *************************/

  private <E> E handleError(SQLException ex) {
    cleanUp(); // clean up
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
    throw new Error("database exception", ex);
  }

  private void shouldBe(boolean assertion) {
    if (!assertion) {
      shouldNotOccur();
    }
  }

  private void shouldNotOccur() {
    cleanUp();
    throw new Error("Invalid usage of JDBCForestReader, should not occur in generated code");
  }
}
