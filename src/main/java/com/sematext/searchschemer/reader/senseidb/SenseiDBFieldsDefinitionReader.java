package com.sematext.searchschemer.reader.senseidb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.sensidb.SenseiDBFieldAttributes;

/** 
 * SenseiDB structure file reader. 
 * 
 * @author Sematext
 *
 */
public class SenseiDBFieldsDefinitionReader {
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
  public SenseiDBFieldsDefinitionReader(File file) {
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
    digester.addObjectCreate("schema/table", ArrayList.class);
    digester.addObjectCreate("schema/table/column", SenseiDBFieldAttributes.class);
    digester.addSetProperties("schema/table/column");
    digester.addSetNext("schema/table/column", "add");
  }
}
