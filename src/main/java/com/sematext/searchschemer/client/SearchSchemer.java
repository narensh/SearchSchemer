package com.sematext.searchschemer.client;

import java.io.IOException;

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
      //TODO initialize schemer and run
    }
  }
}
