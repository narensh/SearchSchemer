package com.sematext.searchschemer.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.type.Mapper;

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
    writer.write(" \"mappings\" : {\n");
    writer.write("  \"type\" : {\n");
    if (!structure.fields().isEmpty()) {
      writer.write("   \"properties\" : {\n");
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
      writer.write("   \"dynamic_templates\" : [\n");
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
    writer.write("     \"template_" + name.replaceAll("\\*", "") + "\" : {\n");
    writer.write("      \"match\" : \"" + name + "\",\n");
    writer.write("      \"match_mapping_type\" : \"" + Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, attr.getFieldType()) + "\",\n");
    writer.write("  ");
    writeField("mapping", attr, writer);
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
    writer.write("\" : { \"type\" : \"");
    writer.write(Mapper.getTypeName(ConfigurationType.ELASTICSEARCH, attr.getFieldType()));
    writer.write("\", \"store\" : \"");
    writer.write(attr.getStored() ? "yes" : "no");
    writer.write("\", \"index\" : \"");
    if (attr.getIndexed()) {
      writer.write(attr.isAnalyzed() ? "analyzed" : "not_analyzed");
    } else {
      writer.write("no");
    }
    writer.write("\" }");
  }
}
