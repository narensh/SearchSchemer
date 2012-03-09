package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/** 
 * Field attributes for Solr.
 * 
 * @author Sematext
 *
 */
public class SolrFieldAttributes extends FieldAttributes { 
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
  public SolrFieldAttributes(String name, FieldType type, Boolean indexed, Boolean stored, Boolean multiValued) {
    super(name, type, indexed, stored, multiValued);
  }
  
  /** 
   * {@inheritDoc}
   */
  @Override
  public Boolean isAnalyzed() {
    if (getFieldType() != FieldType.STRING) {
      return true;
    } else {
      return false;
    }
  }
}
