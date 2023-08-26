/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch24;

import java.util.Scanner;

public class TestMyList {
  private static final String LIST_ONE = "list1: ";
  private static final String LIST_TWO = "list2: ";

  public static void main(String[] args) {
    new TestMyList();
  }

  public TestMyList() {
    Scanner input = new Scanner(System.in);
    String[] name1 = new String[5];
    String[] name2 = new String[5];
    String[] name3 = new String[2];
    System.out.print("Enter five strings for array name1 separated by space: ");
    for (int i = 0; i < 5; i++) {
      name1[i] = input.next();
    }

    System.out.print("Enter five strings for array name2 separated by space: ");
    for (int i = 0; i < 5; i++) {
      name2[i] = input.next();
    }

    System.out.print("Enter two strings for array name3 separated by space: ");
    for (int i = 0; i < 2; i++) {
      name3[i] = input.next();
    }

    input.close();

    MyList<String> list1 = new MyArrayList<>(name1);
    MyList<String> list2 = new MyArrayList<>(name2);
    System.out.println(LIST_ONE + list1);
    System.out.println(LIST_TWO + list2);
    list1.addAll(list2);
    System.out.println("After addAll: list1 is " + list1 + "\n");

    list1 = new MyArrayList<>(name1);
    list2 = new MyArrayList<>(name2);
    System.out.println(LIST_ONE + list1);
    System.out.println(LIST_TWO + list2);
    list1.removeAll(list2);
    System.out.println("After removeAll: list1 is " + list1 + "\n");

    list1 = new MyArrayList<>(name1);
    list2 = new MyArrayList<>(name2);
    System.out.println(LIST_ONE + list1);
    System.out.println(LIST_TWO + list2);
    list1.retainAll(list2);
    System.out.println("After retainAll: list1 is " + list1 + "\n");

    list1 = new MyArrayList<>(name1);
    list2 = new MyArrayList<>(name2);
    System.out.println(LIST_ONE + list1);
    System.out.println(LIST_TWO + list2);
    list1.retainAll(list2);
    System.out.println(
        "list1 contains all list2? " + list1.containsAll(list2) + "\n");

    list1 = new MyArrayList<>(name1);
    list2 = new MyArrayList<>(name3);
    System.out.println(LIST_ONE + list1);
    System.out.println(LIST_TWO + list2);
    System.out.println(
        "list1 contains all list2? " + list1.containsAll(list2) + "\n");

    Object[] name4 = list1.toArray();
    System.out.print("name4: ");
    for (Object e : name4) {
      System.out.print(e + " ");
    }

    String[] name5 = new String[list1.size()];
    String[] name6 = list1.toArray(name5);
    System.out.print("\nname6: ");
    for (Object e : name6) {
      System.out.print(e + " ");
    }
  }
}
