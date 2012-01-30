package com.sematext.searchschemer.writer;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/** 
 * Implementation of {@link IndexStructureWriter} for SenseiDB.
 * 
 * @author Sematext
 *
 */
public class SenseidbIndexStructureWriter implements IndexStructureWriter {
  protected SenseidbIndexStructureWriter() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void write(IndexStructure structure, String fileName) throws IOException {
    //TODO implementation
  }
}
