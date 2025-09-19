package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests <code>JavaCC</code> facade.
 *
 * @author Benjamin Bentmann
 */
public class JavaCCTest
{

  @Test
  public void testToStringNullSafe () throws Exception
  {
    final JavaCC tool = new JavaCC ();
    final String string = tool.toString ();
    assertNotNull (string);
    assertTrue (string.indexOf ("null") < 0);
  }

  @Test
  public void testSettersNullSafe () throws Exception
  {
    final JavaCC tool = new JavaCC ();
    tool.setInputFile (null);
    tool.setOutputDirectory (null);
    tool.setJdkVersion (null);
    tool.setBuildParser (null);
    tool.setBuildTokenManager (null);
    tool.setCacheTokens (null);
    tool.setChoiceAmbiguityCheck (null);
    tool.setCommonTokenAction (null);
    tool.setDebugLookAhead (null);
    tool.setDebugParser (null);
    tool.setDebugTokenManager (null);
    tool.setErrorReporting (null);
    tool.setForceLaCheck (null);
    tool.setIgnoreCase (null);
    tool.setJavaUnicodeEscape (null);
    tool.setKeepLineColumn (null);
    tool.setLookAhead (null);
    tool.setOtherAmbiguityCheck (null);
    tool.setSanityCheck (null);
    tool.setTokenManagerUsesParser (null);
    tool.setUnicodeInput (null);
    tool.setUserCharStream (null);
    tool.setUserTokenManager (null);
    tool.setLog (null);
  }

}
