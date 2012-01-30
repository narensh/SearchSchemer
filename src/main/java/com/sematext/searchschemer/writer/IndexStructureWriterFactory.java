package com.sematext.searchschemer.writer;

import com.sematext.searchschemer.client.ConfigurationType;

/**
 * Factory for structure writer.
 * 
 * @author Sematext
 * 
 */
public class IndexStructureWriterFactory {
  /**
   * Private constructor - no instances.
   */
  private IndexStructureWriterFactory() {
  }

  /**
   * Returns index structure writer.
   * 
   * @param type
   *          configuration type
   * @return writer instance
   */
  public static IndexStructureWriter getWriter(ConfigurationType type) {
    switch (type) {
      case SOLR:
        return new SolrIndexStructureWriter();
      case ELASTICSEARCH:
        return new ElasticsearchIndexStructureWriter();
      case SENSEIDB:
        return new SenseidbIndexStructureWriter();
    }
    return null;
  }
}
