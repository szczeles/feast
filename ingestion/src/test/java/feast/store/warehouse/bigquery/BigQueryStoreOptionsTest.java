/*
 * Copyright 2018 The Feast Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package feast.store.warehouse.bigquery;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import feast.options.OptionsParser;

public class BigQueryStoreOptionsTest {

  @Test
  public void testParse() {
    BigQueryStoreOptions options =
        OptionsParser.parse(
            ImmutableMap.<String, String>builder()
                .put("projectId", "project1")
                .put("datasetId", "dataset1")
                .put("tempLocation", "/tmp/foobar")
                .build(),
            BigQueryStoreOptions.class);

    Assert.assertEquals("project1", options.projectId);
    Assert.assertEquals("dataset1", options.datasetId);
    Assert.assertEquals("/tmp/foobar", options.tempLocation);
  }

  @Test
  public void testParseNoTempLocation() {
    BigQueryStoreOptions options =
        OptionsParser.parse(
            ImmutableMap.<String, String>builder()
                .put("projectId", "project1")
                .put("datasetId", "dataset1")
                .build(),
            BigQueryStoreOptions.class);

    Assert.assertEquals("project1", options.projectId);
    Assert.assertEquals("dataset1", options.datasetId);
    Assert.assertNull(options.tempLocation);
  }
}
