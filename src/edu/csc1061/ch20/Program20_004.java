package edu.csc1061.ch20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program20_004 {

  public static void main(String[] args) {
    System.out.println("\n ========== ========== ========== ");
    SortStringByLength();
    System.out.println("\n ---------- ---------- ---------- ");
    SortStringIgnoreCase();
    System.out.println("\n ========== ========== ========== ");
  }

  public static void SortStringByLength() {
    String[] cities = {
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

    // using Comparator concrete class.
    Arrays.sort(cities, new LengthComparator());

    for (String s : cities) {
      System.out.print(s + " | ");
    }
  }

  private static void SortStringIgnoreCase() {
    List<String> cities = Arrays.asList(
      "Las Cruces",
      "Orlando",
      "Keene",
      "Trona",
      "Sandy",
      "Littleton",
      "Greeley",
      "Rockwall",
      "New Orleans"
    );

    // using lambda function.
    cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    //cities.sort(new LengthComparator());
    //cities.sort((s1, s2) -> s1.length() - s2.length());

    cities.forEach(city -> System.out.print(city + " | "));
  }

  public static class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
      return s1.length() - s2.length();
    }
  }
}
