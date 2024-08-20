/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch09;

public class Ch09Program01 {

    // Main method
    public static void main(String[] args) {
        // Create a circle with radius 1
        Circle1 circle1 = new Circle1();
        System.out.println("The area of circle 1 with a radius " + circle1.getRadius() + " is "
                + circle1.getArea());

        // Create a circle with radius 25
        Circle1 circle2 = new Circle1(25);
        System.out.println("The area of circle 2 with a radius " + circle2.radius + " is "
                + circle2.getArea());

        // Create a circle with radius 125
        Circle1 circle3 = new Circle1(125);
        System.out.println("The area of circle 3 with a radius " + circle3.radius + " is "
                + circle3.getArea());

        // Modify circle radius
        circle2.setRadius(100);
        System.out.println("The area of circle 2 is " + circle2.getArea());
        System.out.println("The perimeter of circle 2 is " + circle2.getPerimeter());
    }
}
