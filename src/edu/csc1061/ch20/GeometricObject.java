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

public abstract class GeometricObject {
  private Color pColor = Color.WHITE;
  private double pX = 0.0;
  private double pY = 0.0;
  private Date pDateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    pDateCreated = new Date();
  }

  protected GeometricObject(double x, double y) {
    pX = x;
    pY = y;
  }

  /** Abstract method getArea */
  public abstract double getArea();

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

  /** Return color */
  public Color getColor() {
    return pColor;
  }

  /** Get dateCreated */
  public Date getDateCreated() {
    return pDateCreated;
  }

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();

  /** Set a new color */
  public void setColor(Color color) {
    pColor = color;
  }

  @Override
  public String toString() {
    return "created on " + pDateCreated + "\ncolor: " + pColor;
  }
}
