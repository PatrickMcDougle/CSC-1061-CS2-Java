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

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayPane extends Pane {

    private int gridWidth = 0;
    private int gridHeight = 0;

    private Rectangle[][] displayGrid;

    public static final Color DEFAULT_COLOR = Color.PURPLE;

    public DisplayPane() {
        // do nothing at this time.
    }

    public void setPixelHeight(int height) {
        gridHeight = height;
        if (gridWidth > 1) {
            setupDisplay(gridWidth, gridHeight);
        }
    }

    public void setPixelWidth(int width) {
        gridWidth = width;
        if (gridHeight > 1) {
            setupDisplay(gridWidth, gridHeight);
        }
    }

    public int getPixelWidth() {
        return gridWidth;
    }

    public int getPixelHeight() {
        return gridHeight;
    }

    public void setupDisplay(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        displayGrid = new Rectangle[gridWidth][gridHeight];
        addChildrenRectangles();
        clearDisplay();
    }

    public boolean setColor(int w, int h, Color c) {
        if (w < 0 || w >= gridWidth) {
            return false;
        }
        if (h < 0 || h >= gridHeight) {
            return false;
        }

        displayGrid[w][h].setFill(c);
        return true;
    }

    private void clearDisplay() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                setColor(i, j, DEFAULT_COLOR);
            }
        }
    }

    private void addChildrenRectangles() {

        double widthSize = Math.floor(getWidth() / gridWidth);
        double heightSize = Math.floor(getHeight() / gridHeight);

        if (widthSize < 1.0) {
            widthSize = 1.0;
        }
        if (heightSize < 1.0) {
            heightSize = 1.0;
        }

        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                displayGrid[i][j] = new Rectangle(i * widthSize, j * heightSize, widthSize, heightSize);

                displayGrid[i][j].setFill(DEFAULT_COLOR);
                getChildren().add(displayGrid[i][j]);
            }
        }

        Rectangle centerPointLocation = new Rectangle(gridWidth * 0.5 * widthSize,
                gridHeight * 0.5 * heightSize, widthSize * 4, heightSize * 4);
        centerPointLocation.setFill(DEFAULT_COLOR);
        getChildren().add(centerPointLocation);
    }
}
