package com.sematext.searchschemer.index;

import java.util.Map;

/**
 * Index structure interface.
 * 
 * @author Sematext
 * 
 */
public interface IndexStructure {
  /**
   * Get fields for a given index.
   * 
   * @return map of fields and their attributes
   */
  Map<String, FieldAttributes> fields();

  /**
   * Get dynamic fields for a given index.
   * 
   * @return map of dynamic fields and their attributes
   */
  Map<String, FieldAttributes> dynamicFields();

  /**
   * Add non-dynamic field.
   * 
   * @param name
   *          field name
   * @param attributes
   *          field attributes
   */
  void addField(String name, FieldAttributes attributes);

  /**
   * Add field.
   * 
   * @param name
   *          field name
   * @param attributes
   *          field attributes
   * @param dynamic
   *          <code>true</code> is the field is dynamic, <code>false</code> otherwise
   */
  void addField(String name, FieldAttributes attributes, Boolean dynamic);
}
