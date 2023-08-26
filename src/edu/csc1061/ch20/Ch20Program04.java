/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch20;

import java.util.Arrays;
import java.util.List;

public class Ch20Program04 {

  public static void main(String[] args) {
    System.out.println("\n ========== ========== ========== ");
    sortStringByLength();
    System.out.println("\n ---------- ---------- ---------- ");
    sortStringIgnoreCase();
    System.out.println("\n ========== ========== ========== ");
  }

  public static void sortStringByLength() {
    String[] cities = { "Las Cruces", "Orlando", "Keene", "Trona", "Sandy", "Littleton", "Greeley",
        "Rockwall", "New Orleans", };

    // using Comparator concrete class.
    Arrays.sort(cities, new LengthComparator());

    for (String s : cities) {
      System.out.print(s + " | ");
    }
  }

  private static void sortStringIgnoreCase() {
    List<String> cities = Arrays.asList("Las Cruces", "Orlando", "Keene", "Trona", "Sandy",
        "Littleton", "Greeley", "Rockwall", "New Orleans");

    // using lambda function.
    cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    // cities.sort(String::compareToIgnoreCase)
    // cities.sort(new LengthComparator())
    // cities.sort((s1, s2) -> s1.length() - s2.length())

    cities.forEach(city -> System.out.print(city + " | "));
  }
}
