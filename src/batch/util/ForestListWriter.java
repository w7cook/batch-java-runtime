package batch.util;

public interface ForestListWriter {

  /**
   * Creates a new Forest object and adds it to the iteration list.
   * 
   * @return a new Forest object.
   */
  public abstract ForestWriter newIteration();
  void complete();

}