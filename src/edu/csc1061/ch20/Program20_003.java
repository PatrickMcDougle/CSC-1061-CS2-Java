package edu.csc1061.ch20;

import java.util.Comparator;

public class Program20_003 {

  public static void main(String[] args) {
    GeometricObject g1 = new Rectangle(5, 5);
    GeometricObject g2 = new Circle(5);

    GeometricObject g = max(g1, g2, new GeometricObjectComparator());

    System.out.println("The area of the larger object is " + g.getArea());
  }

  public static GeometricObject max(
    GeometricObject g1,
    GeometricObject g2,
    Comparator<GeometricObject> c
  ) {
    return c.compare(g1, g2) > 0 ? g1 : g2;
  }
}
