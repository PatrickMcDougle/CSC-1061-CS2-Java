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

public class Ch07Listing7BinarySearch {

  public static void main(String[] args) {
    int[] list = {4, 5, 6, 7, 8, 12, 34, 56, 78};

    System.out.println(binarySearch(list, 45));
    System.out.println(binarySearch(list, 78));
    System.out.println(binarySearch(list, 6));
  }

  /**
   * Use binary search to find the key in the list
   *
   * @param list is an array of integer values.
   * @param key is the key (value) we are looking for in the list.
   * @return the index where the key was found, or a negative value if not found.
   */
  public static int binarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;

    while (high >= low) {
      int mid = (low + high) / 2;
      if (key < list[mid]) {
        high = mid - 1;
      } else if (key == list[mid]) {
        return mid;
      } else {
        low = mid + 1;
      }
    }

    // now high < low, key was not found.
    return -low - 1;
  }
}
