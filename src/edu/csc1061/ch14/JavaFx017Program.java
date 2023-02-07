package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// show ellipse
public class JavaFx017Program extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(new MyEllipse(), 300, 200);
    primaryStage.setTitle("ShowEllipse"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for
   * running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
