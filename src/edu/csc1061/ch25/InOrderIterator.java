package edu.csc1061.ch25;

import java.util.NoSuchElementException;

public class InOrderIterator<E> implements java.util.Iterator<E> {
  // Store the elements in a list
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();
  private int currentIndex = 0; // Point to the current element in list
  private BinarySearchTree<E> binarySearchTree;

  // ////////// ////////// //
  // Constructor
  // ////////// ////////// //

  public InOrderIterator(BinarySearchTree<E> bst) {
    this.binarySearchTree = bst;
    inOrder(); // Traverse binary tree and store elements in list
  }

  // ////////// ////////// //
  // Public Override Methods
  // ////////// ////////// //

  /**
   * More elements for traversing?
   */
  @Override
  public boolean hasNext() {
    return (currentIndex < list.size());
  }

  /**
   * Get the current element and move to the next
   */
  @Override
  public E next() {
    try {
      return list.get(currentIndex++);
    } catch (Exception e) {
      throw new NoSuchElementException("Next element had an issue.");
    }
  }

  /**
   * Remove the element returned by the last next()
   */
  @Override
  public void remove() {
    if (currentIndex == 0) { // next() has not been called yet
      throw new IllegalStateException();
    }

    binarySearchTree.delete(list.get(--currentIndex));
    list.clear(); // Clear the list
    inOrder(); // Rebuild the list
  }

  // ////////// ////////// //
  // Private Methods
  // ////////// ////////// //

  /**
   * In-order traversal from the root
   */
  private void inOrder() {
    inOrder(binarySearchTree.getRoot());
  }

  /**
   * In-order traversal from a subtree
   */
  private void inOrder(TreeNode<E> root) {
    if (root == null) {
      return;
    }
    inOrder(root.getLeft());
    list.add(root.getElement());
    inOrder(root.getRight());
  }
}