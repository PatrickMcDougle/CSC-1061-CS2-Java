/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFx007Program extends Application {

  /** Override the start method in the Application class */
  @Override
  public void start(Stage primaryStage) {
    // Create a scene and place a button in the scene
    StackPane pane = new StackPane();
    Button buttonOK = new Button("OK");

    buttonOK.setStyle("-fx-border-color: blue;");
    pane.getChildren().add(buttonOK);

    pane.setRotate(45); // Rotate pane 45 degrees
    pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

    Scene scene = new Scene(pane, 200, 250);

    // Set the stage title
    primaryStage.setTitle("JavaFx 007 Program - Bond, James Bond");
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
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
