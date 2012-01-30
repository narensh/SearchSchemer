package com.sematext.searchschemer.writer;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/** 
 * Implementation of {@link IndexStructureWriter} for Elasticsearch.
 * 
 * @author Sematext
 *
 */
public class ElasticsearchIndexStructureWriter implements IndexStructureWriter {
  protected ElasticsearchIndexStructureWriter() {
  }
  
  @Override
  public void write(IndexStructure structure, String fileName) throws IOException {
    //TODO implementation
  }
}
