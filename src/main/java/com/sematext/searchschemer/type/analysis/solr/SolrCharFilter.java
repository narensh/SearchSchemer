package com.sematext.searchschemer.type.analysis.solr;

import java.io.StringWriter;

import com.sematext.searchschemer.common.Constants;
import com.sematext.searchschemer.type.analysis.CharFilter;
import com.sematext.searchschemer.type.analysis.util.StringUtilities;

/**
 * Class representing Solr char filter.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class SolrCharFilter extends AbstractSolrFieldTypeElement implements CharFilter {
  /**
   * Constructor.
   * 
   * @param className
   *          implementing class
   */
  protected SolrCharFilter(String className) {
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
    writer.write("<charFilter class=\"");
    writer.write(getClassName());
    writer.write("\" ");
    if (!getAttributes().isEmpty()) {
      StringUtilities.processWritableList(writer, getAttributes(), Constants.SPACE_CHARACTER);
    }
    writer.write(">");
    return writer.toString();
  }
}
