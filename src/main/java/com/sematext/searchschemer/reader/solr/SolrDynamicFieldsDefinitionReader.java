package com.sematext.searchschemer.reader.solr;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.digester3.Digester;

import com.sematext.searchschemer.index.solr.SolrFieldAttributes;

/**
 * Reader for static fields defined in Solr schema.xml file.
 * 
 * @author Sematext
 * 
 */
public class SolrDynamicFieldsDefinitionReader extends SolrStaticFieldsDefinitionReader {
  /**
   * Constructor.
   * 
   * @param file
   *          file to parse
   */
  public SolrDynamicFieldsDefinitionReader(File file) {
    super(file);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  protected void initializeDigester() {
    digester = new Digester();
    digester.setNamespaceAware(true);
    digester.addObjectCreate("schema/fields", ArrayList.class);
    digester.addObjectCreate("schema/fields/dynamicField", SolrFieldAttributes.class);
    digester.addSetProperties("schema/fields/dynamicField/");
    digester.addSetNext("schema/fields/dynamicField", "add");
  }
}
