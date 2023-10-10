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

import java.util.Comparator;

public class Ch20Program03 {

  private GeometricObject g1;
  private GeometricObject g2;
  private GeometricObject largest;
  private String output;

  public static void main(String[] args) {
    Ch20Program03 program = new Ch20Program03();
    program.compareGeometricObjects();
  }

  public void compareGeometricObjects() {
    g1 = new Rectangle(5, 5);
    g2 = new Circle(5);
    largest = max(g1, g2, new GeometricObjectComparator());
    output = String.format("The largest object's Area is %f = %s ", largest.getArea(), largest);
    System.out.println(output);

    g1 = new Circle(4);
    g2 = new Rectangle(4, 12.75);
    largest = max(g1, g2, new GeometricObjectComparator());
    output = String.format("The largest object's Area is %f = %s ", largest.getArea(), largest);
    System.out.println(output);
  }

  public GeometricObject max(
      GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c) {
    return c.compare(g1, g2) > 0 ? g1 : g2;
  }
}
