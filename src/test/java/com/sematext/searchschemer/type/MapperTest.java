package com.sematext.searchschemer.type;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.client.ConfigurationType;

public class MapperTest extends TestCase {
  @Test
  public void testGetTypeName() {
    assertEquals("Solr text type name check", "text", Mapper.getTypeName(ConfigurationType.SOLR, FieldType.TEXT));
    assertEquals("Solr string type name check", "string", Mapper.getTypeName(ConfigurationType.SOLR, FieldType.STRING));
    assertEquals("Elasticsearch text type name check", "string", Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, FieldType.TEXT));
    assertEquals("Elasticsearch string type name check", "string", Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, FieldType.STRING));
    assertEquals("Senseidb text type name check", "text", Mapper.getTypeName(ConfigurationType.SENSEIDB, FieldType.TEXT));
    assertEquals("Senseidb string type name check", "string", Mapper.getTypeName(ConfigurationType.SENSEIDB, FieldType.STRING));
  }
}
