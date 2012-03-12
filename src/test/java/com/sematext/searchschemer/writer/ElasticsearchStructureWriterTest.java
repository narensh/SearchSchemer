package com.sematext.searchschemer.writer;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.ElasticSearchFieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;

public class ElasticsearchStructureWriterTest extends TestCase {
  @Test
  public void testWriteNonDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new ElasticSearchFieldAttributes("cat", "string", "yes", "analyzed"), false);

    StringWriter writer = new StringWriter();
    ElasticsearchIndexStructureWriter indexWriter = new ElasticsearchIndexStructureWriter();
    indexWriter.write(structure, writer);

    assertEquals(
        "{\n \"mappings\" : {\n  \"type\" : {\n   \"properties\" : {\n    \"cat\" : { \"type\" : \"string\", \"store\" : \"yes\", \"index\" : \"analyzed\" }\n   }\n  }\n }\n}",
        writer.toString());
    writer.close();
  }

  @Test
  public void testWriteMultipleNonDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new ElasticSearchFieldAttributes("cat", "string", "yes", "analyzed"), false);
    structure.addField("menu", new ElasticSearchFieldAttributes("menu", "string", "yes", "no"), false);

    StringWriter writer = new StringWriter();
    ElasticsearchIndexStructureWriter indexWriter = new ElasticsearchIndexStructureWriter();
    indexWriter.write(structure, writer);

    assertEquals(
        "{\n \"mappings\" : {\n  \"type\" : {\n   \"properties\" : {\n    \"cat\" : { \"type\" : \"string\", \"store\" : \"yes\", \"index\" : \"analyzed\" },\n    \"menu\" : { \"type\" : \"string\", \"store\" : \"yes\", \"index\" : \"no\" }\n   }\n  }\n }\n}",
        writer.toString());
    writer.close();
  }

  @Test
  public void testWriteDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("*_string", new ElasticSearchFieldAttributes("*_string", "string", "yes", "no"), true);

    StringWriter writer = new StringWriter();
    ElasticsearchIndexStructureWriter indexWriter = new ElasticsearchIndexStructureWriter();
    indexWriter.write(structure, writer);

    assertEquals(
        "{\n \"mappings\" : {\n  \"type\" : {\n   \"dynamic_templates\" : [\n    {\n     \"template__string\" : {\n      \"match\" : \"*_string\",\n      \"match_mapping_type\" : \"string\",\n      \"mapping\" : { \"type\" : \"string\", \"store\" : \"yes\", \"index\" : \"no\" }\n     }\n    }\n   ]\n  }\n }\n}",
        writer.toString());
    writer.close();
  }
}
