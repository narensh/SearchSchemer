package com.sematext.searchschemer.type;

/**
 * Interface for classes that hold information that can be written into file.
 * 
 * @author sematext, http://www.sematext.com/
 */
public interface Writable {
  /**
   * Returns writable form of the information.
   * 
   * @return writable form of the information
   */
  String writableForm();
}
