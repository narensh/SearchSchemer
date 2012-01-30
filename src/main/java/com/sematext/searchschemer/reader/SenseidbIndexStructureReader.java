package com.sematext.searchschemer.reader;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/**
 * Implementation of {@link IndexStructureReader} for SenseiDB.
 * 
 * @author Sematext
 * 
 */
public class SenseidbIndexStructureReader implements IndexStructureReader {
  protected SenseidbIndexStructureReader() {
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
