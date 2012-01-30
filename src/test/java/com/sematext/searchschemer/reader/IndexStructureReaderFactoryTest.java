package com.sematext.searchschemer.reader;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.client.ConfigurationType;

public class IndexStructureReaderFactoryTest extends TestCase {
  @Test
  public void testGetReader() {
    assertTrue("SolrIndexStructureReader instance awaited",
        IndexStructureReaderFactory.getReader(ConfigurationType.SOLR) instanceof SolrIndexStructureReader);
    assertTrue(
        "ElasticsearchIndexStructureReader instance awaited",
        IndexStructureReaderFactory.getReader(ConfigurationType.ELASTICSEARCH) instanceof ElasticsearchIndexStructureReader);
    assertTrue("SenseidbIndexStructureReader instance awaited",
        IndexStructureReaderFactory.getReader(ConfigurationType.SENSEIDB) instanceof SenseidbIndexStructureReader);
  }
}
