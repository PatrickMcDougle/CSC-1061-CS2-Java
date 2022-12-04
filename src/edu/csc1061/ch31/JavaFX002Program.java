package edu.csc1061.ch31;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX002Program extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    double x = 10;
    double y = 10;
    final Random random = new Random();

    for (int i = 0; i < 10; i++) {
      Rectangle rectangle = new Rectangle(10, 10, 50, 60);
      rectangle.setFill(Color.WHITE);
      rectangle.setStroke(
        Color.color(
          random.nextDouble(),
          random.nextDouble(),
          random.nextDouble()
        )
      );
      rectangle.setTranslateX(x += 20);
      rectangle.setTranslateY(y += 5);
      pane.getChildren().add(rectangle);
    }
    Scene scene = new Scene(pane, 300, 250);
    primaryStage.setTitle("TranslationDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for
   * running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
