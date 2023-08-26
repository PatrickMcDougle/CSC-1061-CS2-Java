/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch09;

public class Ch09Circle1 {
  // the radius of this circle
  public double radius;

  // Construct a circle with radius 1
  public Ch09Circle1() {
    radius = 1;
  }

  // Construct a circle with a specified radius
  public Ch09Circle1(double newRadius) {
    radius = newRadius;
  }

  // Return the radius of the circle
  public double getRadius() {
    return radius;
  }

  // Return the area of this circle
  // PI * radius^2
  public double getArea() {
    return radius * radius * Math.PI;
  }

  // Return the perimeter (circumference) of this circle
  // PI * radius * 2
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  // Set a new radius for this circle
  public void setRadius(double newRadius) {
    radius = newRadius;
  }
}
