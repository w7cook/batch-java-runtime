package batch.util;

public interface ForestWriter {
  void put(String name, Object value);
  ForestListWriter newTable(String variable);
  void complete();
}