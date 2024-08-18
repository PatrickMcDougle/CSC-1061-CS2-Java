/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch13;

public class RectangleComparable extends Rectangle implements Comparable<RectangleComparable> {

    /** Construct a ComparableRectangle with specified properties */
    public RectangleComparable(double width, double height) {
        super(width, height);
    }

    // Implement the compareTo method defined in Comparable
    @Override
    public int compareTo(RectangleComparable o) {
        if (getArea() > o.getArea()) {
            return 1;
        }
        if (getArea() < o.getArea()) {
            return -1;
        }

        return 0;
    }

    // Implement the toString method in GeometricObject
    @Override
    public String toString() {
        return ("Width: " + getWidth() + " Height: " + getHeight() + " Area: " + getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RectangleComparable) {
            RectangleComparable rectangleComparable = (RectangleComparable) obj;
            return (rectangleComparable.getWidth() == this.getWidth()
                    && rectangleComparable.getHeight() == this.getHeight());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
