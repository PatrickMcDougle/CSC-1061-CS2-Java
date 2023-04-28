package edu.csc1061.ch25;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ch25Program03 extends Application {

  // Override the start method in the Application class
  @Override
  public void start(Stage primaryStage) {
    BinarySearchTree<Integer> treeModel = new BinarySearchTree<>(); // Create a tree

    BorderPane pane = new BorderPane();
    BinarySearchTreeView treeView = new BinarySearchTreeView(treeModel); // Create a View
    pane.setCenter(treeView);

    TextField textFieldKey = new TextField();
    textFieldKey.setPrefColumnCount(3);
    textFieldKey.setAlignment(Pos.BASELINE_RIGHT);
    Button buttonInsert = new Button("Insert");
    Button buttonDelete = new Button("Delete");
    HBox hBox = new HBox(5);
    hBox
        .getChildren()
        .addAll(new Label("Enter a key: "), textFieldKey, buttonInsert, buttonDelete);
    hBox.setAlignment(Pos.CENTER);
    pane.setBottom(hBox);

    buttonInsert.setOnAction(
        e -> {
          int key = Integer.parseInt(textFieldKey.getText());
          if (treeModel.search(key)) { // key is in the tree already
            treeView.displayTree();
            treeView.setStatus(key + " is already in the tree");
          } else {
            treeModel.insert(key); // Insert a new key
            treeView.displayTree();
            treeView.setStatus(key + " is inserted in the tree");
          }
        });

    buttonDelete.setOnAction(
        e -> {
          int key = Integer.parseInt(textFieldKey.getText());
          if (!treeModel.search(key)) { // key is not in the tree
            treeView.displayTree();
            treeView.setStatus(key + " is not in the tree");
          } else {
            treeModel.delete(key); // Delete a key
            treeView.displayTree();
            treeView.setStatus(key + " is deleted from the tree");
          }
        });

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 450, 250);
    primaryStage.setTitle("BSTAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not
   * needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
