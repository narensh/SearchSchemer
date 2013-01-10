package com.sematext.searchschemer.type.analysis.solr;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.sematext.searchschemer.type.analysis.Analyzer;
import com.sematext.searchschemer.type.analysis.AnalyzerType;
import com.sematext.searchschemer.type.analysis.CharFilter;
import com.sematext.searchschemer.type.analysis.Filter;
import com.sematext.searchschemer.type.analysis.Tokenizer;
import com.sematext.searchschemer.type.analysis.util.StringUtilities;

/**
 * Implementation of {@link Analyzer} for Apache Solr.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class SolrAnalyzer implements Analyzer {
  private AnalyzerType type;
  private List<CharFilter> charFilters;
  private List<Filter> filters;
  private Tokenizer tokenizer;

  /**
   * Constructor.
   * 
   * @param type
   *          analyzer type
   */
  public SolrAnalyzer(AnalyzerType type) {
    this.type = type;
    charFilters = new ArrayList<CharFilter>();
    filters = new ArrayList<Filter>();
  }

  /**
   * Adds filter.
   * 
   * @param filter
   *          filter
   */
  public void addFilter(Filter filter) {
    filters.add(filter);
  }

  /**
   * Adds char filter.
   * 
   * @param charFilter
   *          char filter
   */
  public void addFilter(CharFilter charFilter) {
    charFilters.add(charFilter);
  }

  public void setTokenizer(Tokenizer tokenizer) {
    this.tokenizer = tokenizer;
  }

  public AnalyzerType getType() {
    return type;
  }

  public List<CharFilter> getCharFilters() {
    return charFilters;
  }

  public List<Filter> getFilters() {
    return filters;
  }

  public Tokenizer getTokenizer() {
    return tokenizer;
  }

  /**
   * (non-Javadoc)
   * 
   * @see com.sematext.searchschemer.type.Writable#writableForm()
   */
  @Override
  public String writableForm() {
    StringWriter writer = new StringWriter();
    // start
    writer.write("<analyzer");
    // process type
    switch (type) {
      case INDEX:
        writer.write(" type=\"index\">");
        break;
      case QUERY:
        writer.write(" type=\"query\">");
        break;
      default:
        writer.write(">");
    }
    writer.write("\n");
    // process char filters
    StringUtilities.processWritableList(writer, charFilters);
    // process tokenizer
    writer.write(tokenizer.writableForm());
    writer.write("\n");
    // process filters
    StringUtilities.processWritableList(writer, filters);
    // close analyzer
    writer.write("</analyzer>");
    writer.write("\n");
    return writer.toString();
  }
}
