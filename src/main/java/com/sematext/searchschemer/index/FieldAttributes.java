package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;


/**
 * Attributes for a given field.
 * 
 * @author Sematext
 * 
 */
public final class FieldAttributes {
  private String name;
  private String type;
  private Boolean indexed;
  private Boolean stored;
  private Boolean analyzed;
  private Boolean multiValued;

  public FieldAttributes() {
    this(null, FieldType.STRING, false, false, false, false);
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
   * @param analyzed
   *          <code>true</code> if the type is analyzed, <code>false</code> otherwise
   * @param multiValued
   *          <code>true</code> if the type is multi valued, <code>false</code> otherwise
   */
  public FieldAttributes(String name, String type, Boolean indexed, Boolean stored, Boolean analyzed,
      Boolean multiValued) {
    this.name = name;
    this.type = type;
    this.indexed = indexed;
    this.stored = stored;
    this.analyzed = analyzed;
    this.multiValued = multiValued;
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
   * @param analyzed
   *          <code>true</code> if the type is analyzed, <code>false</code> otherwise
   * @param multiValued
   *          <code>true</code> if the type is multi valued, <code>false</code> otherwise
   */
  public FieldAttributes(String name, FieldType type, Boolean indexed, Boolean stored, Boolean analyzed,
      Boolean multiValued) {
    this(name, type.toString(), indexed, stored, analyzed, multiValued);
  }

  public Boolean getAnalyzed() {
    return analyzed;
  }

  public void setAnalyzed(Boolean analyzed) {
    this.analyzed = analyzed;
  }

  public String getType() {
    return type;
  }
  
  public FieldType getFieldType() {
    return FieldType.valueOf(type);
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getIndexed() {
    return indexed;
  }

  public void setIndexed(Boolean indexed) {
    this.indexed = indexed;
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
}
