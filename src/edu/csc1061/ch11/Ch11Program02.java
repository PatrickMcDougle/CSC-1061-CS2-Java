/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch11;

/**
 * Polymorphism
 */
public class Ch11Program02 {

  /** Main method */
  public static void main(String[] args) {
    // Display circle and rectangle properties
    displayObject(new Circle(1, "red", false));
    displayObject(new Rectangle(1, 1, "black", true));
  }

  /** Display geometric object properties */
  public static void displayObject(GeometricObject object) {
    System.out.println("Created on " + object.getDateCreated() + ". Color is " + object.getColor());
    System.out.println(object.toString());
    System.out.println();
  }
}
