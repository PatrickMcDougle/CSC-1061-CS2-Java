package edu.csc1061.ch31;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ch31JavaFX01 extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    HBox hBox = new HBox(5);
    Scene scene = new Scene(hBox, 300, 250);

    // Load the stylesheet
    // scene.getStylesheets().add("Ch31JavaFX01.css")
    scene.getStylesheets().add(getClass().getResource("Ch31JavaFX01.css").toExternalForm());

    Pane pane1 = new Pane();
    Circle circle1 = new Circle(50, 50, 30);
    Circle circle2 = new Circle(150, 50, 30);
    Circle circle3 = new Circle(100, 100, 30);
    pane1.getChildren().addAll(circle1, circle2, circle3);
    pane1.getStyleClass().add("border");

    circle1.getStyleClass().add("circle-plain"); // Add a style class
    circle2.getStyleClass().add("circle-plain"); // Add a style class
    circle3.setId("circle-red"); // Add a style id

    Pane pane2 = new Pane();
    Circle circle4 = new Circle(100, 100, 30);
    circle4.getStyleClass().addAll("circle-border", "circle-plain");
    circle4.setId("circle-green"); // Add a style class
    pane2.getChildren().add(circle4);
    pane2.getStyleClass().add("border");

    hBox.getChildren().addAll(pane1, pane2);

    primaryStage.setTitle("CSS Demo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
