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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements ITree<E> {
  private TreeNode<E> root;
  private int size = 0;
  private Comparator<E> comparator;

  // ////////// ////////// //
  // Constructors
  // ////////// ////////// //

  /** Create a default BinarySearchTree with a natural order comparator */
  public BinarySearchTree() {
    this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
  }

  /**
   * Create a BinarySearchTree with a specified comparator
   *
   * @param c
   */
  public BinarySearchTree(Comparator<E> c) {
    this.comparator = c;
  }

  /**
   * Create a binary tree from an array of objects
   *
   * @param objects
   */
  public BinarySearchTree(E[] objects) {
    this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  // ////////// ////////// //
  // Public Methods
  // ////////// ////////// //

  /**
   * Returns the root of the tree
   *
   * @return
   */
  public TreeNode<E> getRoot() {
    return root;
  }

  /**
   * In-order traversal from the root
   *
   * @return
   */
  public String inOrder() {
    return inOrder(root);
  }

  /**
   * Returns a path from the root leading to the specified element
   *
   * @param e
   * @return
   */
  public List<TreeNode<E>> path(E e) {
    ArrayList<TreeNode<E>> list = new ArrayList<>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (comparator.compare(e, current.getElement()) < 0) {
        current = current.getLeft();
      } else if (comparator.compare(e, current.getElement()) > 0) {
        current = current.getRight();
      } else {
        break;
      }
    }

    return list; // Return an array list of nodes
  }

  /**
   * Post-order traversal from the root
   *
   * @return
   */
  public String postOrder() {
    return postOrder(root);
  }

  /**
   * Pre-order traversal from the root
   *
   * @return
   */
  public String preOrder() {
    return preOrder(root);
  }

  // ////////// ////////// //
  // Override Methods
  // ////////// ////////// //

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Delete an element from the binary tree.
   *
   * @param e the element to delete from the tree
   * @return true if the element is deleted successfully, false if the element is not in the tree
   */
  @Override
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;

    while (current != null) {
      if (comparator.compare(e, current.getElement()) < 0) {
        parent = current;
        current = current.getLeft();
      } else if (comparator.compare(e, current.getElement()) > 0) {
        parent = current;
        current = current.getRight();
      } else {
        break; // Element is in the tree pointed at by current
      }
    }

    if (current == null) {
      return false; // Element is not in the tree
    }

    if (current.getLeft() == null) {
      // Case 1: current has no left child
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.getRight();
      } else {
        if (comparator.compare(e, parent.getElement()) < 0) {
          parent.setLeft(current.getRight());
        } else {
          parent.setRight(current.getRight());
        }
      }
    } else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.getLeft();

      while (rightMost.getRight() != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.getRight(); // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.setElement(rightMost.getElement());

      // Eliminate rightmost node
      if (parentOfRightMost.getRight() == rightMost) {
        parentOfRightMost.setRight(rightMost.getLeft());
      } else {
        // Special case: parentOfRightMost == current
        parentOfRightMost.setLeft(rightMost.getLeft());
      }
    }

    size--; // Reduce the size of the tree
    return true; // Element deleted successfully
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean insert(E e) {
    if (root == null) {
      root = createNewNode(e); // Create a new root
    } else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null) {
        if (comparator.compare(e, current.getElement()) < 0) {
          parent = current;
          current = current.getLeft();
        } else if (comparator.compare(e, current.getElement()) > 0) {
          parent = current;
          current = current.getRight();
        } else {
          return false; // Duplicate node not inserted
        }
      }
      // Create the new node and attach it to the parent node
      if (comparator.compare(e, parent.getElement()) < 0) {
        parent.setLeft(createNewNode(e));
      } else {
        parent.setRight(createNewNode(e));
      }
    }

    size++;
    return true; // Element inserted successfully
  }

  @Override
  public java.util.Iterator<E> iterator() {
    return new InOrderIterator<>(this);
  }

  @Override
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (comparator.compare(e, current.getElement()) < 0) {
        current = current.getLeft();
      } else if (comparator.compare(e, current.getElement()) > 0) {
        current = current.getRight();
      } else { // element matches current.element
        return true; // Element is found
      }
    }

    return false;
  }

  // ////////// ////////// //
  // Private Methods
  // ////////// ////////// //

  private TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  /**
   * In-order traversal from a subtree
   *
   * @param root
   * @return
   */
  private String inOrder(TreeNode<E> root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(inOrder(root.getLeft()));
    sb.append(root.getElement() + " ");
    sb.append(inOrder(root.getRight()));

    return sb.toString();
  }

  /**
   * Post-order traversal from a subtree
   *
   * @param root
   * @return
   */
  private String postOrder(TreeNode<E> root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(inOrder(root.getLeft()));
    sb.append(inOrder(root.getRight()));
    sb.append(root.getElement());
    sb.append(" ");

    return sb.toString();
  }

  /**
   * Pre-order traversal from a subtree
   *
   * @param subtree
   * @return
   */
  private String preOrder(TreeNode<E> subtree) {
    if (subtree == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(subtree.getElement());
    sb.append(" ");
    sb.append(inOrder(subtree.getLeft()));
    sb.append(inOrder(subtree.getRight()));

    return sb.toString();
  }

  // ////////// ////////// //
  // Print Methods
  // ////////// ////////// //

  public String printAsciiTree() {
    if (root == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("* ");
    sb.append(root.getElement());
    sb.append('\n');
    sb.append(printAsciiTree(root.getLeft(), 1, true));
    sb.append(printAsciiTree(root.getRight(), 1, false));

    return sb.toString();
  }

  private String printAsciiTree(TreeNode<E> subtree, int depth, boolean leftSide) {
    if (subtree == null) {
      return "";
    }

    int newDepth = depth + 1;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < newDepth; i++) {
      sb.append('*');
    }
    sb.append(leftSide ? "<" : ">");
    sb.append(' ');
    sb.append(subtree.getElement());
    sb.append('\n');
    sb.append(printAsciiTree(subtree.getLeft(), newDepth, true));
    sb.append(printAsciiTree(subtree.getRight(), newDepth, false));

    return sb.toString();
  }
}
