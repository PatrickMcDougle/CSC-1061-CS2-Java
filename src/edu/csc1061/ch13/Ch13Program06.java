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

public class Ch13Program06 {

    public static void main(String[] args) {
        RectangleComparable[] rectangles =
                {new RectangleComparable(3.4, 5.4), new RectangleComparable(13.24, 55.4),
                        new RectangleComparable(7.4, 35.4), new RectangleComparable(1.4, 25.4),};

        java.util.Arrays.sort(rectangles);

        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
