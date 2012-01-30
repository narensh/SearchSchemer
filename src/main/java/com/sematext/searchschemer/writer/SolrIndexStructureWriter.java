package com.sematext.searchschemer.writer;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/** 
 * Implementation of {@link IndexStructureWriter} for Apache Solr.
 * 
 * @author Sematext
 *
 */
public class SolrIndexStructureWriter implements IndexStructureWriter {
  protected SolrIndexStructureWriter() {
  }
  
  /** 
   * {@inheritDoc}
   */
  @Override
  public void write(IndexStructure structure, String fileName) throws IOException {
    //TODO implementation
  }
}
