/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch07;

public class Ch07Listing8SelectionSort {

  public static void main(String[] args) {
    double[] list = {
      3.4, 3.5, 3.6, 1.1, 1.2, 1.3, 4.5, 4.6, 4.7, 2.3, 2.4, 2.5, 5.6, 5.7, 5.8, 9.9, 6.7, 6.8, 6.9
    };

    printArray(list);
    selectionSort(list);
    printArray(list);
  }

  public static void printArray(double[] list) {

    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i]);
      System.out.print(" ");
    }
    System.out.println();
  }

  public static void selectionSort(double[] list) {
    for (int i = 0; i < list.length - 1; i++) {
      // find the minimum in the list[i..list.length-1]
      double currentMin = list[i];
      int currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      // swap list[i] with list[currentMinIndex] if necessary
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
  }
}
