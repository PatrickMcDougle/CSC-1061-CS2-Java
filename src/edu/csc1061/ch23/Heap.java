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
package edu.csc1061.ch23;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class Heap<E> {
  private ArrayList<E> list = new ArrayList<>();
  private Comparator<? super E> comparator;

  /** Create a default heap using a natural order for comparison */
  public Heap() {
    this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
  }

  /**
   * Create a heap from an array of objects
   *
   * @param objects
   */
  public Heap(E[] objects) {
    this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  /**
   * Create a heap with a specified comparator
   *
   * @param c
   */
  public Heap(Comparator<E> c) {
    this.comparator = c;
  }

  /**
   * Add a new object into the heap
   *
   * @param newObject
   */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    int currentIndex = list.size() - 1; // The index of the last node

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      // Swap if the current object is greater than its parent
      if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      } else {
        break; // The tree is a heap now
      }

      currentIndex = parentIndex;
    }
  }

  /**
   * Remove the root from the heap
   *
   * @return
   */
  public E remove() {
    if (list.isEmpty()) {
      return null;
    }

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);


    int currentIndex = 0;
    int leftChildIndex = 2 * currentIndex + 1;
    int rightChildIndex = 2 * currentIndex + 2;
    while (currentIndex < list.size() && leftChildIndex < list.size()) {

      int maxIndex = leftChildIndex;

      if (rightChildIndex < list.size()
          && comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
        maxIndex = rightChildIndex;
      }

      if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) >= 0) {
        break; // The tree is a heap
      }

      // Swap if the current node is less than the maximum
      E temp = list.get(maxIndex);
      list.set(maxIndex, list.get(currentIndex));
      list.set(currentIndex, temp);
      currentIndex = maxIndex;
      leftChildIndex = 2 * currentIndex + 1;
      rightChildIndex = 2 * currentIndex + 2;
    }

    return removedObject;
  }

  /**
   * Get the number of nodes in the tree
   *
   * @return
   */
  public int getSize() {
    return list.size();
  }

  /**
   * Return true if heap is empty
   *
   * @return
   */
  public boolean isEmpty() {
    return list.isEmpty();
  }
}
