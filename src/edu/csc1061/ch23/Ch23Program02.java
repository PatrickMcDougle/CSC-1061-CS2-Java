/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch23;

import java.util.Random;

// Bubble Sort
public class Ch23Program02 {

  /** Bubble sort method */
  public static void bubbleSort(int[] list) {
    boolean needNextPass = true;

    for (int k = 1; k < list.length && needNextPass; k++) {
      // Array may be sorted and next pass not needed
      needNextPass = false;
      for (int i = 0; i < list.length - k; i++) {
        if (list[i] > list[i + 1]) {
          // Swap list[i] with list[i + 1]
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;

          needNextPass = true; // Next pass still needed
        }
      }
      printArray(list);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
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
    int numberOfValues = 10;

    int[] list = new int[numberOfValues];

    for (int i = 0; i < numberOfValues; ++i) {
      list[i] = random.nextInt(10, 99);
    }

    printArray(list);
    System.out.println("=============================");
    bubbleSort(list);
    System.out.println("=============================");
    printArray(list);
  }
}
