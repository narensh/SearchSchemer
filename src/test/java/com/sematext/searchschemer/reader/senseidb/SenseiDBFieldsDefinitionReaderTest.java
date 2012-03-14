package com.sematext.searchschemer.reader.senseidb;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.type.FieldType;

public class SenseiDBFieldsDefinitionReaderTest extends TestCase {
  @Test
  public void testReader() throws Exception {
    SenseiDBFieldsDefinitionReader reader = new SenseiDBFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("senseidb/test_senseidb_schema.xml").getFile()));
    assertEquals(4, reader.readFields().size());
  }
  
  @Test
  public void testReaderFields() throws Exception {
    SenseiDBFieldsDefinitionReader reader = new SenseiDBFieldsDefinitionReader(new File(getClass().getClassLoader()
        .getResource("senseidb/test_senseidb_schema_small.xml").getFile()));
    assertEquals(1, reader.readFields().size());
    FieldAttributes field = reader.readFields().get(0);
    assertNotNull(field);
    assertEquals("contents", field.name());
    assertEquals(FieldType.TEXT, field.getFieldType());
    assertTrue(field.store());
    assertTrue(field.analyzed());
    assertTrue(field.multiValued());
    assertTrue(field.indexed());
  }
}
