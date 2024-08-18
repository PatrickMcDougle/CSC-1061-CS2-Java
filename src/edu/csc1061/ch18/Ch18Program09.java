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
package edu.csc1061.ch18;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/** Sierpinski Triangle */
public class Ch18Program09 extends Application {

    private static Random random = new Random();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();

        Label debugLabel = new Label("Debug Output");

        TextField textFieldOrder = new TextField();
        textFieldOrder.setOnAction(e -> {
            int level = Integer.parseInt(textFieldOrder.getText());
            int something = random.nextInt(100);

            pane.setOrder(level);
            debugLabel.setText(String.format("Done [%d] : %d", level, something));
        });
        textFieldOrder.setPrefColumnCount(4);
        textFieldOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), textFieldOrder, debugLabel);
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
