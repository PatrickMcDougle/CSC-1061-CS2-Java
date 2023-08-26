/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
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
    PriorityQueue<String> queue1 = new PriorityQueue<>();
    queue1.offer("Denver");
    queue1.offer("Boulder");
    queue1.offer("Loveland");
    queue1.offer("Greeley");
    queue1.offer("Colorado Springs");
    queue1.offer("Fort Collins");
    queue1.offer("Littleton");
    queue1.offer("Castle Rock");
    queue1.offer("Avon");

    System.out.println("Priority queue using Comparable:");
    while (!queue1.isEmpty()) {
      System.out.print(queue1.remove() + " | ");
    }
  }

  private static void priorityQueueUsingComparator() {
    PriorityQueue<String> queue2 = new PriorityQueue<>(4, Collections.reverseOrder());
    queue2.offer("Las Cruces");
    queue2.offer("Orlando");
    queue2.offer("Keene");
    queue2.offer("Trona");
    queue2.offer("Sandy");
    queue2.offer("Littleton");
    queue2.offer("Greeley");
    queue2.offer("Rockwall");
    queue2.offer("New Orleans");

    System.out.println("Priority queue using Comparator:");
    while (!queue2.isEmpty()) {
      System.out.print(queue2.remove() + " | ");
    }
  }
}
