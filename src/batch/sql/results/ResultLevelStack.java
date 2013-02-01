package batch.sql.results;

import java.util.ArrayList;
import java.util.Iterator;

import batch.sql.syntax.Output;

// Object reusing stack
public class ResultLevelStack {
  public static class ResultLevel {
    public QueryResults queryResults;
    // will only take elements that have this parent
    public Object currParent;
    public boolean wroteElements;
    public Iterator<Output> remainingProjections;
    public Iterator<QueryResults> remainingSubs;
  }

  private ArrayList<ResultLevel> levels;
  private int currIndex;
  
  public ResultLevelStack() {
    levels = new ArrayList<ResultLevel>();
    currIndex = -1;
  }

  public boolean isEmpty() {
    return currIndex == -1;
  }

  public ResultLevel peek() {
    return levels.get(currIndex);
  }

  public void pop() {
    currIndex--;
  }

  public void push(QueryResults queryResults, Object currParent) {
    currIndex++;
    if (levels.size() <= currIndex) {
      // previous object does not exist
      levels.add(new ResultLevel());
    }
    ResultLevel level = levels.get(currIndex);
    level.queryResults = queryResults;
    level.currParent = currParent;
    level.wroteElements = false;
    level.remainingProjections = null;
    level.remainingSubs = null;
  }
}
