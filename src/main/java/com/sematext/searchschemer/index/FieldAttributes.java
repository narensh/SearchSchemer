package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/**
 * Attributes for a given field.
 * 
 * @author Sematext
 * 
 */
public interface FieldAttributes {
  /**
   * Return field type. The default field type is FieldType.STRING.
   * 
   * @return field type
   */
  public FieldType getFieldType();

  /**
   * Is field stored.
   * 
   * @return <code>true</code> if field is stored, <code>false</code> otherwise.
   */
  public Boolean isStored();

  /**
   * Return field name.
   * 
   * @return field name
   */
  public String getName();

  /**
   * Can field have multiple values.
   * 
   * @return <code>true</code> if field is multi valued, <code>false</code> otherwise.
   */
  public Boolean isMultiValued();

  /**
   * Is field indexed.
   * 
   * @return <code>true</code> if field is indexed, <code>false</code> otherwise.
   */
  public Boolean isIndexed();

  /**
   * Is field analyzed.
   * 
   * @return <code>true</code> if field is analyzed, <code>false</code> otherwise.
   */
  public abstract Boolean isAnalyzed();
}
