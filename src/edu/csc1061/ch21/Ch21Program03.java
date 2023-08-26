/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch21;

import java.util.Set;
import java.util.TreeSet;

/// Testing Tree Set With Comparator
public class Ch21Program03 {

  public static void main(String[] args) {
    Ch21Program01 program = new Ch21Program01();

    Set<String> set;
    set = program.getHashSet();

    TreeSet<String> treeSet = new TreeSet<>(new CityNameComparator());
    treeSet.addAll(set);

    // Display geometric objects in the tree set
    System.out.println("A sorted set of City Names");
    treeSet.forEach(cityName -> System.out.print(cityName + ", "));
    System.out.println();
  }
}
