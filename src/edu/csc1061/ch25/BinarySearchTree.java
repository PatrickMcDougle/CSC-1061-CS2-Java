package edu.csc1061.ch25;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements ITree<E> {
  protected TreeNode<E> root;
  protected int size = 0;
  protected java.util.Comparator<E> c;

  /** Create a default BinarySearchTree with a natural order comparator */
  public BinarySearchTree() {
    this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
  }

  /** Create a BinarySearchTree with a specified comparator */
  public BinarySearchTree(java.util.Comparator<E> c) {
    this.c = c;
  }

  /** Create a binary tree from an array of objects */
  public BinarySearchTree(E[] objects) {
    this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  /** Returns true if the element is in the tree */
  @Override
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (c.compare(e, current.getElement()) < 0) {
        current = current.getLeft();
      } else if (c.compare(e, current.getElement()) > 0) {
        current = current.getRight();
      } else { // element matches current.element
        return true; // Element is found
      }
    }

    return false;
  }

  /**
   * Insert element e into the binary tree
   * Return true if the element is inserted successfully
   */
  @Override
  public boolean insert(E e) {
    if (root == null) {
      root = createNewNode(e); // Create a new root
    } else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null) {
        if (c.compare(e, current.getElement()) < 0) {
          parent = current;
          current = current.getLeft();
        } else if (c.compare(e, current.getElement()) > 0) {
          parent = current;
          current = current.getRight();
        } else {
          return false; // Duplicate node not inserted
        }
      }
      // Create the new node and attach it to the parent node
      if (c.compare(e, parent.getElement()) < 0) {
        parent.setLeft(createNewNode(e));
      } else {
        parent.setRight(createNewNode(e));
      }
    }

    size++;
    return true; // Element inserted successfully
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  /** In-order traversal from the root */
  public String inOrder() {
    return inOrder(root);
  }

  /** In-order traversal from a subtree */
  protected String inOrder(TreeNode<E> root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(inOrder(root.getLeft()));
    sb.append(root.getElement() + " ");
    sb.append(inOrder(root.getRight()));

    return sb.toString();
  }

  /** Post-order traversal from the root */
  public String postOrder() {
    return postOrder(root);
  }

  /** Post-order traversal from a subtree */
  protected String postOrder(TreeNode<E> root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(inOrder(root.getLeft()));
    sb.append(inOrder(root.getRight()));
    sb.append(root.getElement() + " ");

    return sb.toString();
  }

  /** Pre-order traversal from the root */
  public String preOrder() {
    return preOrder(root);
  }

  /** Pre-order traversal from a subtree */
  protected String preOrder(TreeNode<E> root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(root.getElement() + " ");
    sb.append(inOrder(root.getLeft()));
    sb.append(inOrder(root.getRight()));

    return sb.toString();
  }

  @Override /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode<E> getRoot() {
    return root;
  }

  /** Returns a path from the root leading to the specified element */
  public List<TreeNode<E>> path(E e) {
    ArrayList<TreeNode<E>> list = new ArrayList<>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (c.compare(e, current.getElement()) < 0) {
        current = current.getLeft();
      } else if (c.compare(e, current.getElement()) > 0) {
        current = current.getRight();
      } else {
        break;
      }
    }

    return list; // Return an array list of nodes
  }

  /**
   * Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree
   */
  @Override
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (c.compare(e, current.getElement()) < 0) {
        parent = current;
        current = current.getLeft();
      } else if (c.compare(e, current.getElement()) > 0) {
        parent = current;
        current = current.getRight();
      } else {
        break; // Element is in the tree pointed at by current
      }
    }

    if (current == null) {
      return false; // Element is not in the tree
    }

    // Case 1: current has no left child
    if (current.getLeft() == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.getRight();
      } else {
        if (c.compare(e, parent.getElement()) < 0) {
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

  /** Obtain an iterator. Use in-order. */
  @Override
  public java.util.Iterator<E> iterator() {
    return new InOrderIterator<>(root);
  }

  /** Remove all elements from the tree */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }
}
