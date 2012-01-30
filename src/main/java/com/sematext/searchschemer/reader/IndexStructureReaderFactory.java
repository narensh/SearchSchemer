package com.sematext.searchschemer.reader;

import com.sematext.searchschemer.client.ConfigurationType;

/**
 * Factory for index structure readers.
 * 
 * @author Sematext
 * 
 */
public class IndexStructureReaderFactory {
  /**
   * Private constructor - no instances.
   */
  private IndexStructureReaderFactory() {
  }

  /**
   * Returns appropriate reader depending on configuration type.
   * 
   * @param type
   *          configuration type
   * @return reader instance
   */
  public static IndexStructureReader getReader(ConfigurationType type) {
    switch (type) {
      case SOLR:
        return new SolrIndexStructureReader();
      case ELASTICSEARCH:
        return new ElasticsearchIndexStructureReader();
      case SENSEIDB:
        return new SenseidbIndexStructureReader();
    }
    return null;
  }
}
