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

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Heap Sort
@SuppressWarnings("unchecked")
public class Ch23Program05 {

    /**
     * Heap sort method
     *
     * @param <E>
     * @param list is an array of something
     */
    public static <E> void heapSort(E[] list) {
        // Call other method for heapSort and pass in the comparison method.
        heapSort(list, (e1, e2) -> ((Comparable<E>) e1).compareTo(e2));
    }

    /**
     * Heap sort method
     *
     * @param <E>
     * @param list is an array of something
     * @param c how to sort things
     */
    public static <E> void heapSort(E[] list, Comparator<E> c) {
        // Create a Heap of elements
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

    /**
     * This method will print the items in the array.
     *
     * @param <E>
     * @param list is an array of elements to be printed/displayed.
     */
    public static <E> void printArray(E[] list) {
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

        Integer[] list = new Integer[numberOfValues];

        Set<Integer> randomList = new HashSet<>();

        while (randomList.size() < numberOfValues) {
            randomList.add(random.nextInt(10, 99));
        }

        randomList.toArray(list);

        printArray(list);
        System.out.println("=============================");
        heapSort(list);
        System.out.println("=============================");
        printArray(list);
    }
}
