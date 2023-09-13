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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * show arc
 */
public class JavaFx018Program extends Application {

  public static final double ARC_CENTER_X = 150.0;
  public static final double ARC_CENTER_Y = 100.0;

  public static final double ARC_RADIUS_X = 80.0;
  public static final double ARC_RADIUS_Y = 80.0;

  public static final double ARC_START_ANGLE = 30.0;
  public static final double ARC_LENGTH = 35.0;

  /**
   * Override the start method in the Application class
   */
  @Override
  public void start(Stage primaryStage) {
    // Create an arc
    Arc arc1 = new Arc(ARC_CENTER_X, ARC_CENTER_Y, ARC_RADIUS_X, ARC_RADIUS_Y, ARC_START_ANGLE, ARC_LENGTH);
    arc1.setFill(Color.RED); // Set fill color
    arc1.setType(ArcType.ROUND); // Set arc type

    Arc arc2 = new Arc(ARC_CENTER_X, ARC_CENTER_Y, ARC_RADIUS_X, ARC_RADIUS_Y, ARC_START_ANGLE + 90.0, ARC_LENGTH);
    arc2.setFill(Color.WHITE);
    arc2.setType(ArcType.OPEN);
    arc2.setStroke(Color.BLACK);

    Arc arc3 = new Arc(ARC_CENTER_X, ARC_CENTER_Y, ARC_RADIUS_X, ARC_RADIUS_Y, ARC_START_ANGLE + 180.0, ARC_LENGTH);
    arc3.setFill(Color.WHITE);
    arc3.setType(ArcType.CHORD);
    arc3.setStroke(Color.BLACK);

    Arc arc4 = new Arc(ARC_CENTER_X, ARC_CENTER_Y, ARC_RADIUS_X, ARC_RADIUS_Y, ARC_START_ANGLE + 270.0, ARC_LENGTH);
    arc4.setFill(Color.GREEN);
    arc4.setType(ArcType.CHORD);
    arc4.setStroke(Color.BLACK);

    // Create a group and add nodes to the group
    Group group = new Group();
    group
        .getChildren()
        .addAll(
            new Text(210, 40, "arc1: round"),
            arc1,
            new Text(20, 40, "arc2: open"),
            arc2,
            new Text(20, 170, "arc3: chord"),
            arc3,
            new Text(210, 170, "arc4: chord"),
            arc4);

    // Create a scene and place it in the stage
    Scene scene = new Scene(new BorderPane(group), 300, 200);
    primaryStage.setTitle("Show Arc"); // Set the stage title
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
