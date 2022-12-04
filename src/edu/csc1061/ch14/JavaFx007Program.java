package edu.csc1061.ch14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class JavaFx007Program extends Application {

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create a scene and place a button in the scene
		StackPane pane = new StackPane();
		Button buttonOK = new Button("OK");

		buttonOK.setStyle("-fx-border-color: blue;");
		pane.getChildren().add(buttonOK);

		pane.setRotate(45); // Rotate pane 45 degrees
		pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("JavaFx 007 Program - Bond, James Bond"); // Set the stage title
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