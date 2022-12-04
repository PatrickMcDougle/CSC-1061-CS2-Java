package edu.csc1061.ch25;

public class Node {
	char element; // Stores the character for a leaf node
	int weight; // weight of the subtree rooted at this node
	Node left; // Reference to the left subtree
	Node right; // Reference to the right subtree
	String code = ""; // The code of this node from the root

	/** Create an empty node */
	public Node() {}

	/** Create a node with the specified weight and character */
	public Node(int weight, char element) {
		this.weight = weight;
		this.element = element;
	}
}
