package com.sematext.searchschemer.type.analysis.util;

import java.io.StringWriter;
import java.util.List;

import com.sematext.searchschemer.type.Writable;

/**
 * Utility classes used for String and buffers manipulations.
 * 
 * @author sematext, http://www.sematext.com/
 */
public class StringUtilities {
  private StringUtilities() {
  }

  /**
   * Writes content of the list to the provided writer.
   * 
   * @param writer
   *          string writer
   * @param writableList
   *          list of {@link Writable} objects
   */
  public static void processWritableList(StringWriter writer, List<? extends Writable> writableList) {
    for (Writable writable : writableList) {
      writer.write(writable.writableForm());
      writer.write("\n");
    }
  }
}
