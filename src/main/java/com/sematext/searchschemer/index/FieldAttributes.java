package com.sematext.searchschemer.index;

/**
 * Attributes for a given field.
 * 
 * @author Sematext
 * 
 */
public final class FieldAttributes {
  private String type;
  private Boolean indexed;
  private Boolean stored;

  public FieldAttributes(String type) {
    this(type, true, false);
  }

  public FieldAttributes(String type, Boolean indexed) {
    this(type, indexed, false);
  }

  public FieldAttributes(String type, Boolean indexed, Boolean stored) {
    this.type = type;
    this.indexed = indexed;
    this.stored = stored;
  }

  public String getType() {
    return type;
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
}
