/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch25;

public class Ch25Program02 {

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

    printTree(tree);

    System.out.println("After delete Noah:");
    tree.delete("Noah");
    printTree(tree);

    System.out.println("After delete Emma:");
    tree.delete("Emma");
    printTree(tree);

    System.out.println("After delete Amelia:");
    tree.delete("Amelia");
    printTree(tree);

    System.out.println();
  }

  public static void printTree(BinarySearchTree<String> tree) {
    // Traverse tree
    System.out.println("The number of nodes is " + tree.getSize());
    System.out.println();

    // Traverse tree
    System.out.println("InOrder (sorted): " + tree.inOrder());
    System.out.println("PostOrder       : " + tree.postOrder());
    System.out.println("PreOrder        : " + tree.preOrder());
    System.out.println();
  }
}
