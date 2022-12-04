package edu.csc1061.ch12;

public class InvalidRadiusException extends Exception {
  private static final long serialVersionUID = 1L;
  private final double radius;

  /** Construct an exception */
  public InvalidRadiusException(double radius) {
    super("Invalid radius " + radius);
    this.radius = radius;
  }

  /** Return the radius */
  public double getRadius() {
    return radius;
  }
}
