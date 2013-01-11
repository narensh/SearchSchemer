package com.sematext.searchschemer.type.analysis;

import java.io.StringWriter;

import com.sematext.searchschemer.type.Writable;

/**
 * Class representing attribute.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class Attribute implements Writable {
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

  /**
   * (non-Javadoc)
   * 
   * @see com.sematext.searchschemer.type.Writable#writableForm()
   */
  @Override
  public String writableForm() {
    StringWriter writer = new StringWriter();
    writer.write(name);
    writer.write("=\"");
    writer.write(value);
    writer.write("=\"");
    return writer.toString();
  }
}
