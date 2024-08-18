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
package edu.csc1061.ch18;

// Recursive Binary Search
public class Ch18Program06 {

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return binarySearch(list, key, low, high);
    }

    private static int binarySearch(int[] list, int key, int low, int high) {
        // The list has been exhausted without a match
        if (low > high) {
            return -low - 1;
        }

        int mid = (low + high) / 2;

        if (key == list[mid]) {
            return mid;
        }
        if (key < list[mid]) {
            return binarySearch(list, key, low, mid - 1);
        }

        return binarySearch(list, key, mid + 1, high);
    }

    /** Main method */
    public static void main(String[] args) {
        int[] list = {3, 5, 7, 8, 12, 17, 24, 29};
        System.out.println(binarySearch(list, 7));
        System.out.println(binarySearch(list, 0));
        System.out.println(binarySearch(list, 6));
    }
}
