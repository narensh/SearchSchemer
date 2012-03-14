package com.sematext.searchschemer.index.solr;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.AbstractFieldAttributes;
import com.sematext.searchschemer.type.FieldType;

/**
 * Field attributes for Solr.
 * 
 * @author Sematext
 * 
 */
public final class SolrFieldAttributes extends AbstractFieldAttributes {
  private Boolean indexed = false;
  private Boolean stored = false;
  private Boolean multiValued = false;

  /**
   * Default constructor.
   */
  public SolrFieldAttributes() {
    super();
  }

  /**
   * Create field attribute.
   * 
   * @param name
   *          field name
   * @param type
   *          attribute type
   * @param indexed
   *          <code>true</code> if the type is indexed, <code>false</code> otherwise
   * @param stored
   *          <code>true</code> if the type is stored, <code>false</code> otherwise
   * @param multiValued
   *          <code>true</code> if the type is multi valued, <code>false</code> otherwise
   */
  public SolrFieldAttributes(String name, String type, Boolean indexed, Boolean stored, Boolean multiValued) {
    this();
    this.type = type;
    this.name = name;
    this.indexed = indexed;
    this.stored = stored;
    this.multiValued = multiValued;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean analyzed() {
    if (indexed && fieldType() != FieldType.STRING) {
      return true;
    }
    return false;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean store() {
    return stored;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean multiValued() {
    return multiValued;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean indexed() {
    return indexed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ConfigurationType getConfigurationType() {
    return ConfigurationType.SOLR;
  }

  public void setIndexed(Boolean indexed) {
    this.indexed = indexed;
  }

  public void setStored(Boolean stored) {
    this.stored = stored;
  }

  public void setMultiValued(Boolean multiValued) {
    this.multiValued = multiValued;
  }
}
