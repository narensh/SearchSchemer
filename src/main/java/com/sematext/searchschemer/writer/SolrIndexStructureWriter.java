package com.sematext.searchschemer.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.type.Mapper;

/**
 * Implementation of {@link IndexStructureWriter} for Apache Solr.
 * 
 * @author Sematext
 * 
 */
public class SolrIndexStructureWriter extends AbstractIndexStructureWriter {
  protected SolrIndexStructureWriter() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void write(IndexStructure structure, Writer writer) throws IOException {
    if (!structure.fields().isEmpty()) {
      for (Map.Entry<String, FieldAttributes> field : structure.fields().entrySet()) {
        writeField("<field", field.getKey(), field.getValue(), writer);
      }
    }
    if (!structure.dynamicFields().isEmpty()) {
      for (Map.Entry<String, FieldAttributes> field : structure.dynamicFields().entrySet()) {
        writeField("<dynamicField", field.getKey(), field.getValue(), writer);
      }
    }
  }

  /**
   * Writes a single schema field.
   * 
   * @param prefix
   *          prefix for a given field
   * @param fieldName
   *          name of the field
   * @param attr
   *          field attributes
   * @param writer
   *          writer to write to
   * @throws IOException
   *           thrown when I/O error occurs
   */
  protected void writeField(String prefix, String fieldName, FieldAttributes attr, Writer writer) throws IOException {
    writer.write(prefix);
    writer.write(" name=\"");
    writer.write(fieldName);
    writer.write("\" type=\"");
    writer.write(Mapper.getTypeName(ConfigurationType.SOLR, attr.getFieldType()));
    writer.write("\" indexed=\"");
    writer.write(attr.getIndexed().toString().toLowerCase());
    writer.write("\" stored=\"");
    writer.write(attr.getStored().toString().toLowerCase());
    writer.write("\"");
    if (attr.getMultiValued()) {
      writer.write(" multiValued=\"true\"");
    }
    writer.write(" />\n");
  }
}
