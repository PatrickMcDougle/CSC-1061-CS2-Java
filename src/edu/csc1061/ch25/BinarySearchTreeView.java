/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch25;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BinarySearchTreeView extends Pane {
  private BinarySearchTree<Integer> treeModel = new BinarySearchTree<>();
  private double radius = 15; // Tree node radius
  private double vGap = 50; // Gap between two levels in a tree

  // ////////// ////////// //
  // Constructor
  // ////////// ////////// //

  BinarySearchTreeView(BinarySearchTree<Integer> tree) {
    this.treeModel = tree;
    setStatus("Tree is empty");
  }

  // ////////// ////////// //
  // Public Methods
  // ////////// ////////// //

  /**
   * Clears the tree view and updates it based on the BinarySearchTree.
   */
  public void displayTree() {
    this.getChildren().clear(); // Clear the pane
    if (treeModel.getRoot() != null) {
      // Display tree recursively
      displayTree(treeModel.getRoot(), getWidth() / 2.0, vGap, getWidth() / 4.0);
    }
  }

  public void setStatus(String msg) {
    getChildren().add(new Text(20, 20, msg));
  }

  // ////////// ////////// //
  // Private Methods
  // ////////// ////////// //

  /**
   * Display a subtree rooted at position (x, y)
   */
  private void displayTree(TreeNode<Integer> root, double x, double y, double hGap) {
    if (root.getLeft() != null) {
      // Draw a line to the left node
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      // Draw the left subtree recursively
      displayTree(root.getLeft(), x - hGap, y + vGap, hGap / 2.0);
    }

    if (root.getRight() != null) {
      // Draw a line to the right node
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      // Draw the right subtree recursively
      displayTree(root.getRight(), x + hGap, y + vGap, hGap / 2.0);
    }

    // Display a node
    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    String textString = root.getElement().toString();
    double textX = x - (textString.length() * 3.25);
    double textY = y + 4.0;
    getChildren()
        .addAll(circle, new Text(textX, textY, textString));
  }
}
