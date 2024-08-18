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
package edu.csc1061.ch16;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

// radio button
public class JavaFx004Program extends JavaFx003Program {

    @Override // Override the getPane() method in the super class
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        RadioButton radioButtonRed = new RadioButton("Red");
        RadioButton radioButtonGreen = new RadioButton("Green");
        RadioButton radioButtonBlue = new RadioButton("Blue");
        RadioButton radioButtonBlack = new RadioButton("Black");
        paneForRadioButtons.getChildren().addAll(radioButtonRed, radioButtonGreen, radioButtonBlue,
                radioButtonBlack);
        pane.setLeft(paneForRadioButtons);

        ToggleGroup toggleGroupColors = new ToggleGroup();
        radioButtonRed.setToggleGroup(toggleGroupColors);
        radioButtonGreen.setToggleGroup(toggleGroupColors);
        radioButtonBlue.setToggleGroup(toggleGroupColors);
        radioButtonBlack.setToggleGroup(toggleGroupColors);

        // Lambda Expression:
        // parameter -> expression
        // https://www.w3schools.com/java/java_lambda.asp
        radioButtonRed.setOnAction(e -> {
            if (radioButtonRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        radioButtonGreen.setOnAction(e -> {
            if (radioButtonGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        radioButtonBlue.setOnAction(e -> {
            if (radioButtonBlue.isSelected()) {
                text.setFill(Color.BLUE);
            }
        });

        radioButtonBlack.setOnAction(e -> {
            if (radioButtonBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });

        return pane;
    }

    /**
     * The main method should always be present so that the code is compilable and runnable on
     * different computers. Make sure you have the main method in the application so others can
     * compile the code.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
