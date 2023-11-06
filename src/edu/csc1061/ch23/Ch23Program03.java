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

// Merge Sort
public class Ch23Program03 {

  /**
   * The method for sorting the numbers
   *
   * @param list is an array of integers.
   */
  public static void mergeSort(int[] list) {
    if (list.length > 1) {
      System.out.print("  => ");
      printArray(list);
      
      // Merge sort the first half
      int[] firstHalf = new int[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      // Merge sort the second half
      int secondHalfLength = list.length - list.length / 2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list);

      System.out.print(" <=  ");
      printArray(list);
    }
  }

  /**
   * Merge two sorted lists
   *
   * @param list1 is an array of integers.
   * @param list2 is an array of integers.
   * @param temp is an array of integers.
   */
  public static void merge(int[] list1, int[] list2, int[] temp) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2]) {
        temp[current3++] = list1[current1++];
      } else {
        temp[current3++] = list2[current2++];
      }
    }

    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
    }
    while (current2 < list2.length) {
      temp[current3++] = list2[current2++];
    }
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
    int numberOfValues = 4;

    Set<Integer> randomList = new HashSet<>();

    while (randomList.size() < numberOfValues) {
      randomList.add(random.nextInt(10, 99));
    }

    int[] list = randomList.stream().mapToInt(Integer::intValue).toArray();

    printArray(list);
    System.out.println("=============================");
    mergeSort(list);
    System.out.println("=============================");
    printArray(list);
  }
}
