package com.sematext.searchschemer.client;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

/**
 * Command line reader.
 * 
 * @author Sematext
 * 
 */
@SuppressWarnings("static-access")
public final class CommandLineReader {
  /** Command line options. */
  private static final Options OPTIONS = new Options();

  /** Argument name for input type configuration. */
  public static final String INPUT_TYPE = "inputType";

  /** Argument name for output type configuration. */
  public static final String OUTPUT_TYPE = "outputType";

  /** Argument name for input file location. */
  public static final String INPUT_FILE = "inputFile";

  /** Argument name for output file location. */
  public static final String OUTPUT_FILE = "outputFile";

  static {
    OPTIONS.addOption(OptionBuilder.withArgName("value").withLongOpt(INPUT_TYPE).hasArg()
        .withDescription("Input configuration type").isRequired().create());
    OPTIONS.addOption(OptionBuilder.withArgName("value").withLongOpt(OUTPUT_TYPE).hasArg()
        .withDescription("Output configuration type").isRequired().create());
    OPTIONS.addOption(OptionBuilder.withArgName("value").withLongOpt(INPUT_FILE).hasArg()
        .withDescription("Configuration file to read").isRequired().create());
    OPTIONS.addOption(OptionBuilder.withArgName("value").withLongOpt(OUTPUT_FILE).hasArg()
        .withDescription("Output configuration file").isRequired().create());
  };

  public static SearchSchemerArguments parse(final String[] args) {
    CommandLineParser parser = new GnuParser();
    try {
      CommandLine commandLine = parser.parse(OPTIONS, args);
      SearchSchemerArguments arguments = new SearchSchemerArguments();
      arguments.setInputType(ConfigurationType.valueOf(((String) commandLine.getOptionValue(INPUT_TYPE))
          .toUpperCase()));
      arguments.setOutputType(ConfigurationType.valueOf(((String) commandLine.getOptionValue(OUTPUT_TYPE))
          .toUpperCase()));
      arguments.setInputFileName((String) commandLine.getOptionValue(INPUT_FILE));
      arguments.setOutputFileName((String) commandLine.getOptionValue(OUTPUT_FILE));
      return arguments;
    } catch (Exception e) {
      System.err.println("Error during starup: " + e.getMessage());
      e.printStackTrace();
      printHelp();
    }
    return null;
  }

  /**
   * Prints usage.
   */
  private static void printHelp() {
    HelpFormatter helpFormater = new HelpFormatter();
    helpFormater.printHelp("java -jar SearchSchemer.jar", OPTIONS, true);
  }
}
