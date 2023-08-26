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

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Ball extends Circle {
    double dx = 1;
    double dy = 1;

    Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setFill(color); // Set ball color
    }
}
