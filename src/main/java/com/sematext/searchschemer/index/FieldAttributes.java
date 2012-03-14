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
  public FieldType fieldType();

  /**
   * Is field stored.
   * 
   * @return <code>true</code> if field is stored, <code>false</code> otherwise.
   */
  public Boolean store();

  /**
   * Return field name.
   * 
   * @return field name
   */
  public String name();

  /**
   * Can field have multiple values.
   * 
   * @return <code>true</code> if field is multi valued, <code>false</code> otherwise.
   */
  public Boolean multiValued();

  /**
   * Is field indexed.
   * 
   * @return <code>true</code> if field is indexed, <code>false</code> otherwise.
   */
  public Boolean indexed();

  /**
   * Is field analyzed.
   * 
   * @return <code>true</code> if field is analyzed, <code>false</code> otherwise.
   */
  public abstract Boolean analyzed();

  /**
   * Returns field boost.
   * 
   * @return boost
   */
  public abstract float boost();

  /**
   * Should norms be disabled for the given field.
   * 
   * @return <code>true</code> if field have norms disabled, <code>false</code> otherwise.
   */
  public abstract Boolean omitNorms();

  /**
   * Should term frequency and positions be disabled.
   * 
   * @return <code>true</code> if field term frequency and positions should be disabled, <code>false</code> otherwise.
   */
  public abstract Boolean omitTermFrequencyAndPositions();
}
