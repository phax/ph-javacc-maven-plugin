package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests <code>JJDoc</code> facade.
 * 
 * @author Benjamin Bentmann
 */
public class JJDocTest
{

  @Test
  public void testToStringNullSafe () throws Exception
  {
    final JJDoc tool = new JJDoc ();
    final String string = tool.toString ();
    assertNotNull (string);
    assertTrue (string.indexOf ("null") < 0);
  }

  @Test
  public void testSettersNullSafe () throws Exception
  {
    final JJDoc tool = new JJDoc ();
    tool.setInputFile (null);
    tool.setOutputFile (null);
    tool.setOneTable (null);
    tool.setText (null);
    tool.setLog (null);
  }

}
