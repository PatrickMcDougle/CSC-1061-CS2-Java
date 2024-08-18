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

/**
 * This was an inner class of BinarySearchTree. It was removed from the BinarySearchTree file to
 * make it a little easier to read. It was also removed because it will also be used in the Huffman
 * Tree.
 */
public class TreeNode<E> {
    private E element;

    private TreeNode<E> left;
    private TreeNode<E> right;

    // ////////// ////////// //
    // Constructor
    // ////////// ////////// //

    public TreeNode(E e) {
        element = e;
    }

    // ////////// ////////// //
    // Public Methods
    // ////////// ////////// //

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setElement(E e) {
        element = e;
    }

    public void setLeft(TreeNode<E> treeNode) {
        left = treeNode;
    }

    public void setRight(TreeNode<E> treeNode) {
        right = treeNode;
    }
}
