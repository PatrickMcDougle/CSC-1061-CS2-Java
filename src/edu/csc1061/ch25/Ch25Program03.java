/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch25;

import java.util.Random;
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

  private static final int MAX_RANDOM_NUMBER_BOUND = 1000;

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
    Button buttonRandom = new Button("Random");
    Button buttonClear = new Button("Clear");

    Label labelEnter = new Label("Enter a key: ");

    HBox hBox = new HBox(5);
    hBox.getChildren()
        .addAll(labelEnter, textFieldKey, buttonInsert, buttonDelete, buttonRandom, buttonClear);
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

    buttonRandom.setOnAction(
        e -> {
          int key = nextRandomNumber();
          while (treeModel.search(key) && treeModel.size() < MAX_RANDOM_NUMBER_BOUND) {
            key = nextRandomNumber();
          }
          treeModel.insert(key); // Insert the new key
          treeView.displayTree();
          StringBuilder sb = new StringBuilder();
          sb.append(key);
          sb.append(" is inserted. Total Nodes: ");
          sb.append(treeModel.size());
          treeView.setStatus(sb.toString());
        });

    buttonClear.setOnAction(
        e -> {
          treeModel.clear();
          treeView.displayTree();
        });

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 450, 250);
    primaryStage.setTitle("BSTAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  private static Random random = new Random();

  private static int nextRandomNumber() {
    return random.nextInt(MAX_RANDOM_NUMBER_BOUND);
  }

  /**
   * The main method is only needed for the IDE with limited JavaFX support. Not needed for running
   * from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
