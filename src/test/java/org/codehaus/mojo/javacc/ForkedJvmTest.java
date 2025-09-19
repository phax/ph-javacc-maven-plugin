package org.codehaus.mojo.javacc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.codehaus.plexus.util.cli.CommandLineUtils.StringStreamConsumer;
import org.junit.Test;

/**
 * Tests <code>ForkedJvm</code>.
 *
 * @author Benjamin Bentmann
 */
public class ForkedJvmTest
{
  @Test
  public void testToStringNullSafe () throws Exception
  {
    final ForkedJvm jvm = new ForkedJvm ();
    final String string = jvm.toString ();
    assertNotNull (string);
    assertTrue (string.indexOf ("null") < 0);
  }

  @Test
  public void testSettersNullSafe () throws Exception
  {
    final ForkedJvm jvm = new ForkedJvm ();
    jvm.addArgument ((File) null);
    jvm.addArgument ((String) null);
    jvm.addArguments (null);
    jvm.addArguments (new String [] { null });
    jvm.addClassPathEntry ((Class <?>) null);
    jvm.addClassPathEntry ((File) null);
    jvm.addClassPathEntry ((String) null);
    jvm.setMainClass ((Class <?>) null);
    jvm.setMainClass ((String) null);
    jvm.setWorkingDirectory (null);
    jvm.setSystemOut (null);
    jvm.setSystemErr (null);
  }

  @Test
  public void testSetMainClass () throws Exception
  {
    final ForkedJvm jvm1 = new ForkedJvm ();
    jvm1.setMainClass (MainStub.class);
    final String cmd1 = jvm1.toString ();
    assertTrue (cmd1.indexOf (MainStub.class.getName ()) >= 0);

    final ForkedJvm jvm2 = new ForkedJvm ();
    jvm2.setMainClass (MainStub.class.getName ());
    final String cmd2 = jvm2.toString ();
    assertTrue (cmd2.indexOf (MainStub.class.getName ()) >= 0);

    assertEquals (cmd1, cmd2);
  }

  @Test
  public void testFork () throws Exception
  {
    final File workDir = new File (System.getProperty ("user.home")).getCanonicalFile ();
    final File file = new File ("test").getAbsoluteFile ();
    final String nonce = Integer.toString (hashCode ());

    final StringStreamConsumer stdout = new StringStreamConsumer ();
    final StringStreamConsumer stderr = new StringStreamConsumer ();

    final ForkedJvm jvm = new ForkedJvm ();
    jvm.setWorkingDirectory (workDir);
    jvm.setSystemOut (stdout);
    jvm.setSystemErr (stderr);
    jvm.setMainClass (MainStub.class);
    jvm.addArgument (nonce);
    jvm.addArguments (new String [] { "arg1", "arg2" });
    jvm.addArgument (file);
    System.out.println ("Forking: " + jvm);
    final int exitcode = jvm.run ();
    final String out = stdout.getOutput ();
    final String err = stderr.getOutput ();
    final String [] args = out.split ("(\r\n)|(\r)|(\n)");

    assertEquals (27, exitcode);

    // Avoid getting "Picked up _JAVA_OPTIONS: -Xmx2048m -Xms512m"
    if (false)
      assertEquals (workDir, new File (err.trim ()));

    assertEquals (4, args.length);
    assertEquals (nonce, args[0]);
    assertEquals ("arg1", args[1]);
    assertEquals ("arg2", args[2]);
    assertEquals (file, new File (args[3]));
  }
}
