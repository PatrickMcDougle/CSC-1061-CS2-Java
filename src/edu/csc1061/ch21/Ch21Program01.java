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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// hello test branch
/// Testing Hash Sets
public class Ch21Program01 {

  public static void main(String[] args) {
    Ch21Program01 program = new Ch21Program01();

    Set<String> set;
    // set = program.getHashSet()
    set = program.getLinkedHashSet();

    System.out.print(set);
    System.out.println();

    // Display the elements in the hash set
    for (String s : set) {
      System.out.print(s.toUpperCase() + ", ");
    }
    System.out.println();

    // Process the elements using a forEach method
    set.forEach(e -> System.out.print(e.toLowerCase() + ", "));
    System.out.println();
  }

  public Set<String> getHashSet() {
    // Create a hash set
    Set<String> set = new HashSet<>();

    // Add strings to the set
    set.add("Denver");
    set.add("Boulder");
    set.add("Loveland");
    set.add("Greeley");
    set.add("Colorado Springs");
    set.add("Fort Collins");
    set.add("Littleton");
    set.add("Castle Rock");
    set.add("Avon");
    set.add(" ++ Hash Set ++");

    return set;
  }

  public Set<String> getLinkedHashSet() {
    // Create a linked hash set
    Set<String> set = new LinkedHashSet<>();

    // Add strings to the set
    set.add("Denver");
    set.add("Boulder");
    set.add("Loveland");
    set.add("Greeley");
    set.add("Colorado Springs");
    set.add("Fort Collins");
    set.add("Littleton");
    set.add("Castle Rock");
    set.add("Avon");
    set.add(" ++ Linked Hash Set ++");

    return set;
  }
}
