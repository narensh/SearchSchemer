package com.sematext.searchschemer.client;

/**
 * SearchSchemer command line arguments.
 * 
 * @author Sematext
 * 
 */
public class SearchSchemerArguments {
  /** Input file name. */
  private String inputFileName;

  /** Output file name. */
  private String outputFileName;

  /** Input file type. */
  private ConfigurationType inputType;

  /** Output file type. */
  private ConfigurationType outputType;

  public String getInputFileName() {
    return inputFileName;
  }

  public void setInputFileName(String inputFileName) {
    this.inputFileName = inputFileName;
  }

  public String getOutputFileName() {
    return outputFileName;
  }

  public void setOutputFileName(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  public ConfigurationType getInputType() {
    return inputType;
  }

  public void setInputType(ConfigurationType inputType) {
    this.inputType = inputType;
  }

  public ConfigurationType getOutputType() {
    return outputType;
  }

  public void setOutputType(ConfigurationType outputType) {
    this.outputType = outputType;
  }

  @Override
  public String toString() {
    return "SearchSchemerArguments [inputFile=" + inputFileName + ", outputFile=" + outputFileName + ", inputType=" + inputType
        + ", outputType=" + outputType + "]";
  }
}
