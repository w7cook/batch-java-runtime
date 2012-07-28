package batch.util;


import batch.sql.Group;
import batch.sql.Many;

public class MemGroup<S,T> extends Group<S,T> {
  
  MemGroup(S key, Many<T> values) {
    this.Key = key;
    this.Items = values;
  }
  
  MemGroup(S key) {
    this(key, new MemSet<T>());
  }
  
  public void add(T value) {
    ((MemSet<T>)this.Items).add(value);
  }
  
}
