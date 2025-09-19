package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Test;

/**
 * Tests <code>GrammarInfo</code>.
 *
 * @author Benjamin Bentmann s
 */
public class GrammarInfoTest
{
  @Test (expected = IOException.class)
  public void testInvalidFile () throws Exception
  {
    new GrammarInfo (new File ("").getAbsoluteFile (), "bad");
  }

  @Test
  public void testGetGrammarFile () throws Exception
  {
    final File grammarFile = _getGrammar ("Parser1.jj");
    final GrammarInfo info = new GrammarInfo (grammarFile.getParentFile (), grammarFile.getName ());
    assertEquals (grammarFile, info.getGrammarFile ());
  }

  @Test
  public void testGetRelativeGrammarFile () throws Exception
  {
    final File grammarFile = _getGrammar ("Parser1.jj");
    final GrammarInfo info = new GrammarInfo (grammarFile.getParentFile (), grammarFile.getName ());
    assertEquals (grammarFile.getName (), info.getRelativeGrammarFile ());
  }

  @Test
  public void testGetPackageNameDeclaredPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser1.jj");
    assertEquals ("org.codehaus.mojo.javacc.test", info.getParserPackage ());
  }

  @Test
  public void testGetPackageNameDefaultPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser2.jj");
    assertEquals ("", info.getParserPackage ());
  }

  @Test
  public void testGetPackageDirectoryDeclaredPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser1.jj");
    assertEquals (new File ("org/codehaus/mojo/javacc/test").getPath (), info.getParserDirectory ());
  }

  @Test
  public void testGetPackageDirectoryDefaultPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser2.jj");
    assertEquals (new File ("").getPath (), info.getParserDirectory ());
  }

  @Test
  public void testGetParserName () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser1.jj");
    assertEquals ("BasicParser", info.getParserName ());
  }

  @Test
  public void testGetParserFileDeclaredPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser1.jj");
    assertEquals (new File ("org/codehaus/mojo/javacc/test/BasicParser.java").getPath (), info.getParserFile ());
  }

  @Test
  public void testGetParserFileDefaultPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser2.jj");
    assertEquals (new File ("SimpleParser.java").getPath (), info.getParserFile ());
  }

  @Test
  public void testResolvePackageNameDeclaredPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser1.jj");
    assertEquals ("org.codehaus.mojo.javacc.test.node", info.resolvePackageName ("*.node"));
    assertEquals ("org.codehaus.mojo.javacc.testnode", info.resolvePackageName ("*node"));
    assertEquals ("node", info.resolvePackageName ("node"));
  }

  @Test
  public void testResolvePackageNameDefaultPackage () throws Exception
  {
    final GrammarInfo info = _newGrammarInfo ("Parser2.jj");
    assertEquals ("node", info.resolvePackageName ("*.node"));
    assertEquals ("node", info.resolvePackageName ("*node"));
    assertEquals ("node", info.resolvePackageName ("node"));
  }

  private GrammarInfo _newGrammarInfo (final String resource) throws Exception
  {
    final File grammarFile = _getGrammar (resource);
    final File sourceDir = grammarFile.getParentFile ();
    return new GrammarInfo (sourceDir, grammarFile.getName ());
  }

  private File _getGrammar (final String resource) throws Exception
  {
    return new File (new URI (getClass ().getResource ('/' + resource).toString ()));
  }
}
