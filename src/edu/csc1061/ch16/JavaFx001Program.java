package edu.csc1061.ch16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// show labels with graphics
public class JavaFx001Program extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ImageView usFlagImageView = new ImageView(
      new Image("file:resources/images/flag1.gif")
    );

    usFlagImageView.setFitHeight(108);
    usFlagImageView.setFitWidth(206);

    Label label1 = new Label("US\nFlag", usFlagImageView);
    label1.setStyle("-fx-border-color: green; -fx-border-width: 2");
    label1.setContentDisplay(ContentDisplay.BOTTOM);
    label1.setTextFill(Color.RED);

    Label label2 = new Label("Circle", new Circle(50, 50, 25));
    label2.setContentDisplay(ContentDisplay.TOP);
    label2.setTextFill(Color.ORANGE);

    Label label3 = new Label("Rectangle", new Rectangle(10, 10, 50, 25));
    label3.setContentDisplay(ContentDisplay.RIGHT);

    Label label4 = new Label("Ellipse", new Ellipse(50, 50, 50, 25));
    label4.setContentDisplay(ContentDisplay.LEFT);

    Ellipse ellipse = new Ellipse(50, 50, 50, 25);
    ellipse.setStroke(Color.GREEN);
    ellipse.setFill(Color.WHITE);

    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(ellipse, new Label("JavaFX"));

    Label label5 = new Label("A pane inside a label", stackPane);
    label5.setContentDisplay(ContentDisplay.BOTTOM);

    HBox pane = new HBox(20);
    pane.getChildren().addAll(label1, label2, label3, label4, label5);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 700, 300);
    primaryStage.setTitle("LabelWithGraphic"); // Set the stage title
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
