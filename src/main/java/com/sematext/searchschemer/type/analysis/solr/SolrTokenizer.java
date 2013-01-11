package com.sematext.searchschemer.type.analysis.solr;

import java.io.StringWriter;

import com.sematext.searchschemer.common.Constants;
import com.sematext.searchschemer.type.analysis.Tokenizer;
import com.sematext.searchschemer.type.analysis.util.StringUtilities;

/**
 * Class representing Solr tokenizer.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class SolrTokenizer extends AbstractSolrFieldTypeElement implements Tokenizer {
  /**
   * Constructor.
   * 
   * @param className
   *          class name
   */
  protected SolrTokenizer(String className) {
    super("", className);
  }

  /**
   * (non-Javadoc)
   * 
   * @see com.sematext.searchschemer.type.Writable#writableForm()
   */
  @Override
  public String writableForm() {
    StringWriter writer = new StringWriter();
    writer.write("<tokenizer class=\"");
    writer.write(getClassName());
    writer.write("\" ");
    if (!getAttributes().isEmpty()) {
      StringUtilities.processWritableList(writer, getAttributes(), Constants.SPACE_CHARACTER);
    }
    writer.write(">");
    return writer.toString();
  }
}
