package batch.sql.results;

import batch.sql.syntax.SQLQuery;

public class QueryResults {
  public final ResultSetLike results;
  public final SQLQuery query;
  public final Iterable<QueryResults> subs;

  public QueryResults(ResultSetLike rsl, SQLQuery q, Iterable<QueryResults> subs) {
    this.results = rsl;
    this.query = q;
    this.subs = subs;
  }
}
