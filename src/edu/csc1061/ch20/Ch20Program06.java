/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch20;

import java.util.Collections;
import java.util.PriorityQueue;

public class Ch20Program06 {

  public static void main(String[] args) {
    System.out.println("\n ========== ========== ========== ");
    priorityQueueUsingComparable();
    System.out.println("\n ---------- ---------- ---------- ");
    priorityQueueUsingComparator();
    System.out.println("\n ========== ========== ========== ");
  }

  private static void priorityQueueUsingComparable() {
    PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer("Denver");
    priorityQueue.offer("Boulder");
    priorityQueue.offer("Colorado Springs");
    priorityQueue.offer("Greeley");
    priorityQueue.offer("Loveland");
    priorityQueue.offer("Littleton");
    priorityQueue.offer("Fort Collins");
    priorityQueue.offer("Castle Rock");
    priorityQueue.offer("Avon");

    System.out.println("Priority queue using Comparable:");
    while (!priorityQueue.isEmpty()) {
      System.out.print(priorityQueue.remove() + " | ");
    }
  }

  private static void priorityQueueUsingComparator() {
    PriorityQueue<String> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
    priorityQueue.offer("Las Cruces");
    priorityQueue.offer("Orlando");
    priorityQueue.offer("Keene");
    priorityQueue.offer("Trona");
    priorityQueue.offer("Sandy");
    priorityQueue.offer("Littleton");
    priorityQueue.offer("Greeley");
    priorityQueue.offer("Rockwall");
    priorityQueue.offer("New Orleans");

    System.out.println("Priority queue using Comparator:");
    while (!priorityQueue.isEmpty()) {
      System.out.print(priorityQueue.remove() + " | ");
    }
  }
}
