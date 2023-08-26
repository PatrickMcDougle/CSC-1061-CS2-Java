/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.mandelbrot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;

public class MandelbrotDocumentController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private DisplayPane displayPane;

    private static final int MAX_ITERATIONS = 255; // 255 - range of colors. 0-255 gray scale.
    private static final int IMAGE_SIZE = 900;
    private static final int IMAGE_SIZE_HALF = 450;

    private double xCenter = 0.0;
    private double yCenter = 0.0;
    private double zoom = 1.0;

    private Color[] colors;

    @FXML
    private void handleButtonActionRepaint(ActionEvent event) {
        xCenter = 0.0;
        yCenter = 0.0;
        zoom = 2.0;
        updateDisplay();
    }

    private void doCalculations() {
        double preCalc = zoom / IMAGE_SIZE;
        double pX = xCenter - IMAGE_SIZE_HALF * preCalc;
        double pY = yCenter - IMAGE_SIZE_HALF * preCalc;
        double incX = 0.0;
        for (int i = 0; i < IMAGE_SIZE; ++i, incX += preCalc) {
            double x0 = pX + incX;
            double incY = 0.0;
            for (int j = 0; j < IMAGE_SIZE; ++j, incY += preCalc) {
                double y0 = pY + incY;
                Complex z0 = new Complex(x0, y0);
                int color = MAX_ITERATIONS - Mandelbrot.numberOfIterations(z0, MAX_ITERATIONS);
                displayPane.setColor(i, j, colors[color]);
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colors = new Color[MAX_ITERATIONS + 1];

        for (int i = 0; i <= MAX_ITERATIONS; ++i) {
            double gray = (i * 1.0) / MAX_ITERATIONS;
            colors[i] = new Color(gray, gray, gray, 1.0);
        }

        displayPane.setOnMouseMoved(this::updateMousePosition);
        displayPane.setOnMouseClicked(this::mouseClickedRepaint);
        displayPane.setOnScroll(this::mouseScrolled);
    }

    private Object mouseScrolled(ScrollEvent e) {
        if (e.getDeltaY() < 0) {
            zoom *= 2.0;
        } else {
            zoom *= 0.5;
        }
        updateDisplay();
        return null;
    }

    private Object updateMousePosition(MouseEvent e) {
        String msg = "Mouse (x: " + e.getX() + ", y: " + e.getY() + ") -- " + "Location (x: "
                + xCenter + ", y: " + yCenter + ", zoom: " + zoom + ")";

        label.setText(msg);

        return null;
    }

    private Object mouseClickedRepaint(MouseEvent e) {
        xCenter = (e.getX() - IMAGE_SIZE_HALF) * 0.001111 * zoom + xCenter;
        yCenter = (e.getY() - IMAGE_SIZE_HALF) * 0.001111 * zoom + yCenter;
        updateDisplay();
        return null;
    }

    private void updateDisplay() {
        System.out.println("X/Y/ZOOM :: " + xCenter + "/" + yCenter + "/" + zoom);
        System.out.println("Paint Display Start!");
        doCalculations();
        System.out.println("Paint Display End!");
    }
}
