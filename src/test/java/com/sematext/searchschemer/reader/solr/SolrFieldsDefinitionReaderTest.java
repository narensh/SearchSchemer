package com.sematext.searchschemer.reader.solr;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.FieldAttributes;

public class SolrFieldsDefinitionReaderTest extends TestCase {
  /**
  @Test
  public void testParse() throws Exception {
    SolrFieldsDefinitionReader reader = new SolrFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("test_schema.xml").getFile()));
    assertEquals(8, reader.readFields().size());
  }*/
  
  @Test
  public void testParse2() throws Exception {
    SolrFieldsDefinitionReader reader = new SolrFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("test_schema_small.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    System.out.println(field.getName());
    System.out.println(field.getType());
  }
}
