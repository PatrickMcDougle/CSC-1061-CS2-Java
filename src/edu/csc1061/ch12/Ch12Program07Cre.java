/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch12;

/**
 * Circle Radius Exception
 */
public class Ch12Program07Cre {

  /** Main method */
  public static void main(String[] args) {
    try {
      CircleExceptionExample02 c1 = new CircleExceptionExample02(5);
      c1.setRadius(-5);
      CircleExceptionExample02 c3 = new CircleExceptionExample02(0);
      c3.setRadius(10);
    } catch (InvalidRadiusException ex) {
      System.out.println(ex);
    }

    System.out.println("Number of objects created: " + CircleExceptionExample02.getNumberOfObjects());
  }
}
