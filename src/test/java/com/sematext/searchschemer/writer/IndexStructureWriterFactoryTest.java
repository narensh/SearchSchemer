package com.sematext.searchschemer.writer;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.client.ConfigurationType;

public class IndexStructureWriterFactoryTest extends TestCase {
  @Test
  public void testGetWriter() {
    assertTrue("SolrIndexStructureWriter instance awaited",
        IndexStructureWriterFactory.getWriter(ConfigurationType.SOLR) instanceof SolrIndexStructureWriter);
    assertTrue(
        "ElasticsearchIndexStructureWriter instance awaited",
        IndexStructureWriterFactory.getWriter(ConfigurationType.ELASTICSEARCH) instanceof ElasticsearchIndexStructureWriter);
    assertTrue("SenseidbIndexStructureWriter instance awaited",
        IndexStructureWriterFactory.getWriter(ConfigurationType.SENSEIDB) instanceof SenseidbIndexStructureWriter);
  }
}
