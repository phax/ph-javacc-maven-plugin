package org.codehaus.mojo.javacc;

/**
 * Supports {@link ForkedJvmTest}.
 * 
 * @author Benjamin Bentmann
 */
public class MainStub
{

  public static void main (final String [] args)
  {
    for (final String arg : args)
    {
      System.out.println (arg);
    }

    System.err.println (System.getProperty ("user.dir"));

    System.exit (27);
  }

}
