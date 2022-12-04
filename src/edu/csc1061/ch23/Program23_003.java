package edu.csc1061.ch23;

import java.util.Random;

// Merge Sort
public class Program23_003 {

  /** The method for sorting the numbers */
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

  /** Merge two sorted lists */
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

  public static void printArray(int[] list) {
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
    int numberOfValues = 16;

    int[] list = new int[numberOfValues];

    for (int i = 0; i < numberOfValues; ++i) {
      list[i] = random.nextInt(10, 99);
    }

    printArray(list);
    System.out.println("=============================");
    mergeSort(list);
    System.out.println("=============================");
    printArray(list);
  }
}
