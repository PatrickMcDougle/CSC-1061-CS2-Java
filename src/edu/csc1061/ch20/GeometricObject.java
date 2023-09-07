/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch20;

import java.util.Date;
import javafx.scene.paint.Color;

/**
 * The class GeometricObject is an abstract class that all geometric objects
 * extend from. This class provides basic functionality for all classes that
 * inherent from it.
 *
 * <img src="../doc-files/GeometricObject-1.png">
 */
public abstract class GeometricObject {
  private Color color = Color.WHITE;
  private double pX = 0.0;
  private double pY = 0.0;
  private Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new Date();
  }

  protected GeometricObject(double x, double y) {
    pX = x;
    pY = y;
  }

  /**
   * This method returns the geometric object's color.
   *
   * @return a {@link Color} that represents the color of this object.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets a new color
   *
   * @param color a {@link Color} that represents the color of this object.
   */
  public void setColor(Color color) {
    this.color = color;
  }

  public double getCenterX() {
    return pX;
  }

  public double getCenterY() {
    return pY;
  }

  public void setCenterX(double x) {
    pX = x;
  }

  public void setCenterY(double y) {
    pY = y;
  }

  /**
   * Gets the date of when this object was created
   *
   * @return a Date class that represents the creation time and date of this
   *         object.
   */
  public Date getDateCreated() {
    return dateCreated;
  }

  /**
   * Returns a string representation of this object
   *
   * @return a string that represents the
   */
  @Override
  public String toString() {
    return ("[created: " + dateCreated + "] [color: " + color + "] [filled: " + filled + "]");
  }

  /**
   * An abstract method that gets the area of this object.
   *
   * @return a double value that represents this geometric object's area.
   */
  public abstract double getArea();

  /**
   * An abstract method that gets the perimeter of this object.
   *
   * @return a double value that represents this geometric object's perimeter.
   */
  public abstract double getPerimeter();
}
