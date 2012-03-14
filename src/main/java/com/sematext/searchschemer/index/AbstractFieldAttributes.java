package com.sematext.searchschemer.index;

import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.type.FieldType;
import com.sematext.searchschemer.type.Mapper;

/**
 * Base class for field attributes.
 * 
 * @author Sematext
 * 
 */
public abstract class AbstractFieldAttributes implements FieldAttributes {
  /** Field name. */
  protected String name;

  /** Field type. */
  protected String type;
  
  /** Field boost. */
  protected float boost = 1.0f;
  
  /** Omit norms for field. */
  protected Boolean omitNorms = false;
  
  /** Omit term frequency and position for field. */
  protected Boolean omitTermFreqAndPos = false;

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
  public FieldType fieldType() {
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

  public String name() {
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
  
  /**
   * {@inheritDoc}
   */
  @Override
  public float boost() {
    return boost;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean omitNorms() {
    return omitNorms;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean omitTermFrequencyAndPositions() {
    return omitTermFreqAndPos;
  }

  public void setBoost(float boost) {
    this.boost = boost;
  }

  public void setOmitNorms(Boolean omitNorms) {
    this.omitNorms = omitNorms;
  }

  public void setOmitTermFreqAndPos(Boolean omitTermFreqAndPos) {
    this.omitTermFreqAndPos = omitTermFreqAndPos;
  }
}
