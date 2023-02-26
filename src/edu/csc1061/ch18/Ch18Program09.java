package edu.csc1061.ch18;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Sierpinski Triangle
 */
public class Ch18Program09 extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
    TextField textFieldOrder = new TextField();
    textFieldOrder.setOnAction(e -> pane.setOrder(Integer.parseInt(textFieldOrder.getText())));
    textFieldOrder.setPrefColumnCount(4);
    textFieldOrder.setAlignment(Pos.BOTTOM_RIGHT);

    // Pane to hold label, text field, and a button
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(new Label("Enter an order: "), textFieldOrder);
    hBox.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 210);
    primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    pane.widthProperty().addListener(ov -> pane.paint());
    pane.heightProperty().addListener(ov -> pane.paint());
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
