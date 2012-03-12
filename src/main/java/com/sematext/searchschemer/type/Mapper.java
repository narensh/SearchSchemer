package com.sematext.searchschemer.type;

import java.util.HashMap;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;

/**
 * Data types mapper between search technologies.
 * 
 * @author Sematext
 * 
 */
public class Mapper {
  /** Mappings for Solr. */
  private static final Map<FieldType, String> SOLR = new HashMap<FieldType, String>();

  /** Mappings for Elasticsearch. */
  private static final Map<FieldType, String> ELASTICSEARCH = new HashMap<FieldType, String>();

  /** Mappings for SenseiDB. */
  private static final Map<FieldType, String> SENSEIDB = new HashMap<FieldType, String>();

  static {
    SOLR.put(FieldType.INTEGER, "int");
    SOLR.put(FieldType.LONG, "long");
    SOLR.put(FieldType.DOUBLE, "double");
    SOLR.put(FieldType.STRING, "string");
    SOLR.put(FieldType.TEXT, "text");
    SOLR.put(FieldType.DATE, "date");

    ELASTICSEARCH.put(FieldType.INTEGER, "integer");
    ELASTICSEARCH.put(FieldType.LONG, "long");
    ELASTICSEARCH.put(FieldType.DOUBLE, "double");
    ELASTICSEARCH.put(FieldType.STRING, "string");
    ELASTICSEARCH.put(FieldType.TEXT, "string");
    ELASTICSEARCH.put(FieldType.DATE, "date");

    SENSEIDB.put(FieldType.INTEGER, "int");
    SENSEIDB.put(FieldType.LONG, "long");
    SENSEIDB.put(FieldType.DOUBLE, "double");
    SENSEIDB.put(FieldType.STRING, "string");
    SENSEIDB.put(FieldType.TEXT, "text");
    SENSEIDB.put(FieldType.DATE, "date");
  }

  /**
   * Private constructor - no instances.
   */
  private Mapper() {
  }

  /**
   * Return type name for the given configuration type and field type.
   * 
   * @param configurationType
   *          configuration type
   * @param fieldType
   *          field type
   * @return type name
   */
  public static String getTypeName(ConfigurationType configurationType, FieldType fieldType) {
    return getMappings(configurationType).get(fieldType);
  }

  /**
   * Get mappings for given configuration type.
   * 
   * @param configurationType
   *          configuration type
   * @return mappings
   */
  public static Map<FieldType, String> getMappings(ConfigurationType configurationType) {
    switch (configurationType) {
      case SOLR:
        return Mapper.SOLR;
      case ELASTICSEARCH:
        return Mapper.ELASTICSEARCH;
      case SENSEIDB:
        return Mapper.SENSEIDB;
    }
    return null;
  }
}
