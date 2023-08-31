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
 * Circle Exception Example
 */
public class Ch12Program06Cee {

  public static void main(String[] args) {
    try {
      CircleExceptionExample01 c1 = new CircleExceptionExample01(5.0);
      CircleExceptionExample01 c2 = new CircleExceptionExample01(15.0);
      CircleExceptionExample01 c3 = new CircleExceptionExample01(0.0);

      c1.setRadius(15.0);
      c2.setRadius(-15.0);
      c3.setRadius(10.0);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex);
    }

    System.out.println("Number of objects created: " + CircleExceptionExample01.getNumberOfObjects());
  }
}
