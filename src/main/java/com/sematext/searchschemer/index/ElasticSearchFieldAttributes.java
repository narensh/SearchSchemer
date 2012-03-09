package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/**
 * Fields from ElasticSearch mappings.
 * 
 * @author Sematext
 * 
 */
public class ElasticSearchFieldAttributes extends FieldAttributes {
  private boolean analyzed;

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
   * @param analysed
   *          <code>true</code> if the type is analyzed, <code>false</code> otherwise
   */
  public ElasticSearchFieldAttributes(String name, FieldType type, Boolean indexed, Boolean stored, Boolean analyzed) {
    super(name, type, indexed, stored, true);
    this.analyzed = analyzed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isAnalyzed() {
    return analyzed;
  }
}
