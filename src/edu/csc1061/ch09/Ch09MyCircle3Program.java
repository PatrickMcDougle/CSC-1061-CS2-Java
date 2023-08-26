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

public class Ch09MyCircle3Program {

    // Main method
    public static void main(String[] args) {
        System.out.println("Before creating objects");
        System.out.println("The number of Circle objects is " + Ch09Circle2.numberOfObjects + " or "
                + Ch09Circle2.getNumberOfObjects());

        // Create c1
        Ch09Circle2 c1 = new Ch09Circle2();

        // Display c1 BEFORE c2 is created
        System.out.println("\nAfter creating c1");
        System.out.println("c1: radius (" + c1.radius + ")");
        System.out.println("c1: # of Circle objects (" + c1.getNumberOfObjects() + ")");

        // Create c2
        Ch09Circle2 c2 = new Ch09Circle2(5);

        // Modify c1
        c1.radius = 9;

        // Display c1 and c2 AFTER c2 was created
        System.out.println("\nAfter creating c2 and modifying c1");
        System.out.println("c1: radius (" + c1.radius + ")");
        System.out.println("c1: # of Circle objects (" + c1.getNumberOfObjects() + ")");
        System.out.println("c2: radius (" + c2.radius + ")");
        System.out.println("c2: # of Circle objects (" + c2.getNumberOfObjects() + ")");
    }
}
