package com.sematext.searchschemer.reader.elasticsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.elasticsearch.ElasticSearchFieldAttributes;

/**
 * ElasticSearch mappings reader.
 * 
 * @author Sematext
 * 
 */
public class ElasticSearchFieldsDefinitionReader {
  /** File to parse. */
  protected File file;

  /** Json reader. */
  private JsonReader reader;

  /** List of readed documents. */
  List<FieldAttributes> fields;

  /**
   * Constructor.
   * 
   * @param file
   *          file to parse
   */
  public ElasticSearchFieldsDefinitionReader(File file) {
    this.file = file;
  }

  /**
   * Read fields from mappings file.
   * 
   * @return list of fields
   * @throws IOException
   *           thrown when I/O Error happens
   */
  public List<FieldAttributes> readFields() throws IOException {
    initialize();
    reader.beginObject();
    JsonToken token = reader.peek();
    if (JsonToken.BEGIN_OBJECT == token) {
      readProperties();
    } else if (JsonToken.NAME == token) {
      String name = reader.nextName();
      if ("mappings".compareTo(name) == 0) {
        reader.beginObject();
        reader.nextName();
        readProperties();
        reader.endObject();
      } else {
        readProperties();
      }

    }
    reader.endObject();
    return fields;
  }

  /**
   * Read properties.
   */
  private void readProperties() throws IOException {
    reader.beginObject();
    while (true) {
      JsonToken token = reader.peek();
      if (JsonToken.NAME == token) {
        String name = reader.nextName();
        if ("properties".compareTo(name) == 0) {
          reader.beginObject();
          readFieldMappings();
          reader.endObject();
          break;
        } else {
          reader.skipValue();
        }
      } else {
        reader.skipValue();
      }
    }
    reader.endObject();
  }

  /**
   * Read fields.
   */
  private void readFieldMappings() throws IOException {
    JsonToken token = reader.peek();
    while (JsonToken.NAME == token) {
      ElasticSearchFieldAttributes field = new ElasticSearchFieldAttributes();
      String name = reader.nextName();
      field.setName(name);
      reader.beginObject();
      JsonToken innerToken = reader.peek();
      while (innerToken != JsonToken.BEGIN_OBJECT && innerToken != JsonToken.END_OBJECT) {
        if (JsonToken.NAME == reader.peek()) {
          String propertyName = reader.nextName();
          String value = reader.nextString();
          setPropert(propertyName, value, field);
        }
        innerToken = reader.peek();
      }
      fields.add(field);
      reader.endObject();
      token = reader.peek();
    }
  }

  /**
   * Sets property for field.
   * 
   * @param propertyName
   *          property name
   * @param value
   *          property value
   * @param field
   *          field
   */
  private void setPropert(String propertyName, String value, ElasticSearchFieldAttributes field) {
    if ("type".compareTo(propertyName) == 0) {
      field.setType(value);
    } else if ("store".compareTo(propertyName) == 0) {
      field.setStored(value);
    } else if ("index".compareTo(propertyName) == 0) {
      field.setAnalyzed(value);
    }
  }

  /**
   * Initialize reader.
   * 
   * @throws FileNotFoundException
   *           thrown when clear error happens
   */
  protected void initialize() throws FileNotFoundException {
    fields = new ArrayList<FieldAttributes>();
    reader = new JsonReader(new FileReader(file));
  }
}
