package edu.csc1061.ch25;

import java.util.Scanner;

public class TestBinarySearchTreeWithHeight {

  public static void main(String[] args) {
    BinarySearchTreeWithHeight<String> tree = new BinarySearchTreeWithHeight<>();
    System.out.print("The height of an empty tree is " + tree.height());

    tree.insert("Green");
    System.out.print(
      "\nThe height of the tree with one node is " + tree.height()
    );

    tree.insert("Red");
    System.out.print(
      "\nThe height of the tree with two nodes is " + tree.height()
    );

    Scanner input = new Scanner(System.in);

    System.out.print("\nEnter six strings: ");
    for (int i = 0; i < 6; i++) {
      String s = input.next();
      tree.insert(s.trim());
    }

    input.close();

    System.out.print("The height of tree is " + tree.height());

    BinarySearchTreeWithHeight<String> tree1 = new BinarySearchTreeWithHeight<>(
      new String[] {
        "Tom",
        "George",
        "Jean",
        "Jane",
        "Kevin",
        "Peter",
        "Susan",
        "Jen",
        "Kim",
        "Michael",
        "Michelle",
      }
    );
    System.out.print("\nThe height of tree1 is " + tree1.height());

    BinarySearchTreeWithHeight<Integer> tree2 = new BinarySearchTreeWithHeight<>(
      new Integer[] { 50, 45, 35, 48, 59, 51, 58 }
    );
    System.out.print("\nThe height of tree2 is " + tree2.height());
  }
}
