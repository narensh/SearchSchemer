package com.sematext.searchschemer.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.sematext.searchschemer.index.IndexStructure;

/** 
 * Abstract implementation of {@link IndexStructureWriter}.
 * 
 * @author Sematext
 *
 */
public abstract class AbstractIndexStructureWriter implements IndexStructureWriter {
  /**
   * {@inheritDoc}
   */
  @Override
  public void write(IndexStructure structure, String fileName) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    write(structure, writer);
    writer.flush();
    writer.close();
  }
  
  /**
   * Writes index structure.
   * 
   * @param structure
   *          index structure
   * @param writer
   *          writer instance
   * @throws IOException
   *           thrown when I/O error occurs
   */
  protected abstract void write(IndexStructure structure, Writer writer) throws IOException;
}
