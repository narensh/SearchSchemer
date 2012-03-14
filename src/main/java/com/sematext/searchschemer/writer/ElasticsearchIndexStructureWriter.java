package com.sematext.searchschemer.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.index.elasticsearch.Analyzed;
import com.sematext.searchschemer.type.Mapper;
import com.sematext.searchschemer.type.elasticsearch.ElasticSearchMappingsNames;

/**
 * Implementation of {@link IndexStructureWriter} for Elasticsearch.
 * 
 * @author Sematext
 * 
 */
public class ElasticsearchIndexStructureWriter extends AbstractIndexStructureWriter {
  protected ElasticsearchIndexStructureWriter() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void write(IndexStructure structure, Writer writer) throws IOException {
    writer.write("{\n");
    writer.write(" \"" + ElasticSearchMappingsNames.MAPPINGS + "\" : {\n");
    writer.write("  \"" + ElasticSearchMappingsNames.TYPE + "\" : {\n");
    if (!structure.fields().isEmpty()) {
      writer.write("   \"" + ElasticSearchMappingsNames.PROPERTIES + "\" : {\n");
      Iterator<Map.Entry<String, FieldAttributes>> itr = structure.fields().entrySet().iterator();
      while (itr.hasNext()) {
        Map.Entry<String, FieldAttributes> field = itr.next();
        writeField(field.getKey(), field.getValue(), writer);
        if (itr.hasNext()) {
          writer.write(",");
        }
        writer.write("\n");
      }
      writer.write("   }");
    }
    if (!structure.dynamicFields().isEmpty()) {
      if (!structure.fields().isEmpty()) {
        writer.write(",\n");
      }
      writer.write("   \"" + ElasticSearchMappingsNames.DYNAMIC_TEMPLATES + "\" : [\n");
      Iterator<Map.Entry<String, FieldAttributes>> itr = structure.dynamicFields().entrySet().iterator();
      while (itr.hasNext()) {
        Map.Entry<String, FieldAttributes> field = itr.next();
        writeDynamicTemplate(field.getKey(), field.getValue(), writer);
        if (itr.hasNext()) {
          writer.write(",");
        }
        writer.write("\n");
      }
      writer.write("   ]\n");
    } else {
      writer.write("\n");
    }
    writer.write("  }\n");
    writer.write(" }\n");
    writer.write("}");
  }

  /**
   * Writes dynamic template for a field.
   * 
   * @param name
   *          name of the field
   * @param attr
   *          field attributes
   * @param writer
   *          writer to write to
   * @throws IOException
   *           thrown when I/O error occurs
   */
  private void writeDynamicTemplate(String name, FieldAttributes attr, Writer writer) throws IOException {
    writer.write("    {\n");
    writer.write("     \"" + ElasticSearchMappingsNames.TEMPLATE + "" + name.replaceAll("\\*", "") + "\" : {\n");
    writer.write("      \"" + ElasticSearchMappingsNames.MATCH + "\" : \"" + name + "\",\n");
    writer.write("      \"" + ElasticSearchMappingsNames.MATCH_MAPPING_TYPE + "\" : \"" + Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, attr.getFieldType()) + "\",\n");
    writer.write("  ");
    writeField(ElasticSearchMappingsNames.MAPPING, attr, writer);
    writer.write("\n");
    writer.write("     }\n");
    writer.write("    }");
  }

  /**
   * Writes field.
   * 
   * @param name
   *          name of the field
   * @param attr
   *          field attributes
   * @param writer
   *          writer to write to
   * @throws IOException
   *           thrown when I/O error occurs
   */
  private void writeField(String name, FieldAttributes attr, Writer writer) throws IOException {
    writer.write("    \"");
    writer.write(name);
    writer.write("\" : { \"" + ElasticSearchMappingsNames.TYPE + "\" : \"");
    writer.write(Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, attr.getFieldType()));
    writer.write("\", \"" + ElasticSearchMappingsNames.STORE + "\" : \"");
    writer.write(attr.store() ? "yes" : "no");
    writer.write("\", \"" + ElasticSearchMappingsNames.INDEX + "\" : \"");
    if (attr.indexed()) {
      writer.write(attr.analyzed() ? Analyzed.ANALYZED.toString().toLowerCase() : Analyzed.NOT_ANALYZED.toString().toLowerCase());
    } else {
      writer.write(Analyzed.NO.toString().toLowerCase());
    }
    writer.write("\"");
    if (attr.omitNorms()) {
      writer.write(", \"" + ElasticSearchMappingsNames.OMIT_NORMS + "\" : \"yes\"" );
    }
    if (attr.omitTermFrequencyAndPositions()) {
      writer.write(", \"" + ElasticSearchMappingsNames.OMIT_FREQ_AND_POSITIONS + "\" : \"yes\"" );
    }
    if (attr.boost() != 1.0f) {
      writer.write(", \"" + ElasticSearchMappingsNames.BOOST + "\" : \"" + attr.boost() + "\"" );
    }
    writer.write(" }");
  }
}
