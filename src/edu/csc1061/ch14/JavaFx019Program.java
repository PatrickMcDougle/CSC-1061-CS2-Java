/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// show Polygon and Polyline
public class JavaFx019Program extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(new MyPolygon(), 400, 400);

    primaryStage.setTitle("ShowPolygon"); // Set the stage title
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
