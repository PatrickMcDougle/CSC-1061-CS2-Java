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

        // for loop example
        System.out.println("\n     ===== For Loop (toUpperCase) =====");
        for (String name : tree) {
            System.out.print(name.toUpperCase() + " ");
        }

        // for each lambda example
        System.out.println("\n     ===== ForEach Lambda Loop (toLowerCase) =====");
        tree.forEach(name -> System.out.print(name.toLowerCase() + " "));

        // using the iterator
        System.out.println("\n     ===== While Iterator Loop (just name) =====");
        Iterator<String> iterator = tree.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.print(name + " ");
        }

        System.out.println("\n\n     ===== Delete the Third Name =====");
        iterator = tree.iterator();
        // print the first three items.
        for (int i = 0; i < 3; i++) {
            String name = iterator.next();
            System.out.print(name + " ");
        }

        System.out.print("| ");
        // remove/delete the third item.
        iterator.remove();

        // print the rest of the items.
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.print(name + " ");
        }

        // print out the names of the list after the third item was deleted.
        System.out.println("\n     ===== After Delete =====");
        tree.forEach(name -> System.out.print(name + " "));

        System.out.println("\n\n     ===== Done =====\n");
    }
}
