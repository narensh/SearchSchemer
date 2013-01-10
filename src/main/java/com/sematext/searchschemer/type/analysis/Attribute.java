package com.sematext.searchschemer.type.analysis;

/**
 * Class representing attribute.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class Attribute {
  private String name;
  private String value;

  /**
   * Constructor.
   * 
   * @param name
   *          attribute name
   * @param value
   *          attribute value
   */
  public Attribute(String name, String value) {
    super();
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}
