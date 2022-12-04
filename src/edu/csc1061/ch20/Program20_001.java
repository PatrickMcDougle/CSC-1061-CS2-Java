package edu.csc1061.ch20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Testing Collection
public class Program20_001 {

  public static void main(String[] args) {
    ArrayList<String> citiesInColorado = new ArrayList<>();
    citiesInColorado.add("Denver");
    citiesInColorado.add("Boulder");
    citiesInColorado.add("Loveland");
    citiesInColorado.add("Johnstown");
    citiesInColorado.add("Greeley");
    citiesInColorado.add("Colorado Springs");
    citiesInColorado.add("Fort Collins");
    citiesInColorado.add("Littleton");
    citiesInColorado.add("Castle Rock");
    citiesInColorado.add("Avon"); // Add "Avon" to collection1

    System.out.println("A list of cities in Colorado:");
    System.out.println(citiesInColorado);

    System.out.println(
      "\nIs Loveland in Colorado? " + citiesInColorado.contains("Loveland")
    );

    citiesInColorado.remove("Loveland");
    System.out.println(
      "\n" + citiesInColorado.size() + " cities are in Colorado now"
    );

    Collection<String> citiesLivedIn = new ArrayList<>();
    citiesLivedIn.add("Keene");
    citiesLivedIn.add("Trona");
    citiesLivedIn.add("Sandy");
    citiesLivedIn.add("New Orleans");
    citiesLivedIn.add("Las Cruces");
    citiesLivedIn.add("Orlando");
    citiesLivedIn.add("Greenville");
    citiesLivedIn.add("Fate");
    citiesLivedIn.add("Rockwall");
    citiesLivedIn.add("Greeley");
    citiesLivedIn.add("Johnstown");
    citiesLivedIn.add("Littleton");

    System.out.println("\nA list of cities I have lived in:");
    System.out.println(citiesLivedIn);

    ArrayList<String> c1 = (ArrayList<String>) citiesInColorado.clone();
    c1.addAll(citiesLivedIn); // Add all elements in citiesLivedIn to c1
    System.out.println("\nCities in Colorado or I have lived in: ");
    System.out.println(c1);

    c1 = (ArrayList<String>) citiesInColorado.clone();
    c1.retainAll(citiesLivedIn);
    System.out.print("\nCities in Colorado and I have lived in: ");
    System.out.println(c1);

    try {
      c1 = (ArrayList<String>) citiesInColorado.clone();
    } catch (ClassCastException ex) {
      System.err.println(ex);
    }

    c1.removeAll(citiesLivedIn);
    System.out.print("\nCities in Colorado, but not where I have lived: ");
    System.out.println(c1);

    // iterator example
    System.out.print("\n| ");
    Iterator<String> iterator = citiesInColorado.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next().toUpperCase() + " | ");
    }

    System.out.print("\n| ");
    iterator = citiesLivedIn.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next().toLowerCase() + " | ");
    }
    System.out.println();

    // foreach method loop
    System.out.print("\n| ");
    citiesInColorado.forEach(e -> System.out.print(e.toUpperCase() + " | "));
  }
}
