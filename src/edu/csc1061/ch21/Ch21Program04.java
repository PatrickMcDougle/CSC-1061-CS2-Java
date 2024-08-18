/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import edu.csc1061.utils.Timer;

/// Testing Set List Performance!
public class Ch21Program04 {
    static final int N = 40_000;
    static final String TEST_TIME = " - Member test time is   : ";
    static final String ELEMENT_TIME = " - Remove element time is: ";

    public static void main(String[] args) {
        // Add numbers 0, 1, 2, ..., N - 1 to the array list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        Collections.shuffle(list); // Shuffle the array list

        // Create a hash set, and test its performance
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("__HASH_SET__");
        System.out.println(TEST_TIME + printTime(getTestTime(set1)));
        System.out.println(ELEMENT_TIME + printTime(getRemoveTime(set1)));

        // Create a linked hash set, and test its performance
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("__LINKED_HASH_SET__");
        System.out.println(TEST_TIME + printTime(getTestTime(set2)));
        System.out.println(ELEMENT_TIME + printTime(getRemoveTime(set2)));

        // Create a tree set, and test its performance
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("__TREE_SET__");
        System.out.println(TEST_TIME + printTime(getTestTime(set3)));
        System.out.println(ELEMENT_TIME + printTime(getRemoveTime(set3)));

        // Create an array list, and test its performance
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("__ARRAY_LIST__");
        System.out.println(TEST_TIME + printTime(getTestTime(list1)));
        System.out.println(ELEMENT_TIME + printTime(getRemoveTime(list1)));

        // Create a linked list, and test its performance
        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("__LINKED_LIST__");
        System.out.println(TEST_TIME + printTime(getTestTime(list2)));
        System.out.println(ELEMENT_TIME + printTime(getRemoveTime(list2)));

        System.out.println("DONE");
    }

    public static int getTestTime(Collection<Integer> c) {
        Timer.getTimer().start();

        // Test if a number is in the collection
        for (int i = 0; i < N; i++) {
            double randomValue = Math.random();
            c.contains((int) (randomValue * 2 * N));
        }

        Timer.getTimer().finish();
        return Timer.getTimer().getElapsedTime();
    }

    public static int getRemoveTime(Collection<Integer> c) {
        Timer.getTimer().start();

        for (int i = 0; i < N; i++) {
            c.remove(i);
        }

        Timer.getTimer().finish();
        return Timer.getTimer().getElapsedTime();
    }

    public static String printTime(long timeInMilliseconds) {
        StringBuilder sb = new StringBuilder();

        if (timeInMilliseconds < 1000) {
            sb.append(timeInMilliseconds + " milliseconds");
        } else {
            sb.append((timeInMilliseconds * 0.001) + " seconds");
        }

        return sb.toString();
    }
    /// 100_000 elements:
    // __HASH_SET__
    // - Member test time is : 16 milliseconds
    // - Remove element time is: 24 milliseconds
    // __LINKED_HASH_SET__
    // - Member test time is : 15 milliseconds
    // - Remove element time is: 18 milliseconds
    // __TREE_SET__
    // - Member test time is : 34 milliseconds
    // - Remove element time is: 16 milliseconds
    // __ARRAY_LIST__
    // - Member test time is : 19.078 seconds
    // - Remove element time is: 6.104 seconds
    // __LINKED_LIST__
    // - Member test time is : 30.716 seconds
    // - Remove element time is: 14.397 seconds

}
