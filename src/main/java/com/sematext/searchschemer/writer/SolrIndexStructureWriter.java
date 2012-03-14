package com.sematext.searchschemer.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.type.Mapper;
import com.sematext.searchschemer.type.solr.SolrSchemaNames;

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
        writeField("<" + SolrSchemaNames.FIELD, field.getKey(), field.getValue(), writer);
      }
    }
    if (!structure.dynamicFields().isEmpty()) {
      for (Map.Entry<String, FieldAttributes> field : structure.dynamicFields().entrySet()) {
        writeField("<" + SolrSchemaNames.DYNAMIC_FIELD, field.getKey(), field.getValue(), writer);
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
    writer.write(" " + SolrSchemaNames.NAME + "=\"");
    writer.write(fieldName);
    writer.write("\" " + SolrSchemaNames.TYPE + "=\"");
    writer.write(Mapper.getTypeName(ConfigurationType.SOLR, attr.fieldType()));
    writer.write("\" " + SolrSchemaNames.INDEXED + "=\"");
    writer.write(attr.indexed().toString().toLowerCase());
    writer.write("\" " + SolrSchemaNames.STORED + "=\"");
    writer.write(attr.store().toString().toLowerCase());
    writer.write("\"");
    if (attr.multiValued()) {
      writer.write(" " + SolrSchemaNames.MULTIVALUED + "=\"true\"");
    }
    if (attr.omitNorms()) {
      writer.write(" " + SolrSchemaNames.OMIT_NORMS + "=\"true\"");
    }
    if (attr.omitTermFrequencyAndPositions()) {
      writer.write(" " + SolrSchemaNames.OMIT_TERM_FREQUENCY_AND_POSITIONS + "=\"true\"");
    }
    if (attr.boost() != 1.0f) {
      writer.write(" " + SolrSchemaNames.BOOST + "=\"");
      writer.write("" + attr.boost());
      writer.write("\"");
    }
    writer.write(" />\n");
  }
}
