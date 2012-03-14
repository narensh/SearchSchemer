package com.sematext.searchschemer.reader.elasticsearch;

import java.io.File;
import java.util.List;

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
    assertEquals("id", field.name());
    assertEquals(FieldType.LONG, field.fieldType());
    assertTrue(field.analyzed());
    assertTrue(field.multiValued());
    assertTrue(field.indexed());
    assertFalse(field.store());
  }
  
  @Test
  public void testReaderMultiField() throws Exception {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("elasticsearch/elasticsearch_test_mappings_multifield.json").getFile()));
    List<FieldAttributes> fields = reader.readFields();
    assertEquals(2, fields.size()); 
    FieldAttributes field1, field2;
    if (fields.get(0).name().compareTo("test") == 0) {
      field1 = fields.get(0);
      field2 = fields.get(1);
    } else {
      field1 = fields.get(1);
      field2 = fields.get(0);
    }
    // field 1
    assertEquals("test", field1.name());
    assertTrue(field1.analyzed());
    assertTrue(field1.multiValued());
    assertTrue(field1.indexed());
    assertTrue(field1.store());
    // field 2
    assertEquals("test.facet", field2.name());
    assertFalse(field2.analyzed());
    assertTrue(field2.multiValued());
    assertTrue(field2.indexed());
    assertTrue(field2.store());
  }
  
  @Test
  public void testReaderAdditionalAttributes() throws Exception {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("elasticsearch/elasticsearch_test_mappings_norms.json").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertEquals("id", field.name());
    assertTrue(field.analyzed());
    assertTrue(field.multiValued());
    assertTrue(field.indexed());
    assertTrue(field.store());
    assertTrue(field.omitNorms());
    assertTrue(field.omitTermFrequencyAndPositions());
    assertEquals(2.0f, field.boost());
  }
}
