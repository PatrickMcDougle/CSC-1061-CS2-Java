/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

/** Declaring, throwing, and catching exceptions with the Circle class. */
public class Ch12Program06 {

  public static void main(String[] args) {
    CircleExceptionExample01 c1 = new CircleExceptionExample01(1.0);
    CircleExceptionExample01 c2 = new CircleExceptionExample01(2.0);
    CircleExceptionExample01 c3 = new CircleExceptionExample01(3.0);

    try {
      c1.setRadius(11.0);
      c2.setRadius(-22.0);
      c3.setRadius(-33.0);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex);
    }

    System.out.println("# of objects created: " + CircleExceptionExample01.getNumberOfObjects());

    System.out.println("C1's radius: " + c1.getRadius());
    System.out.println("C2's radius: " + c2.getRadius());
    System.out.println("C3's radius: " + c3.getRadius());
  }
}
