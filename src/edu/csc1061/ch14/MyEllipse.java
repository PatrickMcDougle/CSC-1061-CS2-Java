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
package edu.csc1061.ch14;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

class MyEllipse extends Pane {

    public static final int TOTAL_ELLIPSE = 16;

    private void paint() {
        getChildren().clear();
        for (int i = 0; i < TOTAL_ELLIPSE; i++) {
            double centerX = getWidth() / 2.0;
            double centerY = getHeight() / 2.0;
            double radiusX = getWidth() / 2.0 - 50.0;
            double radiusY = getHeight() / 2.0 - 50.0;

            // Create an ellipse and add it to pane
            Ellipse e1 = new Ellipse(centerX, centerY, radiusX, radiusY);

            e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            e1.setFill(Color.WHITE);
            e1.setRotate(i * 180.0 / TOTAL_ELLIPSE);

            getChildren().add(e1);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
