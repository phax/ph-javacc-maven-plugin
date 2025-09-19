package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * Tests <code>JTB</code> facade.
 * 
 * @author Benjamin Bentmann
 */
public class JTBTest
{
  @Test
  public void testToStringNullSafe () throws Exception
  {
    final JTB tool = new JTB ();
    final String string = tool.toString ();
    assertNotNull (string);
    assertTrue (string.indexOf ("null") < 0);
  }

  @Test
  public void testSettersNullSafe () throws Exception
  {
    final JTB tool = new JTB ();
    tool.setInputFile (null);
    tool.setOutputDirectory (null);
    tool.setNodeDirectory (null);
    tool.setVisitorDirectory (null);
    tool.setDescriptiveFieldNames (null);
    tool.setJavadocFriendlyComments (null);
    tool.setNodePackageName (null);
    tool.setNodeParentClass (null);
    tool.setPackageName (null);
    tool.setParentPointers (null);
    tool.setPrinter (null);
    tool.setScheme (null);
    tool.setSpecialTokens (null);
    tool.setSupressErrorChecking (null);
    tool.setVisitorPackageName (null);
    tool.setLog (null);
  }

  @Test
  public void testGetOutputFile () throws Exception
  {
    final File input = new File ("Test.jtb").getAbsoluteFile ();
    final File outdir = new File ("dir").getAbsoluteFile ();

    final JTB tool = new JTB ();
    tool.setInputFile (input);
    tool.setOutputDirectory (outdir);
    final File output = tool.getOutputFile ();

    assertEquals (new File (outdir, "Test.jj"), output);
  }

}
