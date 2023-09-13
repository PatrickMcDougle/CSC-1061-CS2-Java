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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/** show flow pane */
public class JavaFx010Program extends Application {

  /** Override the start method in the Application class */
  @Override
  public void start(Stage primaryStage) {
    // Create a pane and set its properties
    FlowPane pane = new FlowPane();

    pane.setPadding(new Insets(110, 12, 13, 14));
    pane.setHgap(15); // Set hGap to 5px
    pane.setVgap(5);

    // Place nodes in the pane
    pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
    TextField textFieldMiddleInitial = new TextField();
    textFieldMiddleInitial.setPrefColumnCount(1);
    pane.getChildren().addAll(textFieldMiddleInitial, new Label("Last Name:"), new TextField());

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 250);
    primaryStage.setTitle("ShowFlowPane"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
