/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.backward_codecs.store;

import java.io.IOException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.IndexOutput;
import org.apache.lucene.util.LuceneTestCase.Nightly;

@Nightly // N-2 formats are only tested on nightly runs
public class TestEndiannessReverserIndexInput extends EndiannessReverserTestCase {

  @Override
  protected IndexInput getEndiannessReverserInput(Directory dir, String name, IOContext context)
      throws IOException {
    return new EndiannessReverserIndexInput(dir.openInput(name, context));
  }

  @Override
  protected IndexOutput getEndiannessReverserOutput(Directory dir, String name, IOContext context)
      throws IOException {
    return new EndiannessReverserIndexOutput(dir.createOutput(name, context));
  }

  @Override
  protected boolean supportSlice() {
    return true;
  }
}
