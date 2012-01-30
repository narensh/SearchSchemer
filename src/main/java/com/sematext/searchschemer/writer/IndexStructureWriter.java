package com.sematext.searchschemer.writer;

import java.io.IOException;

import com.sematext.searchschemer.index.IndexStructure;

/**
 * Interface for index structure writing.
 * 
 * @author Sematext
 * 
 */
public interface IndexStructureWriter {
  /**
   * Writes index structure to the given file.
   * 
   * @param structure
   *          index structure
   * @param fileName
   *          name of the output file
   * @throws IOException
   *           thrown when I/O error occurs
   */
  void write(IndexStructure structure, String fileName) throws IOException;
}
