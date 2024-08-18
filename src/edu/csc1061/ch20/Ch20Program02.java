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
package edu.csc1061.ch20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// This example creates an array list filled with numbers, and inserts new
// elements into the specified location in the list.
// The example also creates a linked list from the array list, inserts and
// removes the elements from the list.
// Finally, the example traverses the list forward and backward.

public class Ch20Program02 {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            arrayList.add(i);
        }
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0, 10);
        arrayList.add(3, 30);

        System.out.println("\n ========== ========== ========== ==:");
        whileVersion(arrayList);
        System.out.println("\n ---------- ---------- ---------- --:");
        forEachVersion(arrayList);
        System.out.println("\n ========== ========== ========== ==:");
    }

    private static void whileVersion(List<Integer> arrayList) {
        System.out.print("A list of integers in the array list: ");
        System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.removeLast();
        linkedList.addFirst("green");

        System.out.print("Display the linked list forward     : ");
        ListIterator<Object> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        System.out.print("Display the linked list backward    : ");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }

    // Lambda Expression:
    // parameter -> expression
    // https://www.w3schools.com/java/java_lambda.asp
    private static void forEachVersion(List<Integer> arrayList) {
        System.out.print("A list of integers in the array list: ");
        System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.removeLast();
        linkedList.addFirst("green");

        System.out.print("Display the linked list forward     : ");
        linkedList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.print("Display the linked list backward    : ");
        Collections.reverse(linkedList);
        linkedList.forEach(x -> System.out.print(x + " "));
    }
}
