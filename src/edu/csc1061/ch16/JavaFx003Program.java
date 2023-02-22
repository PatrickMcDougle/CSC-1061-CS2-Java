package edu.csc1061.ch16;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// checkbox example
public class JavaFx003Program extends JavaFx002Program {
  private static final String FONT_NAME = "Times New Roman";

  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();

    Font fontBoldItalic = Font.font(
      FONT_NAME,
      FontWeight.BOLD,
      FontPosture.ITALIC,
      20
    );
    Font fontBold = Font.font(
      FONT_NAME,
      FontWeight.BOLD,
      FontPosture.REGULAR,
      20
    );
    Font fontItalic = Font.font(
      FONT_NAME,
      FontWeight.NORMAL,
      FontPosture.ITALIC,
      20
    );
    Font fontNormal = Font.font(
      FONT_NAME,
      FontWeight.NORMAL,
      FontPosture.REGULAR,
      20
    );

    text.setFont(fontNormal);

    VBox paneForCheckBoxes = new VBox(20);
    paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
    paneForCheckBoxes.setStyle("-fx-border-color: green");

    CheckBox checkboxBold = new CheckBox("Bold");
    CheckBox checkboxItalic = new CheckBox("Italic");

    paneForCheckBoxes.getChildren().addAll(checkboxBold, checkboxItalic);
    pane.setRight(paneForCheckBoxes);

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp
    EventHandler<ActionEvent> handler = e -> {
      if (checkboxBold.isSelected() && checkboxItalic.isSelected()) {
        text.setFont(fontBoldItalic); // Both check boxes checked
      } else if (checkboxBold.isSelected()) {
        text.setFont(fontBold); // The Bold check box checked
      } else if (checkboxItalic.isSelected()) {
        text.setFont(fontItalic); // The Italic check box checked
      } else {
        text.setFont(fontNormal); // Both check boxes unchecked
      }
    };

    checkboxBold.setOnAction(handler);
    checkboxItalic.setOnAction(handler);

    return pane; // Return a new pane
  }

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    super.start(primaryStage);
    primaryStage.setTitle("CheckBoxDemo"); // Set the stage title
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
