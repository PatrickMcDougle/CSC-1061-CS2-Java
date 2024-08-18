/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch13;

import java.util.Date;

/**
 * The class GeometricObject is an abstract class that all geometric objects extend from. This class
 * provides basic functionality for all classes that inherent from it.
 *
 * <p>
 * <img src="../doc-files/GeometricObject-1.png">
 */
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new Date();
    }

    /**
     * Construct a geometric object with the specified color and filled value
     *
     * @param color a string that represents the color of the object.
     * @param filled a boolean value that tells the object if it is filled with the color that is
     *        provided.
     */
    protected GeometricObject(String color, boolean filled) {
        super();
        this.color = color;
        this.filled = filled;
    }

    /**
     * This method returns the geometric object's color.
     *
     * @return a string that represents the color of this object.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets a new color
     *
     * @param color a string that represents the color of this object.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Is the object filled with the color?
     *
     * @return a boolean value that represents if this geometric object is filled with the color or
     *         not.
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Sets if the object is filled or not.
     *
     * @param filled is a boolean value that represents if the object will be filled with the color
     *        or not.
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Gets the date of when this object was created
     *
     * @return a Date class that represents the creation time and date of this object.
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
