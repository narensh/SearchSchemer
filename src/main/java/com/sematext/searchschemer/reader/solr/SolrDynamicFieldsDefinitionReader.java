package com.sematext.searchschemer.reader.solr;

import com.sematext.searchschemer.index.solr.SolrFieldAttributes;
import org.apache.commons.digester3.Digester;

import java.io.File;
import java.util.ArrayList;

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
    digester.addObjectCreate("schema/", ArrayList.class);
    digester.addObjectCreate("schema/dynamicField", SolrFieldAttributes.class);
    digester.addSetProperties("schema/dynamicField/");
    digester.addSetNext("schema/dynamicField", "add");
  }
}
