package com.sematext.searchschemer.reader.solr;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.FieldAttributes;

public class SolrDynamicFieldsDefinitionReaderTest extends TestCase {  
  @Test
  public void testParseDynamicFields() throws Exception {
    SolrDynamicFieldsDefinitionReader reader = new SolrDynamicFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("test_schema_small_dynamic.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("*_i", field.getName());
    assertEquals("int", field.getType());
  }
}