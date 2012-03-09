package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/**
 * Attributes for a given field.
 * 
 * @author Sematext
 * 
 */
public abstract class FieldAttributes {
  protected String name;
  protected String type;
  protected Boolean stored;
  protected Boolean multiValued;
  protected Boolean indexed;

  /**
   * Default constructor.
   */
  public FieldAttributes() {
    this(null, FieldType.STRING, true, true, false);
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
  public FieldAttributes(String name, FieldType type, Boolean indexed, Boolean stored, Boolean multiValued) {
    this.name = name;
    this.type = type.toString();
    this.indexed = indexed;
    this.stored = stored;
    this.multiValued = multiValued;
  }

  /**
   * Return field type as {@link FieldType} object instance.
   * 
   * @return field type
   */
  public FieldType getFieldType() {
    FieldType type = FieldType.valueOf(this.type);
    if (type == null) {
      return FieldType.STRING;
    }
    return type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getStored() {
    return stored;
  }

  public void setStored(Boolean stored) {
    this.stored = stored;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getMultiValued() {
    return multiValued;
  }

  public void setMultiValued(Boolean multiValued) {
    this.multiValued = multiValued;
  }
  
  public Boolean getIndexed() {
    return indexed;
  }

  public void setIndexed(Boolean indexed) {
    this.indexed = indexed;
  }

  /**
   * Is field analyzed.
   * 
   * @return <code>true</code> if field is analyzed, <code>false</code> otherwise.
   */
  public abstract Boolean isAnalyzed();
}
