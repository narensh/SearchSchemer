package com.sematext.searchschemer.reader.solr;

import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.solr.SolrFieldAttributes;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reader for static fields defined in Solr schema.xml file.
 * 
 * @author Sematext
 * 
 */
public class SolrStaticFieldsDefinitionReader {
  /** Digester parser instance. */
  protected Digester digester;

  /** File to parse. */
  protected File file;

  /**
   * Constructor.
   * 
   * @param file
   *          file to parse
   */
  public SolrStaticFieldsDefinitionReader(File file) {
    this.file = file;
    initializeDigester();
  }

  /**
   * Read fields from schema.xml file.
   * 
   * @return list of fields
   * @throws IOException
   *           thrown when I/O Error happens
   * @throws SAXException
   *           thrown when XML parsing error happens
   */
  public ArrayList<FieldAttributes> readFields() throws IOException, SAXException {
    return digester.parse(file);
  }

  /**
   * Initializes digester.
   */
  protected void initializeDigester() {
    digester = new Digester();
    digester.setNamespaceAware(true);
    digester.addObjectCreate("schema/", ArrayList.class);
    digester.addObjectCreate("schema/field", SolrFieldAttributes.class);
    digester.addSetProperties("schema/field/");
    digester.addSetNext("schema/field", "add");
  }
}
