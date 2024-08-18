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
package edu.csc1061.ch23;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Insertion Sort
public class Ch23Program01 {

    /**
     * The method for sorting the numbers
     *
     * @param list is an array of integers.
     */
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {

            // insert list[i] into a sorted sub-list list[0..i-1] so that
            // list[0..i] is sorted.

            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;
            printArray(list);
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
        int numberOfValues = 10;

        Set<Integer> randomList = new HashSet<>();

        while (randomList.size() < numberOfValues) {
            randomList.add(random.nextInt(10, 99));
        }

        int[] list = randomList.stream().mapToInt(Integer::intValue).toArray();

        printArray(list);
        System.out.println("=============================");
        insertionSort(list);
        System.out.println("=============================");
        printArray(list);
    }
}
