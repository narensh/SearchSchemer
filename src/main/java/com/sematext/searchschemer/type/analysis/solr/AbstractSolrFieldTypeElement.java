/*
 *    Copyright (c) Sematext International
 *    All Rights Reserved
 *
 *    THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Sematext International
 *    The copyright notice above does not evidence any
 *    actual or intended publication of such source code.
 */
package com.sematext.searchschemer.type.analysis.solr;

import java.util.ArrayList;
import java.util.List;

import com.sematext.searchschemer.type.analysis.Attribute;

/**
 * Abstract field type element.
 * 
 * @author sematext, http://www.sematext.com/
 */
public abstract class AbstractSolrFieldTypeElement {
  private String name;
  private String className;
  private List<Attribute> attributes;

  /**
   * 
   * @param name
   * @param className
   */
  protected AbstractSolrFieldTypeElement(String name, String className) {
    this.name = name;
    this.className = className;
    this.attributes = new ArrayList<Attribute>();
  }

  /**
   * Adds attribute.
   * 
   * @param attribute
   *          attribute to add
   */
  public void addAttribute(Attribute attribute) {
    attributes.add(attribute);
  }

  public String getName() {
    return name;
  }

  public String getClassName() {
    return className;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }
}
