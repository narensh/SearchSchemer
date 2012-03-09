package com.sematext.searchschemer.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.type.Mapper;

/**
 * Implementation of {@link IndexStructureWriter} for SenseiDB.
 * 
 * @author Sematext
 * 
 */
public class SenseidbIndexStructureWriter extends AbstractIndexStructureWriter {
  protected SenseidbIndexStructureWriter() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void write(IndexStructure structure, Writer writer) throws IOException {
    if (!structure.fields().isEmpty()) {
      writer.write("<table uid=\"id\">\n");
      for (Map.Entry<String, FieldAttributes> field : structure.fields().entrySet()) {
        writeField(field.getKey(), field.getValue(), writer);
      }
      writer.write("</table>");
    }
  }

  /**
   * Writes a single schema field.
   * 
   * @param fieldName
   *          name of the field
   * @param attr
   *          field attributes
   * @param writer
   *          writer to write to
   * @throws IOException
   *           thrown when I/O error occurs
   */
  protected void writeField(String fieldName, FieldAttributes attr, Writer writer) throws IOException {
    writer.write(" <column name=\"");
    writer.write(fieldName);
    writer.write("\" type=\"");
    writer.write(Mapper.getTypeName(ConfigurationType.SENSEIDB, attr.getFieldType()));
    writer.write("\" />\n");
  }
}
