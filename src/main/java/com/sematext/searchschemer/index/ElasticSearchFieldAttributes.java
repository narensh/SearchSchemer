package com.sematext.searchschemer.index;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.elasticsearch.Analyzed;
import com.sematext.searchschemer.index.elasticsearch.Stored;

/**
 * Fields from ElasticSearch mappings.
 * 
 * @author Sematext
 * 
 */
public class ElasticSearchFieldAttributes extends AbstractFieldAttributes {
  private String analyzed;
  private String stored;

  /**
   * Constructor.
   */
  public ElasticSearchFieldAttributes() {
    super();
  }

  /**
   * Create field attribute.
   * 
   * @param name
   *          field name
   * @param type
   *          attribute type
   * @param stored
   *          is field stored (value 'no' or 'yes')
   * @param analyzed
   *          is field analyzed (value 'no', 'analyzed' or 'not_analyzed')
   */
  public ElasticSearchFieldAttributes(String name, String type, String stored, String analyzed) {
    this();
    this.name = name;
    this.type = type;
    this.stored = stored;
    this.analyzed = analyzed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isAnalyzed() {
    if (Analyzed.ANALYZED.toString().compareTo(analyzed.toUpperCase()) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isStored() {
    if (Stored.YES.toString().compareTo(stored.toUpperCase()) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isIndexed() {
    if (Analyzed.NO.toString().compareTo(analyzed.toUpperCase()) == 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isMultiValued() {
    return true; // this is always true in case of ElasticSearch as in Lucene
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ConfigurationType getConfigurationType() {
    return ConfigurationType.ELASTICSEARCH;
  }
}
