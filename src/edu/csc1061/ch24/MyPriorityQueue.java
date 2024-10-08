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

    public void enqueue(E e) {
        heap.add(e);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }

    @Override
    public String toString() {
        return "Priority Queue: " + heap.toString();
    }
}
