package edu.csc1061.ch25;

// Inner class InOrderIterator
public class InOrderIterator<E> implements java.util.Iterator<E> {
  // Store the elements in a list
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();
  private int current = 0; // Point to the current element in list
  private TreeNode<E> root;

  public InOrderIterator(TreeNode<E> root) {
    this.root = root;
    inOrder(); // Traverse binary tree and store elements in list
  }

  /** In-order traversal from the root */
  private void inOrder() {
    inOrder(root);
  }

  /** In-order traversal from a subtree */
  private void inOrder(TreeNode<E> root) {
    if (root == null) {
      return;
    }
    inOrder(root.getLeft());
    list.add(root.getElement());
    inOrder(root.getRight());
  }

  /** More elements for traversing? */
  @Override
  public boolean hasNext() {
    return (current < list.size());
  }

  /** Get the current element and move to the next */
  @Override
  public E next() {
    return list.get(current++);
  }

  /** Remove the element returned by the last next() */
  @Override
  public void remove() {
    if (current == 0) { // next() has not been called yet
      throw new IllegalStateException();
    }

    delete(list.get(--current));
    list.clear(); // Clear the list
    inOrder(); // Rebuild the list
  }
}
