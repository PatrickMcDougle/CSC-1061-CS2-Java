package edu.csc1061.ch23;

import java.util.Comparator;
import java.util.Random;

// Heap Sort
@SuppressWarnings("unchecked")
public class Ch23Program05 {

  /** Heap sort method */
  public static <E> void heapSort(E[] list) {
    // Create a Heap of integers
    heapSort(list, (e1, e2) -> ((Comparable<E>) e1).compareTo(e2));
  }

  /** Heap sort method */
  public static <E> void heapSort(E[] list, Comparator<E> c) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<>(c);

    printArray(list);

    // Add elements to the heap
    for (int i = 0; i < list.length; i++) {
      heap.add(list[i]);
    }

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }

    printArray(list);
  }

  public static <E> void printArray(E[] list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.length; i++) {
      sb.append(list[i]);
      sb.append(" ");
    }
    System.out.println(sb.toString());
  }

  /** A test method */
  public static void main(String[] args) {
    Random random = new Random();
    int numberOfValues = 20;

    Integer[] list = new Integer[numberOfValues];

    for (int i = 0; i < numberOfValues; ++i) {
      list[i] = random.nextInt(10, 99);
    }

    printArray(list);
    System.out.println("=============================");
    heapSort(list);
    System.out.println("=============================");
    printArray(list);
  }
}
