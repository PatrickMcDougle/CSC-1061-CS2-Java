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

/** This class is used when an invalid radius is used in a Circle */
public class InvalidRadiusException extends Exception {
  private static final long serialVersionUID = 1L;
  private final double radius;

  /**
   * Construct an exception
   *
   * @param radius is the invalid floating point radius value that is the issue.
   */
  public InvalidRadiusException(double radius) {
    super("Invalid radius " + radius);
    this.radius = radius;
  }

  /** Return the invalid floating point radius value */
  public double getRadius() {
    return radius;
  }
}
