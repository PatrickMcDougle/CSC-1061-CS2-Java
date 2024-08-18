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

public class CircleExceptionExample02 {
    /** The radius of the circle */
    private double radius;

    /** The number of the objects created */
    private static int numberOfObjects = 0;

    /** Construct a circle with radius 1 */
    public CircleExceptionExample02() {
        this(1.0);
    }

    /** Construct a circle with a specified radius */
    public CircleExceptionExample02(double newRadius) {
        try {
            setRadius(newRadius);
            numberOfObjects++;
        } catch (InvalidRadiusException ex) {
            ex.printStackTrace();
        }
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
     * @throws InvalidRadiusException is thrown when the new floating point radius value is not
     *         positive.
     */
    public void setRadius(double newRadius) throws InvalidRadiusException {
        assert false : "Hello World";
        if (newRadius >= 0) {
            radius = newRadius;
        } else {
            throw new InvalidRadiusException(newRadius);
        }
    }

    /** Return numberOfObjects */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** Return the area of this circle */
    public double findArea() {
        return radius * radius * Math.PI;
    }
}
