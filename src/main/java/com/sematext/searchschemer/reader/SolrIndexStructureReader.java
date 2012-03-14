package com.sematext.searchschemer.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.reader.solr.SolrDynamicFieldsDefinitionReader;
import com.sematext.searchschemer.reader.solr.SolrStaticFieldsDefinitionReader;

/**
 * Implementation of {@link IndexStructureReader} for Apache Solr.
 * 
 * @author Sematext
 * 
 */
public class SolrIndexStructureReader implements IndexStructureReader {
  protected SolrIndexStructureReader() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public IndexStructure read(String file) throws IOException {
    SolrStaticFieldsDefinitionReader reader = new SolrStaticFieldsDefinitionReader(new File(file));
    SolrDynamicFieldsDefinitionReader readerDynamic = new SolrDynamicFieldsDefinitionReader(new File(file));
    try {
      List<FieldAttributes> fields = reader.readFields();
      List<FieldAttributes> dynamicFields = readerDynamic.readFields();
      IndexStructure structure = new BasicIndexStructure();
      for (FieldAttributes field : fields) {
        structure.addField(field.name(), field);
      }
      for (FieldAttributes field : dynamicFields) {
        structure.addField(field.name(), field, true);
      }
      return structure;
    } catch (SAXException ex) {
      throw new IOException("Schema parsing error occured", ex);
    }
  }
}
