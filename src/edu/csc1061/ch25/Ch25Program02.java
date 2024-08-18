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

        tree.delete("Noah");
        System.out.println("After delete Noah:");
        printTree(tree);

        tree.delete("Emma");
        System.out.println("After delete Emma:");
        printTree(tree);

        tree.delete("Amelia");
        System.out.println("After delete Amelia:");
        printTree(tree);

        System.out.println();
    }

    public static void printTree(BinarySearchTree<String> tree) {
        System.out.println();
        System.out.println("The number of nodes is " + tree.getSize());

        // Traverse tree
        System.out.println("InOrder (sorted): " + tree.inOrder());
        System.out.println("PostOrder       : " + tree.postOrder());
        System.out.println("PreOrder        : " + tree.preOrder());
        System.out.println();
        System.out.println(tree.printAsciiTree());
    }
}
