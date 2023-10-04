/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch31;

import java.util.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Demonstrates a drag-and-drop feature. */
public class Ch31JavaFX04 extends Application {

  private static final Random random = new Random();

  private Text source;
  private Text target;

  @Override
  public void start(Stage stage) {
    stage.setTitle("Drag And Drop Example");

    Group root = new Group();
    Scene scene = new Scene(root, 400, 200);
    scene.setFill(Color.AQUA);

    source = new Text(50, 100, "DRAG ME [01]");
    source.setScaleX(2.0);
    source.setScaleY(2.0);

    target = new Text(250, 100, "DROP HERE");
    target.setScaleX(2.0);
    target.setScaleY(2.0);

    setSourceEventHandlers(source);
    setTargetEventHandlers(target);

    root.getChildren().add(source);
    root.getChildren().add(target);
    stage.setScene(scene);
    stage.show();
  }

  private void setTargetEventHandlers(Node target) {

    target.setOnDragOver(
        event -> {
          // data is dragged over the target
          System.out.println("onDragOver");

          // accept it only if it is  not dragged from the same node
          // and if it has a string data
          if (event.getGestureSource() != target && event.getDragboard().hasString()) {
            // allow for both copying and moving, whatever user chooses
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
          }

          event.consume();
        });

    target.setOnDragEntered(
        event -> {
          // the drag-and-drop gesture entered the target
          System.out.println("onDragEntered");

          // show to the user that it is an actual gesture target
          if (event.getGestureSource() != target && event.getDragboard().hasString()) {
            this.target.setFill(Color.GREEN);
            this.target.setStyle("-fx-font-weight: bold;");
          }

          event.consume();
        });

    target.setOnDragExited(
        event -> {
          // mouse moved away, remove the graphical cues
          this.target.setFill(Color.BLACK);
          this.target.setStyle("-fx-font-weight: normal;");

          event.consume();
        });

    target.setOnDragDropped(
        event -> {
          // data dropped
          System.out.println("onDragDropped");
          // if there is a string data on dragboard, read it and use it
          Dragboard db = event.getDragboard();
          boolean success = false;
          if (db.hasString()) {
            this.target.setText(db.getString());
            this.target.setStyle("-fx-font-weight: normal;");
            success = true;
          }
          // let the source know whether the string was successfully
          // transferred and used
          event.setDropCompleted(success);

          event.consume();
        });
  }

  private void setSourceEventHandlers(Node source) {

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp
    source.setOnDragDetected(
        event -> {
          // drag was detected, start drag-and-drop gesture
          System.out.println("onDragDetected");

          // allow any transfer mode
          Dragboard dragboard = source.startDragAndDrop(TransferMode.ANY);

          // put a string on dragboard
          ClipboardContent content = new ClipboardContent();
          content.putString(this.source.getText());
          dragboard.setContent(content);

          event.consume();
        });

    // example code of how to create the event without using Lambda Expressions:
    // source.setOnDragDetected(
    //     new EventHandler<MouseEvent>() {
    //       public void handle(MouseEvent event) {
    //         // drag was detected, start drag-and-drop gesture
    //         System.out.println("onDragDetected")
    //         // allow any transfer mode
    //         Dragboard dragboard = source.startDragAndDrop(TransferMode.ANY)
    //         // put a string on dragboard
    //         ClipboardContent content = new ClipboardContent()
    //         content.putString(source.getText())
    //         dragboard.setContent(content)
    //         event.consume()
    //       }
    //     })

    source.setOnDragDone(
        event -> {
          // the drag-and-drop gesture ended
          System.out.println("onDragDone");
          // if the data was successfully moved, clear it
          if (event.getTransferMode() == TransferMode.MOVE) {
            this.source.setText(String.format("Next Drag [%d]", random.nextInt(100)));
          }

          event.consume();
        });
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
