package edu.csc1061.ch25;

/**
 * This inner class is static, because it does not access
 * any instance members defined in its outer class
 */
public class TreeNode<E> {
  private E element;

  private TreeNode<E> left;
  private TreeNode<E> right;

  public TreeNode(E e) {
    element = e;
  }

  public TreeNode<E> getLeft() {
    return left;
  }

  public TreeNode<E> getRight() {
    return right;
  }

  public void setLeft(TreeNode<E> treeNode) {
    left = treeNode;
  }

  public void setRight(TreeNode<E> treeNode) {
    right = treeNode;
  }

  public E getElement() {
    return element;
  }

  public void setElement(E e) {
    element = e;
  }
}
