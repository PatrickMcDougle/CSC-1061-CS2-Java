/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * show ellipse
 */
public class JavaFx017Program extends Application {

  /**
   * Override the start method in the Application class
   */
  @Override
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(new MyEllipse(), 300, 200);
    primaryStage.setTitle("Show My Ellipse"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not
   * needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
