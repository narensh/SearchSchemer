package com.sematext.searchschemer.writer;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.FieldAttributes;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.type.FieldType;

public class SolrIndexStructureWriterTest extends TestCase {
  @Test
  public void testWriteNonDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new FieldAttributes("cat", FieldType.STRING, true, true, false, false), false);

    StringWriter writer = new StringWriter();
    SolrIndexStructureWriter solrIndexStructurWriter = new SolrIndexStructureWriter();
    solrIndexStructurWriter.write(structure, writer);

    assertEquals("<field name=\"cat\" type=\"string\" indexed=\"true\" stored=\"true\" />\n", writer.toString());
    writer.close();
  }

  @Test
  public void testWriteDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("*_int", new FieldAttributes("*_int", FieldType.STRING, false, true, false, false), true);

    StringWriter writer = new StringWriter();
    SolrIndexStructureWriter solrIndexStructurWriter = new SolrIndexStructureWriter();
    solrIndexStructurWriter.write(structure, writer);

    assertEquals("<dynamicField name=\"*_int\" type=\"string\" indexed=\"false\" stored=\"true\" />\n",
        writer.toString());
    writer.close();
  }

  @Test
  public void testWriteMultiple() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new FieldAttributes("cat", FieldType.STRING, true, true, false, false), false);
    structure.addField("menu", new FieldAttributes("menu", FieldType.STRING, false, true, false, false), false);

    StringWriter writer = new StringWriter();
    SolrIndexStructureWriter solrIndexStructurWriter = new SolrIndexStructureWriter();
    solrIndexStructurWriter.write(structure, writer);

    assertEquals(
        "<field name=\"cat\" type=\"string\" indexed=\"true\" stored=\"true\" />\n<field name=\"menu\" type=\"string\" indexed=\"false\" stored=\"true\" />\n",
        writer.toString());
    writer.close();
  }

  @Test
  public void testWriteMultivalued() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new FieldAttributes("cat", FieldType.STRING, true, true, false, true), false);

    StringWriter writer = new StringWriter();
    SolrIndexStructureWriter solrIndexStructurWriter = new SolrIndexStructureWriter();
    solrIndexStructurWriter.write(structure, writer);

    assertEquals("<field name=\"cat\" type=\"string\" indexed=\"true\" stored=\"true\" multiValued=\"true\" />\n",
        writer.toString());
    writer.close();
  }
}
