package edu.csc1061.ch25;

import java.util.Scanner;

// HuffmanCode
public class Program25_005 {

  public static void main(String[] args) {
    String text;
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a text: ");
      // example: Pneumonoultramicroscopicsilicovolcanoconiosis
      text = input.nextLine();
    }

    int[] counts = getCharacterFrequency(text); // Count frequency

    System.out.printf(
      "%-15s%-15s%-15s%-15s%n",
      "ASCII Code",
      "Character",
      "Frequency",
      "Code"
    );

    Tree tree = getHuffmanTree(counts); // Create a Huffman tree
    String[] codes = getCode(tree.getRoot()); // Get codes

    for (int i = 0; i < codes.length; i++) {
      if (counts[i] != 0) {
        // (char)i is not in text if counts[i] is 0
        System.out.printf(
          "%-15d%-15s%-15d%-15s%n",
          i,
          (char) i + "",
          counts[i],
          codes[i]
        );
      }
    }
  }

  /**
   * Get Huffman codes for the characters
   * This method is called once after a Huffman tree is built
   */
  public static String[] getCode(Node root) {
    if (root == null) {
      return new String[0];
    }

    String[] codes = new String[128];
    assignCode(root, codes);
    return codes;
  }

  /* Recursively get codes to the leaf node */
  private static void assignCode(Node root, String[] codes) {
    if (root.left != null) {
      root.left.code = root.code + "0";
      assignCode(root.left, codes);

      root.right.code = root.code + "1";
      assignCode(root.right, codes);
    } else {
      codes[root.element] = root.code;
    }
  }

  /** Get a Huffman tree from the codes */
  public static Tree getHuffmanTree(int[] counts) {
    // Create a heap to hold trees
    Heap<Tree> heap = new Heap<>(); // Defined in Listing 24.10
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        heap.add(new Tree(counts[i], (char) i)); // A leaf node tree
      }
    }

    while (heap.getSize() > 1) {
      Tree t1 = heap.remove(); // Remove the smallest weight tree
      Tree t2 = heap.remove(); // Remove the next smallest weight
      heap.add(new Tree(t1, t2)); // Combine two trees
    }

    return heap.remove(); // The final tree
  }

  /** Get the frequency of the characters */
  public static int[] getCharacterFrequency(String text) {
    int[] counts = new int[128]; // 128 ASCII characters

    for (int i = 0; i < text.length(); i++) {
      counts[text.charAt(i)]++; // Count the character in text
    }

    return counts;
  }
}
