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

    @Override
    public boolean hasNext() {
        return (currentIndex < list.size());
    }

    @Override
    public E next() {
        try {
            return list.get(currentIndex++);
        } catch (Exception e) {
            throw new NoSuchElementException("Next element had an issue.");
        }
    }

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

    /** In-order traversal from the root */
    private void inOrder() {
        inOrder(binarySearchTree.getRoot());
    }

    /** In-order traversal from a subtree */
    private void inOrder(TreeNode<E> subtree) {
        if (subtree == null) {
            return;
        }
        inOrder(subtree.getLeft());
        list.add(subtree.getElement());
        inOrder(subtree.getRight());
    }
}
