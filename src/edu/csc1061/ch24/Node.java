/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch24;

public class Node<E> {
  E element;
  Node<E> next;

  public Node(E element) {
    this.element = element;
  }
}
