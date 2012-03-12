package com.sematext.searchschemer.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.reader.elasticsearch.ElasticSearchFieldsDefinitionReader;

/**
 * Implementation of {@link IndexStructureReader} for ElasticSearch.
 * 
 * @author Sematext
 * 
 */
public class ElasticsearchIndexStructureReader implements IndexStructureReader {
  protected ElasticsearchIndexStructureReader() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public IndexStructure read(String file) throws IOException {
    ElasticSearchFieldsDefinitionReader reader = new ElasticSearchFieldsDefinitionReader(new File(file));
    List<FieldAttributes> fields = reader.readFields();
    IndexStructure structure = new BasicIndexStructure();
    for (FieldAttributes field : fields) {
      structure.addField(field.getName(), field);
    }
    return structure;
  }
}
