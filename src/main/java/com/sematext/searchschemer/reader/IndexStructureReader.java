package com.sematext.searchschemer.reader;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/**
 * Interface for index structure reading functionality.
 * 
 * @author Sematext
 * 
 */
public interface IndexStructureReader {
  /**
   * Read index structure details.
   * 
   * @param file
   *          file holding configuration
   * @return index structure
   * @throws IOException
   *           thrown when I/O error occurs
   */
  IndexStructure read(String file) throws IOException;
}
