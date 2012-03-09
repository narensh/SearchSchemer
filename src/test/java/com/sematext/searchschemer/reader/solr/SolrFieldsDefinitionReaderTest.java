package com.sematext.searchschemer.reader.solr;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

public class SolrFieldsDefinitionReaderTest extends TestCase {
  @Test
  public void testParse() throws Exception {
    SolrFieldsDefinitionReader reader = new SolrFieldsDefinitionReader(new File(getClass().getClassLoader().getResource("test_schema.xml").getFile()));
    assertEquals(8, reader.readFields().size());
  }
}
