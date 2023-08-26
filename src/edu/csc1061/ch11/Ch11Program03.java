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
 * Casting
 */
public class Ch11Program03 {

  /** Main method */
  public static void main(String[] args) {
    // Create and initialize two objects
    Object object1 = new Circle(1);
    Object object2 = new Rectangle(1, 1);

    // Display circle and rectangle
    displayObject(object1);
    displayObject(object2);
  }

  /** A method for displaying an object */
  public static void displayObject(Object object) {
    if (object instanceof Circle) {
      System.out.println("The circle area is " + ((Circle) object).getArea());
      System.out.println(
          "The circle diameter is " + ((Circle) object).getDiameter());
    } else if (object instanceof Rectangle) {
      System.out.println(
          "The rectangle area is " + ((Rectangle) object).getArea());
    }
  }
}
