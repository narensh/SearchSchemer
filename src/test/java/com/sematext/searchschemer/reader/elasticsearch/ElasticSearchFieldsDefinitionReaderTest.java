package com.sematext.searchschemer.reader.elasticsearch;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.type.FieldType;

public class ElasticSearchFieldsDefinitionReaderTest extends TestCase {
  @Test
  public void testReaderMultipleMappings() throws Exception {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("elasticsearch/elasticsearch_test_mappings.json").getFile()));
    assertEquals(7, reader.readFields().size());
  }

  @Test
  public void testReaderSingleMappings() throws Exception {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("elasticsearch/elasticsearch_test_mappings_single_type.json").getFile()));
    assertEquals(7, reader.readFields().size());
  }
  
  @Test
  public void testReaderSingleField() throws Exception {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("elasticsearch/elasticsearch_test_mappings_single_field.json").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("id", field.getName());
    assertEquals(FieldType.LONG, field.getFieldType());
    assertTrue(field.isAnalyzed());
    assertTrue(field.isMultiValued());
    assertTrue(field.isIndexed());
    assertFalse(field.isStored());
  }
}
