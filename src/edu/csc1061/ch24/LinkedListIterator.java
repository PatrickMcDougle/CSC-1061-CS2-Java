package edu.csc1061.ch24;

import java.util.NoSuchElementException;

public class LinkedListIterator<E> implements java.util.Iterator<E> {
  private Node<E> current; // Current index

  public LinkedListIterator(Node<E> head) {
    current = head;
  }

  @Override
  public boolean hasNext() {
    return (current != null);
  }

  @Override
  public E next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    E e = current.element;
    current = current.next;
    return e;
  }

  @Override
  public void remove() {
    // Left as an exercise
    // WRITE YOUR CODE HERE
  }
}
