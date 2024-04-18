/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch21;

import java.util.Set;
import java.util.TreeSet;

// main branch chabge
/// Testing Tree Sets
public class Ch21Program02 {

  public static void main(String[] args) {
    Ch21Program01 program = new Ch21Program01();

    Set<String> set;
    set = program.getHashSet();

    TreeSet<String> treeSet = new TreeSet<>(set);

    System.out.println("Original set          : " + set);
    System.out.println("Sorted tree set       : " + treeSet);

    // Use the methods in SortedSet interface
    System.out.println("first()               : " + treeSet.first());
    System.out.println("last()                : " + treeSet.last());
    System.out.println("headSet(\"Castle Rock\"): " + treeSet.headSet("Castle Rock"));
    System.out.println("tailSet(\"Castle Rock\"): " + treeSet.tailSet("Castle Rock"));

    // Use the methods in NavigableSet interface
    System.out.println("lower(\"F\")            : " + treeSet.lower("F"));
    System.out.println("higher(\"F\")           : " + treeSet.higher("F"));
    System.out.println("floor(\"F\")            : " + treeSet.floor("F"));
    System.out.println("ceiling(\"F\")          : " + treeSet.ceiling("F"));
    System.out.println("pollFirst()           : " + treeSet.pollFirst());
    System.out.println("pollLast()            : " + treeSet.pollLast());
    System.out.println("New tree set          : " + treeSet);
  }
}
