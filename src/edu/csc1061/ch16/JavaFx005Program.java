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

    textFieldWords.setOnAction(e -> text.setText(textFieldWords.getText()));

    return pane;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
