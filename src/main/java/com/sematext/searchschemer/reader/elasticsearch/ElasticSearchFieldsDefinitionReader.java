package com.sematext.searchschemer.reader.elasticsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sematext.searchschemer.index.FieldAttributes;

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

  /**
   * Constructor.
   * 
   * @param file
   *          file to parse
   * @throws FileNotFoundException
   *           thrown when file not found
   */
  public ElasticSearchFieldsDefinitionReader(File file) throws FileNotFoundException {
    this.file = file;
    this.reader = new JsonReader(new FileReader(file));
  }

  /**
   * Read fields from mappings file.
   * 
   * @return list of fields
   * @throws IOException
   *           thrown when I/O Error happens
   */
  public List<FieldAttributes> readFields() throws IOException {
    reader.beginObject();
    JsonToken token = reader.peek();
    if (JsonToken.BEGIN_OBJECT == token) {
      //TODO implementation
    } else if (JsonToken.NAME == token) {
      //TODO implementation
    } 
    return Collections.<FieldAttributes>emptyList();
  }
}
