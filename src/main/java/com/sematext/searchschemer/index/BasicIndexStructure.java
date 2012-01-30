package com.sematext.searchschemer.index;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of {@link IndexStructure}.
 * 
 * @author Sematext
 * 
 */
public class BasicIndexStructure implements IndexStructure {
  /** Non-dynamic fields. */
  private Map<String, FieldAttributes> fields;
  
  /** Dynamic fields. */
  private Map<String, FieldAttributes> dynamicFields;
  
  public BasicIndexStructure() {
    fields = new LinkedHashMap<String, FieldAttributes>();
    dynamicFields = new LinkedHashMap<String, FieldAttributes>();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, FieldAttributes> fields() {
    return fields;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, FieldAttributes> dynamicFields() {
    return dynamicFields;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addField(String name, FieldAttributes attributes) {
    addField(name, attributes, false);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addField(String name, FieldAttributes attributes, Boolean dynamic) {
    if (dynamic) {
      dynamicFields.put(name, attributes);
    } else {
      fields.put(name, attributes);
    }
  }
}
