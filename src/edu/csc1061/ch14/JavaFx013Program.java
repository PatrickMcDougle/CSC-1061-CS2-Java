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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** show HBox and VBox panes */
public class JavaFx013Program extends Application {

  /** Override the start method in the Application class */
  @Override
  public void start(Stage primaryStage) {
    // Create a border pane
    BorderPane pane = new BorderPane();

    // Place nodes in the pane
    pane.setTop(getHBox());
    pane.setLeft(getVBox());

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  private HBox getHBox() {
    HBox hBox = new HBox(15); // Create an HBox with 15px spacing
    hBox.setPadding(new Insets(15, 15, 15, 15));
    hBox.setStyle("-fx-background-color: gold");
    hBox.getChildren().add(new Button("Computer Science"));
    hBox.getChildren().add(new Button("Chemistry"));
    ImageView imageView = new ImageView(new Image("file:resources/images/Space_Unicorn.gif"));
    hBox.getChildren().add(imageView);
    return hBox;
  }

  private VBox getVBox() {
    VBox vBox = new VBox(15); // Create a VBox with 15px spacing
    vBox.setPadding(new Insets(15, 5, 5, 5));
    vBox.getChildren().add(new Label("Courses"));

    Label[] courses = {
      new Label("CSC 1060: Computer Science I"),
      new Label("CSC 1061: Computer Science II"),
      new Label("CSC 1026: Game Design and Development"),
      new Label("CSCI 2000: Game Programming I")
    };

    for (Label course : courses) {
      VBox.setMargin(course, new Insets(0, 0, 0, 15));
      vBox.getChildren().add(course);
    }

    return vBox;
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
