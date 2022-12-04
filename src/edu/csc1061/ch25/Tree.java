package edu.csc1061.ch25;

/** Define a Huffman coding tree */
public class Tree implements Comparable<Tree> {
  private Node root; // The root of the tree

  /** Create a tree with two subtrees */
  public Tree(Tree t1, Tree t2) {
    root = new Node();
    root.left = t1.root;
    root.right = t2.root;
    root.weight = t1.root.weight + t2.root.weight;
  }

  /** Create a tree containing a leaf node */
  public Tree(int weight, char element) {
    root = new Node(weight, element);
  }

  public Node getRoot() {
    return root;
  }

  /** Compare trees based on their weights */
  @Override
  public int compareTo(Tree t) {
    if (root.weight < t.root.weight) { // Purposely reverse the order
      return 1;
    }
    if (root.weight == t.root.weight) {
      return 0;
    }
    return -1;
  }
}
