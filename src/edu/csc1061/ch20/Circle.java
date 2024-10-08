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
package edu.csc1061.ch20;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Return area */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    /** Return perimeter */
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println(
                "The circle is created " + getDateCreated() + " and the radius is " + radius);
    }

    /** Override the toString method defined in GeometricObject */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.insert(0, "Circle: { ");
        sb.append(" [radius: ");
        sb.append(radius);
        sb.append("] }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            return radius == ((Circle) o).radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 31;
        hash = prime * hash + (int) radius;
        return hash;
    }
}
