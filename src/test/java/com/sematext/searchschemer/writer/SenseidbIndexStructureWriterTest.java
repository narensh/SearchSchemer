package com.sematext.searchschemer.writer;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.junit.Test;

import com.sematext.searchschemer.index.BasicIndexStructure;
import com.sematext.searchschemer.index.IndexStructure;
import com.sematext.searchschemer.index.sensidb.SenseiDBFieldAttributes;

public class SenseidbIndexStructureWriterTest extends TestCase {
  @Test
  public void testWriteNonDynamic() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new SenseiDBFieldAttributes("cat", "string", "analyzed", "yes"), false);

    StringWriter writer = new StringWriter();
    SenseidbIndexStructureWriter senseiIndexStructureWriter = new SenseidbIndexStructureWriter();
    senseiIndexStructureWriter.write(structure, writer);

    assertEquals("Single column table write test",
        "<table uid=\"id\">\n <column name=\"cat\" type=\"string\" />\n</table>", writer.toString());
  }

  @Test
  public void testWriteNonDynamicMultiple() throws Exception {
    IndexStructure structure = new BasicIndexStructure();
    structure.addField("cat", new SenseiDBFieldAttributes("cat", "string", "analyzed", "yes"), false);
    structure.addField("menu", new SenseiDBFieldAttributes("menu", "string", "no", "yes"), false);

    StringWriter writer = new StringWriter();
    SenseidbIndexStructureWriter senseiIndexStructureWriter = new SenseidbIndexStructureWriter();
    senseiIndexStructureWriter.write(structure, writer);

    assertEquals(
        "Single column table write test",
        "<table uid=\"id\">\n <column name=\"cat\" type=\"string\" />\n <column name=\"menu\" type=\"string\" />\n</table>",
        writer.toString());
  }
}
