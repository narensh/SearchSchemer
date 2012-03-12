package com.sematext.searchschemer.index;

import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.type.FieldType;
import com.sematext.searchschemer.type.Mapper;

/**
 * 
 * @author Sematext
 * 
 */
public abstract class AbstractFieldAttributes implements FieldAttributes {
  /** Field name. */
  protected String name;

  /** Field type. */
  protected String type;

  /**
   * Constructor.
   */
  public AbstractFieldAttributes() {
    super();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public FieldType getFieldType() {
    Map<FieldType, String> types = Mapper.getMappings(getConfigurationType());
    for (Map.Entry<FieldType, String> entry : types.entrySet()) {
      if (entry.getValue().compareTo(type.toLowerCase()) == 0) {
        return entry.getKey();
      }
    }
    return FieldType.STRING;
  }
  
  /**
   * Return configuration type.
   * 
   * @return configuration type
   */
  public abstract ConfigurationType getConfigurationType();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
