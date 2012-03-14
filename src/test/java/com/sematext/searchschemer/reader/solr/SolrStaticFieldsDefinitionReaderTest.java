package com.sematext.searchschemer.reader.solr;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.type.FieldType;

public class SolrStaticFieldsDefinitionReaderTest extends TestCase {
  @Test
  public void testParse() throws Exception {
    SolrStaticFieldsDefinitionReader reader = new SolrStaticFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("solr/test_schema.xml").getFile()));
    assertEquals(8, reader.readFields().size());
  }
  
  @Test
  public void testParseString() throws Exception {
    SolrStaticFieldsDefinitionReader reader = new SolrStaticFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("solr/test_schema_small.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("id", field.name());
    assertEquals(FieldType.STRING, field.fieldType());
    assertTrue(field.indexed());
    assertTrue(field.store());
    assertFalse(field.analyzed());
  }
  
  @Test
  public void testParseText() throws Exception {
    SolrStaticFieldsDefinitionReader reader = new SolrStaticFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("solr/test_schema_small_string_text.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("id", field.name());
    assertEquals(FieldType.TEXT, field.fieldType());
    assertTrue(field.indexed());
    assertTrue(field.store());
    assertTrue(field.analyzed());
  }
  
  @Test
  public void testParseAdditionalAttributes() throws Exception {
    SolrStaticFieldsDefinitionReader reader = new SolrStaticFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("solr/test_schema_additional_attributes.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("id", field.name());
    assertEquals(FieldType.TEXT, field.fieldType());
    assertTrue(field.indexed());
    assertTrue(field.store());
    assertTrue(field.analyzed());
    assertTrue(field.omitNorms());
    assertTrue(field.omitTermFrequencyAndPositions());
    assertEquals(2.0f, field.boost());
  }
}
