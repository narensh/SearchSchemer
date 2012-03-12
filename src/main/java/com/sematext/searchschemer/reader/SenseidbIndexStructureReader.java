package com.sematext.searchschemer.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.reader.senseidb.SenseiDBFieldsDefinitionReader;

/**
 * Implementation of {@link IndexStructureReader} for SenseiDB.
 * 
 * @author Sematext
 * 
 */
public class SenseidbIndexStructureReader implements IndexStructureReader {
  protected SenseidbIndexStructureReader() {
  }
  
  /** 
   * {@inheritDoc}
   */
  @Override
  public IndexStructure read(String file) throws IOException {
    SenseiDBFieldsDefinitionReader reader = new SenseiDBFieldsDefinitionReader(new File(file));
    try {
      List<FieldAttributes> fields = reader.readFields();
      IndexStructure structure = new BasicIndexStructure();
      for (FieldAttributes field : fields) {
        structure.addField(field.getName(), field);
      }
      return structure;
    } catch (SAXException ex) {
      throw new IOException("SenseiDB schema parsing error occured", ex);
    }
  }
}
