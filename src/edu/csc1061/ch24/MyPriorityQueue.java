package edu.csc1061.ch24;

// import java.util.Comparator;

public class MyPriorityQueue<E extends Comparable<E>> {
  private MyHeap<E> heap;

  public MyPriorityQueue() {
    heap = new MyHeap<E>();
  }

  //  public MyPriorityQueue(Comparator<E> c) {
  //    heap = new MyHeap<E>(c);
  //  }

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
