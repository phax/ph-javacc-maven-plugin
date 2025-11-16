/*
 * Copyright 2001-2008 (C) The original author or authors.
 * Copyright 2008-2016 (C) The Codehaus (http://codehaus.org/)
 * Copyright (C) 2016-2025 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.mojo.javacc;

import org.jspecify.annotations.Nullable;
import org.slf4j.LoggerFactory;

import com.helger.base.id.IHasID;
import com.helger.security.messagedigest.EMessageDigestAlgorithm;

/**
 * Special implementation of <code>ForkedJvm</code> that adds some default class path entries.
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
