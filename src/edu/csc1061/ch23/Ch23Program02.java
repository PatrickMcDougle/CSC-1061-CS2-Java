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

// Bubble Sort
public class Ch23Program02 {

    /**
     * Bubble sort method
     *
     * @param list is an array of integers.
     */
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
                // Auto-generated catch block
                System.err.println(e.getMessage());

                // set the flag back to true
                Thread.currentThread().interrupt();
            }
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
        bubbleSort(list);
        System.out.println("=============================");
        printArray(list);
    }
}
