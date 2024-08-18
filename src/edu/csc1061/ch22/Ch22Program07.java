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
package edu.csc1061.ch22;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Eight Queens
public class Ch22Program07 extends Application {
    public static final int SIZE = 8; // The size of the chess board
    // queens are placed at (i, queens[i])
    // -1 indicates that no queen is currently placed in the ith row
    // Initially, place a queen at (0, 0) in the 0th row
    private int[] queens = {3, -1, -1, -1, -1, -1, -1, -1};

    // Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {
        search(); // Search for a solution

        // Display chess board
        GridPane chessBoard = new GridPane();
        chessBoard.setAlignment(Pos.CENTER);
        Label[][] labels = new Label[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                labels[i][j] = new Label();
                chessBoard.add(labels[i][j], j, i);
                labels[i][j].setStyle("-fx-border-color: black");
                labels[i][j].setPrefSize(55, 55);
            }
        }

        // Display queens
        Image image = new Image("file:resources/images/queen.jpg");
        for (int i = 0; i < SIZE; i++) {
            labels[i][queens[i]].setGraphic(new ImageView(image));
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(chessBoard, 55.0 * SIZE, 55.0 * SIZE);
        primaryStage.setTitle("EightQueens"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Search for a solution
     *
     * @return true is a solution is found, else false.
     */
    private boolean search() {
        // k is the current row to be considered
        // We are looking for a position in the kth row to place a queen
        int k = 0;
        while (k >= 0 && k < SIZE) {
            // Find a position to place a queen in the kth row
            int j = findPosition(k);
            if (j < 0) {
                queens[k] = -1;
                k--; // Backtrack to the previous row
            } else {
                queens[k] = j;
                k++;
            }
        }

        // This was the original code for this assignment.
        // if k == -1 return false; // No solution
        // else return true; // A solution is found
        return k != -1;
    }

    /**
     * Find the next position for this queen.
     *
     * @param k is the queen that we are looking for a position for.
     * @return the column location for the kth queen or -1 if not possible.
     */
    public int findPosition(int k) {
        int start = queens[k] + 1; // Search for a new placement

        for (int j = start; j < SIZE; j++) {
            if (isValid(k, j)) {
                return j; // (k, j) is the place to put the queen now
            }
        }

        return -1;
    }

    /**
     * Return true if a queen can be placed at (row, column)
     *
     * @param row The row to check if a queen can be placed here.
     * @param column The column to check if a queen can be placed here.
     * @return true if there is no conflict, or false if there is conflict.
     */
    public boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            // Check column
            // Check up left diagonal
            // Check up right diagonal
            if (queens[row - i] == column || queens[row - i] == column - i
                    || queens[row - i] == column + i) {
                return false; // There is a conflict
            }
        }
        return true; // No conflict
    }

    /** The main method just needs the JavaFX launch call. */
    public static void main(String[] args) {
        launch(args);
    }
}
