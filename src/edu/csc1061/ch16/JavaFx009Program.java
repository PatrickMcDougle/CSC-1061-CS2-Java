/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch16;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// ScrollBar example
public class JavaFx009Program extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Text text = new Text(20, 20, "JavaFX Programming - CSC 1061");

    ScrollBar scrollBarHorizontal = new ScrollBar();
    ScrollBar scrollBarVertical = new ScrollBar();
    scrollBarVertical.setOrientation(Orientation.VERTICAL);

    // Create a text in a pane
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);

    // Create a border pane to hold text and scroll bars
    BorderPane pane = new BorderPane();
    pane.setCenter(paneForText);
    pane.setBottom(scrollBarHorizontal);
    pane.setLeft(scrollBarVertical);

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp

    // Listener for horizontal scroll bar value change
    scrollBarHorizontal
        .valueProperty()
        .addListener(
            observable ->
                text.setX(
                    scrollBarHorizontal.getValue()
                        * paneForText.getWidth()
                        / scrollBarHorizontal.getMax()));

    // Listener for vertical scroll bar value change
    scrollBarVertical
        .valueProperty()
        .addListener(
            observable ->
                text.setY(
                    scrollBarVertical.getValue()
                        * paneForText.getHeight()
                        / scrollBarVertical.getMax()));

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ScrollBarDemo"); // Set the stage title
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
