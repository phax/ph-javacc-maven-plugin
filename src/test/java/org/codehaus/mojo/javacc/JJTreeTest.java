package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * Tests <code>JJTree</code> facade.
 *
 * @author Benjamin Bentmann
 */
public class JJTreeTest
{
  @Test
  public void testToStringNullSafe () throws Exception
  {
    final JJTree tool = new JJTree ();
    final String string = tool.toString ();
    assertNotNull (string);
    assertTrue (string.indexOf ("null") < 0);
  }

  @Test
  public void testSettersNullSafe () throws Exception
  {
    final JJTree tool = new JJTree ();
    tool.setInputFile (null);
    tool.setOutputDirectory (null);
    tool.setJdkVersion (null);
    tool.setBuildNodeFiles (null);
    tool.setMulti (null);
    tool.setNodeDefaultVoid (null);
    tool.setNodeFactory (null);
    tool.setNodePackage (null);
    tool.setNodePrefix (null);
    tool.setNodeScopeHook (null);
    tool.setNodeUsesParser (null);
    tool.setVisitor (null);
    tool.setVisitorException (null);
    tool.setLog (null);
  }

  @Test
  public void testGetOutputFile () throws Exception
  {
    final File input = new File ("Test.jjt").getAbsoluteFile ();
    final File outdir = new File ("dir").getAbsoluteFile ();

    final JJTree tool = new JJTree ();
    tool.setInputFile (input);
    tool.setOutputDirectory (outdir);
    final File output = tool.getOutputFile ();

    assertEquals (new File (outdir, "Test.jj"), output);
  }

}
