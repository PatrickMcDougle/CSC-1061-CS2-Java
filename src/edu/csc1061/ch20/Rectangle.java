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

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  /**
   * This Rectangle class extends from the {@link GeometricObject}
   *
   * @param width this double value represents the width of the rectangle.
   * @param height this double value represents the height of the rectangle.
   */
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  /** Return area */
  @Override
  public double getArea() {
    return width * height;
  }

  /** Return perimeter */
  @Override
  public double getPerimeter() {
    return 2 * (width + height);
  }

  /** Override the toString method defined in GeometricObject */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.insert(0, "Rectangle: { ");
    sb.append(" [dimensions: ");
    sb.append(width);
    sb.append(" x ");
    sb.append(height);
    sb.append("] }");
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Rectangle) {
      Rectangle other = (Rectangle) o;
      return width == other.width && height == other.height;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    int prime = 31;
    hash = prime * hash + (int) width + (int) height;
    return hash;
  }
}
