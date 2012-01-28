package com.sematext.searchschemer.client;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

/** 
 * Command line reader. 
 * 
 * @author Sematext
 *
 */
public final class CommandLineReader {
  /** Command line options. */
  private static final Options OPTIONS = new Options();
  
  static {
    //TODO: command line arguments
  };
  
  public static void parse(final String[] args) {
    CommandLineParser parser = new GnuParser();
    //TODO: implementation
  }
  
  /** 
   * Prints usage. 
   */
  private void printHelp() {
    HelpFormatter helpFormater = new HelpFormatter();
    helpFormater.printHelp("java -jar <archive_name>", OPTIONS, true);
  }
}
