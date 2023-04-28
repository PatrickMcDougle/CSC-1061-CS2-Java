package edu.csc1061.ch25;

import java.util.Iterator;

public class Ch25Program04 {

  public static void main(String[] args) {
    // Create a BST
    BinarySearchTree<String> tree = new BinarySearchTree<>();
    tree.insert("Liam");
    tree.insert("Olivia");
    tree.insert("Noah");
    tree.insert("Emma");
    tree.insert("Oliver");
    tree.insert("Charlotte");
    tree.insert("Elijah");
    tree.insert("Amelia");

    System.out.println("\n ===== Upper Case =====");
    for (String name : tree) {
      System.out.print(name.toUpperCase() + " ");
    }

    System.out.println("\n ===== Lower Case =====");

    for (String name : tree) {
      System.out.print(name.toLowerCase() + " ");
    }

    System.out.println("\n ===== Delete Third Name =====");

    Iterator<String> iterator = tree.iterator();
    // print the first three items.
    for (int i = 0; i < 3; i++) {
      String name = iterator.next();
      System.out.print(name + " ");
    }
    // remove/delete the third item.
    iterator.remove();
    // print the rest of the items.
    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.print(name + " ");
    }

    System.out.println("\n ===== After Delete =====");

    // print out the names of the list after the third item was deleted.
    for (String name : tree) {
      System.out.print(name + " ");
    }

    System.out.println("\n ===== Done =====\n");
  }
}
