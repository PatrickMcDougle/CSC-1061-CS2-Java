package edu.csc1061.ch24;

import java.util.Comparator;

public class MyPriorityQueue<E extends Comparable<E>> {
  private MyHeap<E> heap;

  public MyPriorityQueue() {
    heap = new MyHeap<>();
  }

  public MyPriorityQueue(Comparator<E> c) {
    heap = new MyHeap<>(c);
  }

  public void enqueue(E newObject) {
    heap.add(newObject);
  }

  public E dequeue() {
    return heap.remove();
  }

  public int getSize() {
    return heap.getSize();
  }
}
