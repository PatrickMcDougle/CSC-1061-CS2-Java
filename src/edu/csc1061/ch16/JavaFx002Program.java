package edu.csc1061.ch16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// button demo
public class JavaFx002Program extends Application {
  protected Text text = new Text(50, 50, "JavaFX Programming - CSC 1061");

  protected BorderPane getPane() {
    HBox paneForButtons = new HBox(20);
    Button buttonLeft = new Button(
      "Left",
      new ImageView("file:resources/images/left.gif")
    );
    Button buttonRight = new Button(
      "Right",
      new ImageView("file:resources/images/right.gif")
    );
    paneForButtons.getChildren().addAll(buttonLeft, buttonRight);
    paneForButtons.setAlignment(Pos.CENTER);
    paneForButtons.setStyle("-fx-border-color: green");

    BorderPane pane = new BorderPane();
    pane.setBottom(paneForButtons);

    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    pane.setCenter(paneForText);

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp
    buttonLeft.setOnAction(e -> text.setX(text.getX() - 10));
    buttonRight.setOnAction(e -> text.setX(text.getX() + 10));

    return pane;
  }

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(), 500, 300);
    primaryStage.setTitle("JavaFx 002 Program - ButtonDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
