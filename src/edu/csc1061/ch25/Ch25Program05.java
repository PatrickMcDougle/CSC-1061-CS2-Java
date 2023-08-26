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

import java.util.Scanner;

import edu.csc1061.ch23.Heap;

// HuffmanCode
public class Ch25Program05 {

  public static final int ASCII_ARRAY_SIZE = 128;

  public static void main(String[] args) {
    String text;
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a text: ");
      // example: Pneumonoultramicroscopicsilicovolcanoconiosis
      // example: supercalifragilisticexpialidocious
      text = input.nextLine();
    }

    int[] counts = getCharacterFrequency(text); // Count frequency

    HuffmanTree tree = getHuffmanTree(counts); // Create a Huffman tree
    String[] codes = getCode(tree.getRoot()); // Get codes

    System.out.printf(
        "%-15s%-15s%-15s%-15s%n",
        "ASCII Code",
        "Character",
        "Frequency",
        "Code");

    for (int i = 0; i < codes.length; i++) {
      if (counts[i] != 0) {
        // (char)i is not in text if counts[i] is 0
        System.out.printf(
            "%-15d%-15s%-15d%-15s%n",
            i,
            (char) i + "",
            counts[i],
            codes[i]);
      }
    }
  }

  /**
   * Get Huffman codes for the characters
   * This method is called once after a Huffman tree is built
   */
  public static String[] getCode(TreeNode<HuffmanElement> root) {
    if (root == null) {
      return new String[0];
    }

    String[] codes = new String[ASCII_ARRAY_SIZE];
    assignCode(root, codes);
    return codes;
  }

  /* Recursively get codes to the leaf node */
  private static void assignCode(TreeNode<HuffmanElement> root, String[] codes) {
    if (root.getLeft() != null) {
      root.getLeft().getElement().setCode(root.getElement().getCode() + "0");
      assignCode(root.getLeft(), codes);

      root.getRight().getElement().setCode(root.getElement().getCode() + "1");
      assignCode(root.getRight(), codes);
    } else {
      codes[root.getElement().getLeafValue()] = root.getElement().getCode();
    }
  }

  /** Get a Huffman tree from the codes */
  public static HuffmanTree getHuffmanTree(int[] counts) {
    // Create a heap to hold trees
    Heap<HuffmanTree> heap = new Heap<>(); // Defined in Listing 24.10
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        heap.add(new HuffmanTree(counts[i], (char) i)); // A leaf node tree
      }
    }

    while (heap.getSize() > 1) {
      HuffmanTree t1 = heap.remove(); // Remove the smallest weight tree
      HuffmanTree t2 = heap.remove(); // Remove the next smallest weight
      heap.add(new HuffmanTree(t1, t2)); // Combine two trees
    }

    return heap.remove(); // The final tree
  }

  /** Get the frequency of the characters */
  public static int[] getCharacterFrequency(String text) {
    int[] counts = new int[ASCII_ARRAY_SIZE]; // ASCII_ARRAY_SIZE ASCII characters

    for (int i = 0; i < text.length(); i++) {
      counts[text.charAt(i)]++; // Count the character in text
    }

    return counts;
  }
}
