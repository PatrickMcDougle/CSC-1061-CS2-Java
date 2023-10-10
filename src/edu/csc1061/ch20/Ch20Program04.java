/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
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
    String[] cities = getCities();

    // using Comparator concrete class.
    Arrays.sort(cities, new LengthComparator());

    for (String s : cities) {
      System.out.print(s + " | ");
    }
  }

  protected static String[] getCities() {
    return new String[] {
      "Las Cruces",
      "Orlando",
      "Keene",
      "Trona",
      "Sandy",
      "Littleton",
      "Greeley",
      "Rockwall",
      "New Orleans",
    };
  }

  private static void sortStringIgnoreCase() {
    List<String> cities = Arrays.asList(getCities());

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp
    cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    // cities.sort(String::compareToIgnoreCase)
    // cities.sort(new LengthComparator())
    // cities.sort((s1, s2) -> s1.length() - s2.length())

    cities.forEach(city -> System.out.print(city + " | "));
  }
}
