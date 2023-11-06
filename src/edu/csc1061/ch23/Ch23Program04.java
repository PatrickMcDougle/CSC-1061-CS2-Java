/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch23;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Quick Sort
public class Ch23Program04 {

  /**
   * @param list
   */
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  /**
   * @param list
   * @param first
   * @param last
   */
  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  /**
   * Partition the array list[first..last]
   *
   * @param list
   * @param first
   * @param last
   * @return
   */
  private static int partition(int[] list, int first, int last) {
    printArray(list);
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot) {
        low++;
      }

      // Search backward from right
      while (low <= high && list[high] > pivot) {
        high--;
      }

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot) {
      high--;
    }

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }

    return first;
  }

  /**
   * This method will print the items in the array.
   *
   * @param list is an array of integers.
   */
  public static void printArray(int[] list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.length; i++) {
      sb.append(list[i]);
      sb.append(" ");
    }
    System.out.println(sb.toString());
  }

  /**
   * The main method for this application.
   *
   * @param args arguments from the command line. Not used.
   */
  public static void main(String[] args) {
    Random random = new Random();
    int numberOfValues = 20;

    Set<Integer> randomList = new HashSet<>();

    while (randomList.size() < numberOfValues) {
      randomList.add(random.nextInt(10, 99));
    }

    int[] list = randomList.stream().mapToInt(Integer::intValue).toArray();

    printArray(list);
    System.out.println("=============================");
    quickSort(list);
    System.out.println("=============================");
    printArray(list);
  }
}
