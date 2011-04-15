/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
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
package org.onebusaway.csv_entities;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.onebusaway.csv_entities.CSVLibrary;

public class CSVLibraryTest {

  @Test
  public void testParse() {

    List<String> tokens = CSVLibrary.parse("a,b,c");
    assertEquals(3, tokens.size());
    assertEquals("a", tokens.get(0));
    assertEquals("b", tokens.get(1));
    assertEquals("c", tokens.get(2));

    tokens = CSVLibrary.parse("a,\"b b\",\"c,c\"");
    assertEquals(3, tokens.size());
    assertEquals("a", tokens.get(0));
    assertEquals("b b", tokens.get(1));
    assertEquals("c,c", tokens.get(2));

    tokens = CSVLibrary.parse("b\"b");
    assertEquals(1, tokens.size());
    assertEquals("b\"b", tokens.get(0));
  }

  @Test
  public void testParseWikipedia() {

    List<String> tokens = CSVLibrary.parse("1997,Ford,E350");
    assertEquals(3, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("Ford", tokens.get(1));
    assertEquals("E350", tokens.get(2));

    tokens = CSVLibrary.parse("1997,   Ford   , E350");
    assertEquals(3, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("   Ford   ", tokens.get(1));
    assertEquals(" E350", tokens.get(2));

    tokens = CSVLibrary.parse("1997,Ford,E350,\"Super, luxurious truck\"");
    assertEquals(4, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("Ford", tokens.get(1));
    assertEquals("E350", tokens.get(2));
    assertEquals("Super, luxurious truck", tokens.get(3));

    tokens = CSVLibrary.parse("1997,Ford,E350,\"Super \"\"luxurious\"\" truck\"");
    assertEquals(4, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("Ford", tokens.get(1));
    assertEquals("E350", tokens.get(2));
    assertEquals("Super \"luxurious\" truck", tokens.get(3));

    tokens = CSVLibrary.parse("1997,Ford,E350,\"  Super luxurious truck    \"");
    assertEquals(4, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("Ford", tokens.get(1));
    assertEquals("E350", tokens.get(2));
    assertEquals("  Super luxurious truck    ", tokens.get(3));

    tokens = CSVLibrary.parse("\"1997\",\"Ford\",\"E350\"");
    assertEquals(3, tokens.size());
    assertEquals("1997", tokens.get(0));
    assertEquals("Ford", tokens.get(1));
    assertEquals("E350", tokens.get(2));
  }
}
