package eval;

import java.io.IOException;

public abstract class BasicInterface {

  public abstract java.io.File getDir();

  public abstract int foo(int x);

	public abstract BasicInterface bar(int x);

	public abstract byte[] getImage(String name) throws IOException;

}