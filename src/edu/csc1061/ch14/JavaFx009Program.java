/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFx009Program extends Application {

    /** Override the start method in the Application class */
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Working dir:  " + System.getProperty("user.dir"));

        // Create a pane to hold the image views
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        // JavaFX supports the image formats like Bmp, Gif, Jpeg, Png.
        Image image = new Image("file:resources/images/Space_Unicorn.gif");
        pane.getChildren().add(new ImageView(image));

        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(69);
        imageView2.setFitWidth(120);
        pane.getChildren().add(imageView2);

        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show Image"); // Set the stage title
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
