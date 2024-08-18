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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

// show textfield
public class JavaFx005Program extends JavaFx004Program {

    @Override // Override the getPane() method in the super class
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a new message: "));

        TextField textFieldWords = new TextField();
        textFieldWords.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(textFieldWords);
        pane.setTop(paneForTextField);

        // Lambda Expression:
        // parameter -> expression
        // https://www.w3schools.com/java/java_lambda.asp
        textFieldWords.setOnAction(e -> text.setText(textFieldWords.getText()));

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
