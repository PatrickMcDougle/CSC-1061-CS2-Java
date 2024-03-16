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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** show rectangle */
public class JavaFx016Program extends Application {

  /** Override the start method in the Application class */
  @Override
  public void start(Stage primaryStage) {
    // Create rectangles
    Rectangle r1 = new Rectangle(25, 10, 60, 30);
    r1.setStroke(Color.BLACK);
    r1.setFill(Color.WHITE);

    Rectangle r2 = new Rectangle(25, 50, 60, 30);
    Rectangle r3 = new Rectangle(25, 90, 60, 30);
    r3.setArcWidth(15);
    r3.setArcHeight(25);

    // Create a group and add nodes to the group
    Group group = new Group();
    group
        .getChildren()
        .addAll(
            new Text(10, 27, "r1"), r1, new Text(10, 67, "r2"), r2, new Text(10, 107, "r3"), r3);

    for (int i = 0; i < 8; i++) {
      Rectangle r = new Rectangle(100, 50, 100, 30);
      r.setRotate(i * 360 / 16.0);
      r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
      r.setFill(Color.WHITE);
      group.getChildren().add(r);
    }

    // Create a scene and place it in the stage
    Scene scene = new Scene(new BorderPane(group), 250, 150);
    primaryStage.setTitle("ShowRectangle"); // Set the stage title
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
