package com.sematext.searchschemer.reader;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/**
 * Implementation of {@link IndexStructureReader} for Elasticsearch.
 * 
 * @author Sematext
 * 
 */
public class ElasticsearchIndexStructureReader implements IndexStructureReader {
  protected ElasticsearchIndexStructureReader() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public IndexStructure read(String file) throws IOException {
    //TODO implement
    return null;
  }
}
