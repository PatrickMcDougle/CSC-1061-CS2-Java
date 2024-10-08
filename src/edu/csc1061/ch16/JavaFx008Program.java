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
package edu.csc1061.ch16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// ListView example
public class JavaFx008Program extends Application {
    // Declare an array of Strings for flag titles
    private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", "India",
            "Norway", "United Kingdom", "United States of America",};

    // Declare an ImageView array for the national flags of 9 countries
    private ImageView[] flagImages = {new ImageView("file:resources/images/ca.gif"),
            new ImageView("file:resources/images/china.gif"),
            new ImageView("file:resources/images/denmark.gif"),
            new ImageView("file:resources/images/fr.gif"),
            new ImageView("file:resources/images/germany.gif"),
            new ImageView("file:resources/images/india.gif"),
            new ImageView("file:resources/images/norway.gif"),
            new ImageView("file:resources/images/uk.gif"),
            new ImageView("file:resources/images/us.gif"),};

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ListView<String> listViewOfFlags =
                new ListView<>(FXCollections.observableArrayList(flagTitles));
        listViewOfFlags.setPrefSize(140, 400);
        listViewOfFlags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Create a pane to hold image views
        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(listViewOfFlags));
        pane.setCenter(imagePane);

        // Lambda Expression:
        // parameter -> expression
        // https://www.w3schools.com/java/java_lambda.asp
        listViewOfFlags.getSelectionModel().selectedItemProperty().addListener(observable -> {
            imagePane.getChildren().clear();
            for (Integer i : listViewOfFlags.getSelectionModel().getSelectedIndices()) {
                imagePane.getChildren().add(flagImages[i]);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ListViewDemo"); // Set the stage title
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
