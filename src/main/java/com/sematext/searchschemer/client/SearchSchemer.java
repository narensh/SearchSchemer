package com.sematext.searchschemer.client;

import java.io.IOException;

import com.sematext.searchschemer.reader.IndexStructureReader;
import com.sematext.searchschemer.reader.IndexStructureReaderFactory;
import com.sematext.searchschemer.writer.IndexStructureWriter;
import com.sematext.searchschemer.writer.IndexStructureWriterFactory;

/**
 * Main class.
 * 
 * @author Sematext
 * 
 */
public final class SearchSchemer {
  /**
   * Private constructor - final class.
   */
  private SearchSchemer() {
  }

  /**
   * Main method.
   * 
   * @param args
   *          command line arguments
   * @throws IOException
   *           throw when I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    SearchSchemer schemer = new SearchSchemer();
    schemer.run(args);
  }

  /**
   * Starts schemer.
   * 
   * @param args
   *          command line arguments
   * @throws IOException
   *           throw when I/O error occurs
   */
  private void run(String[] args) throws IOException {
    SearchSchemerArguments arguments = CommandLineReader.parse(args);
    if (arguments != null) {
      IndexStructureReader reader = IndexStructureReaderFactory.getReader(arguments.getInputType());
      IndexStructureWriter writer = IndexStructureWriterFactory.getWriter(arguments.getOutputType());
      writer.write(reader.read(arguments.getInputFileName()), arguments.getOutputFileName());
    }
  }
}
