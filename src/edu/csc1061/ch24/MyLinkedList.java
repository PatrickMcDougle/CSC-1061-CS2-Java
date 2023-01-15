package edu.csc1061.ch24;

public class MyLinkedList<E> extends MyList<E> {
  protected Node<E> head;
  protected Node<E> tail;
  protected int size = 0; // Number of elements in the list

  /** Create an empty list */
  public MyLinkedList() {}

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    return head.element;
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    return tail.element;
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) { // the new node is the only node in list
      tail = head;
    }
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    } else {
      tail.next = newNode; // Link the new with the last node
      tail = newNode; // tail now points to the last node
    }

    size++; // Increase size
  }

  /**
   * Add a new element at the specified index in this list. The index of the head element is 0
   */
  @Override
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    } else if (index >= size) {
      addLast(e);
    } else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /**
   * Remove the head node and return the object that is contained in the removed node.
   */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }

    E temp = head.element;
    head = head.next;
    size--;
    if (head == null) {
      tail = null;
    }
    return temp;
  }

  /**
   * Remove the last node and return the object that is contained in the removed node.
   */
  public E removeLast() {
    if (size == 0) {
      return null;
    }

    if (size == 1) {
      E temp = head.element;
      head = tail = null;
      size = 0;
      return temp;
    }

    Node<E> current = head;

    for (int i = 0; i < size - 2; i++) {
      current = current.next;
    }

    E temp = tail.element;
    tail = current;
    tail.next = null;
    size--;
    return temp;
  }

  /**
   * Remove the element at the specified position in this list. Return the element that was
   * removed from the list.
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }

    Node<E> previous = head;

    for (int i = 1; i < index; i++) {
      previous = previous.next;
    }

    Node<E> current = previous.next;
    previous.next = current.next;
    size--;
    return current.element;
  }

  /** Override toString() to return elements in the list */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      sb.append(current.element);
      current = current.next;
      if (current != null) {
        sb.append(", "); // Separate two elements with a comma
      } else {
        sb.append("]"); // Insert the closing ] in the string
      }
    }

    return sb.toString();
  }

  /** Clear the list */
  @Override
  public void clear() {
    size = 0;
    head = tail = null;
  }

  /** Return true if this list contains the element e */
  @Override
  public boolean contains(Object e) {
    // Left as an exercise
    // WRITE YOUR CODE HERE
    return false;
  }

  /** Return the element at the specified index */
  @Override
  public E get(int index) {
    // Left as an exercise
    // WRITE YOUR CODE HERE
    return null;
  }

  /**
   * Return the index of the first matching element in this list. Return -1 if no match.
   */
  @Override
  public int indexOf(Object e) {
    // Left as an exercise
    // WRITE YOUR CODE HERE
    return 0;
  }

  /**
   * Return the index of the last matching element in this list. Return -1 if no match.
   */
  @Override
  public int lastIndexOf(E e) {
    // Left as an exercise
    // WRITE YOUR CODE HERE
    return 0;
  }

  /**
   * Replace the element at the specified position in this list with the specified element.
   */
  @Override
  public E set(int index, E e) {
    // Left as an exercise
    // WRITE YOUR CODE HERE
    return null;
  }

  /** Override iterator() defined in Iterable */
  @Override
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator<>(head);
  }

  /** Return the number of elements in this list */
  @Override
  public int size() {
    return size;
  }
}
