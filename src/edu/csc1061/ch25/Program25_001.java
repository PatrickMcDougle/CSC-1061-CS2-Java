package edu.csc1061.ch25;

import java.util.List;

public class Program25_001 {
  private static final String NAME_CHARLOTTE = "Charlotte";

  public static void main(String[] args) {
    // Create a BST
    BinarySearchTree<String> tree = new BinarySearchTree<>();
    tree.insert("Liam");
    tree.insert("Olivia");
    tree.insert("Noah");
    tree.insert("Emma");
    tree.insert("Oliver");
    tree.insert(NAME_CHARLOTTE);
    tree.insert("Elijah");
    tree.insert("Amelia");

    System.out.println("The number of nodes is " + tree.getSize());
    System.out.println();

    // Traverse tree
    System.out.println("InOrder (sorted): " + tree.inOrder());
    System.out.println("PostOrder       : " + tree.postOrder());
    System.out.println("PreOrder        : " + tree.preOrder());
    System.out.println();

    // Search for an element
    System.out.println("Is Peter in the tree? " + tree.search("Peter"));
    System.out.println(
      "Is Charlotte in the tree? " + tree.search(NAME_CHARLOTTE)
    );
    System.out.println();

    // Get a path from the root to Peter
    System.out.print("A path from the root to Charlotte is: ");
    List<TreeNode<String>> path = tree.path(NAME_CHARLOTTE);
    for (int i = 0; path != null && i < path.size(); i++) {
      System.out.print(path.get(i).getElement() + " ");
    }
    System.out.println("\n");

    Integer[] numbers = { 2, 4, 3, 1, 8, 5, 6, 7 };
    BinarySearchTree<Integer> intTree = new BinarySearchTree<>(numbers);
    System.out.println("InOrder (sorted): " + intTree.inOrder());
  }
}
