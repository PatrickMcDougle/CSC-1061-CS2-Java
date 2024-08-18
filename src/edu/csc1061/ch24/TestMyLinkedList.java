/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch24;

import java.util.Scanner;

public class TestMyLinkedList {

    public static void main(String[] args) {
        new TestMyLinkedList();
    }

    public TestMyLinkedList() {
        String[] names = {"Tom", "Susan", "Kim", "George", "Peter", "Jean", "George", "Jane",
                "Denise", "Jenny", "Susan", "Kathy", "Jane",};
        MyList<String> list = new MyLinkedList<>(names);

        System.out.println(list);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = input.next();

        System.out.print("Enter an index: ");
        int index = input.nextInt();

        input.close();

        System.out.println(name + " is in the list? " + list.contains(name));
        System.out.println("name at index " + index + " is " + list.get(3));
        System.out.println(name + " is at index " + list.indexOf(name));
        System.out.println(name + " is at last index " + list.lastIndexOf(name));
        list.set(index, name);
    }
}
