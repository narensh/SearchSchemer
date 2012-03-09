package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/**
 * Fields from SenseiDB table configuration. 
 * 
 * @author Sematext
 *
 */
public class SenseiDBFieldAttributes extends FieldAttributes {
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
   */
  public SenseiDBFieldAttributes(String name, FieldType type, Boolean indexed, Boolean stored) {
    super(name, type, indexed, stored, true);
  }

  
  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean isAnalyzed() {
    return true;
  }

}
