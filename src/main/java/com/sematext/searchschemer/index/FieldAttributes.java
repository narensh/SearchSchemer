package com.sematext.searchschemer.index;

import com.sematext.searchschemer.type.FieldType;

/**
 * Attributes for a given field.
 * 
 * @author Sematext
 * 
 */
public final class FieldAttributes {
  private FieldType type;
  private Boolean indexed;
  private Boolean stored;
  private Boolean analyzed;

  /**
   * Creates field attribute of a given type which is indexed, not stored and analyzed.
   * 
   * @param type
   *          attribute type
   */
  public FieldAttributes(FieldType type) {
    this(type, true, false, true);
  }

  /**
   * Creates field attribute of a given type which is not stored and analyzed.
   * 
   * @param type
   *          attribute type
   * @param indexed
   *          <code>true</code> if the type is indexed, <code>false</code> otherwise
   */
  public FieldAttributes(FieldType type, Boolean indexed) {
    this(type, indexed, false, true);
  }

  /**
   * Creates field attribute of a given type which is analyzed.
   * 
   * @param type
   *          attribute type
   * @param indexed
   *          <code>true</code> if the type is indexed, <code>false</code> otherwise
   * @param stored
   *          <code>true</code> if the type is stored, <code>false</code> otherwise
   */
  public FieldAttributes(FieldType type, Boolean indexed, Boolean stored) {
    this(type, indexed, stored, true);
  }

  /**
   * Create field attribute.
   * 
   * @param type
   *          attribute type
   * @param indexed
   *          <code>true</code> if the type is indexed, <code>false</code> otherwise
   * @param stored
   *          <code>true</code> if the type is stored, <code>false</code> otherwise
   * @param analyzed
   *          <code>true</code> if the type is analyzed, <code>false</code> otherwise
   */
  public FieldAttributes(FieldType type, Boolean indexed, Boolean stored, Boolean analyzed) {
    this.type = type;
    this.indexed = indexed;
    this.stored = stored;
    this.analyzed = analyzed;
  }

  public Boolean getAnalyzed() {
    return analyzed;
  }

  public void setAnalyzed(Boolean analyzed) {
    this.analyzed = analyzed;
  }

  public FieldType getType() {
    return type;
  }

  public void setType(FieldType type) {
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
}
