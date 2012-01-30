package com.sematext.searchschemer.client;

import junit.framework.TestCase;

import org.junit.Test;

public class CommandLineReaderTest extends TestCase {
  @Test
  public void testCommandLineArgumentsParsing() throws Exception {
    String args = "--inputType solr --outputType elasticsearch --inputFile schema.xml --outputFile mappings.json";
    SearchSchemerArguments arguments = CommandLineReader.parse(args.split(" "));
    
    assertNotNull(arguments);
    assertEquals("schema.xml", arguments.getInputFileName());
    assertEquals("mappings.json", arguments.getOutputFileName());
    assertEquals(ConfigurationType.SOLR, arguments.getInputType());
    assertEquals(ConfigurationType.ELASTICSEARCH, arguments.getOutputType());
  }
}
