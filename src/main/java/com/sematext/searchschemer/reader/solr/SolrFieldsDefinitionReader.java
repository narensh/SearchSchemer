package com.sematext.searchschemer.reader.solr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import com.sematext.searchschemer.index.FieldAttributes;

/**
 * Reader for fields defined in Solr schema.xml file.
 * 
 * @author Sematext
 * 
 */
public class SolrFieldsDefinitionReader {
  /** Digester parser instance. */
  private Digester digester;

  /** File to parse. */
  private File file;

  /**
   * Constructor.
   * 
   * @param file
   *          file to parse
   */
  public SolrFieldsDefinitionReader(File file) {
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
    digester.addObjectCreate("schema/fields", ArrayList.class);
    digester.addObjectCreate("schema/fields/field", FieldAttributes.class);
    digester.addSetProperties("schema/fields/field", "name", "name");
    digester.addSetProperties("schema/fields/field", "type", "type");
    digester.addSetProperties("schema/fields/field", "indexed", "indexed");
    digester.addSetProperties("schema/fields/field", "stored", "stored");
    digester.addSetNext("schema/fields/field", "add");
  }
}
