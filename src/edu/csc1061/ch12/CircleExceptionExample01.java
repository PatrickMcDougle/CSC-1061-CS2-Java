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
package edu.csc1061.ch12;

public class CircleExceptionExample01 {
    /** The radius of the circle */
    private double radius;

    /** The number of the objects created */
    private static int numberOfObjects = 0;

    /** Construct a circle with radius 1 */
    public CircleExceptionExample01() {
        this(1.0);
    }

    /** Construct a circle with a specified radius */
    public CircleExceptionExample01(double newRadius) {
        setRadius(newRadius);
        numberOfObjects++;
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /**
     * Set a new radius
     *
     * @param newRadius is a positive floating point value that represents the new or changed radius
     *        value of the circle.
     * @throws IllegalArgumentException is thrown when the new floating point radius value is not
     *         positive.
     */
    public void setRadius(double newRadius) throws IllegalArgumentException {
        if (newRadius >= 0) {
            radius = newRadius;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    /** Return numberOfObjects */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** Return the area of this circle */
    public double findArea() {
        return radius * radius * 3.14159;
    }
}
