package com.sematext.searchschemer.reader;

import java.io.IOException;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.IndexStructure;

/**
 * Implementation of {@link IndexStructureReader} for Apache Solr.
 * 
 * @author Sematext
 * 
 */
public class SolrIndexStructureReader implements IndexStructureReader {
  protected SolrIndexStructureReader() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public IndexStructure read(String file) throws IOException {
    IndexStructure structure = new BasicIndexStructure();
    //TODO implementation
    return structure;
  }
}
