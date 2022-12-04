package edu.csc1061.ch25;

public class Program25_004 {

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

    for (String name : tree) {
      System.out.println(name.toUpperCase() + " ");
    }
  }
}
