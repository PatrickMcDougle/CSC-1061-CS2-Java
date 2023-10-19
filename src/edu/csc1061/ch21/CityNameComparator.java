/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch21;

import java.io.Serializable;
import java.util.Comparator;

public class CityNameComparator implements Comparator<String>, Serializable {
  /** Auto Generated Serial Version UID */
  private static final long serialVersionUID = -4040746206618335223L;

  public int compare(String o1, String o2) {
    // return o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
    return o1.length() - o2.length();
  }
}
