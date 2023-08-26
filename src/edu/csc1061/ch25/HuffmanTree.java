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

/**
 * Define a Huffman coding tree
 */
public class HuffmanTree implements Comparable<HuffmanTree> {
  private TreeNode<HuffmanElement> root; // The root of the tree

  // ////////// ////////// //
  // Constructor
  // ////////// ////////// //

  /**
   * Create a tree with two subtrees
   */
  public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
    int newWeight = t1.getRoot().getElement().getWeightValue() + t2.getRoot().getElement().getWeightValue();
    HuffmanElement element = new HuffmanElement(newWeight, (char) 0);
    root = new TreeNode<>(element);
    root.setLeft(t1.root);
    root.setRight(t2.root);
  }

  /**
   * Create a tree containing a leaf node
   */
  public HuffmanTree(int weight, char element) {
    HuffmanElement huffmanElement = new HuffmanElement(weight, element);
    root = new TreeNode<>(huffmanElement);
  }

  // ////////// ////////// //
  // Public Methods
  // ////////// ////////// //

  public TreeNode<HuffmanElement> getRoot() {
    return root;
  }

  // ////////// ////////// //
  // Public Override Methods
  // ////////// ////////// //

  /**
   * Compare trees based on their weights
   */
  @Override
  public int compareTo(HuffmanTree that) {
    if (this.root.getElement().getWeightValue() < that.root.getElement().getWeightValue()) { // Purposely reverse the
                                                                                             // order
      return 1;
    }
    if (this.root.getElement().getWeightValue() == that.root.getElement().getWeightValue()) {
      return 0;
    }
    return -1;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof HuffmanTree that) {
      return this.root.equals(that.root) && this.root.getElement().equals(that.root.getElement());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return root.hashCode();
  }
}
