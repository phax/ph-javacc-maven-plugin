package org.codehaus.mojo.javacc;

import javax.annotation.Nullable;

import org.slf4j.LoggerFactory;

import com.helger.base.id.IHasID;
import com.helger.security.messagedigest.EMessageDigestAlgorithm;

/**
 * Special implementation of <code>ForkedJvm</code> that adds some default class
 * path entries.
 */
class ForkedJvmPGCC extends ForkedJvm
{
  public ForkedJvmPGCC ()
  {
    addClassPathEntry (IHasID.class);
    addClassPathEntry (EMessageDigestAlgorithm.class);
    addClassPathEntry (LoggerFactory.class);
    addClassPathEntry (Nullable.class);
  }
}
