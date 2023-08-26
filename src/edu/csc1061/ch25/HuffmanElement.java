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

public class HuffmanElement {
  private final char leafValue; // Stores the character for a leaf node
  private final int weightValue; // weight of the subtree rooted at this node
  private String code = ""; // The code of this node from the root

  // ////////// ////////// //
  // Constructor
  // ////////// ////////// //

  /**
   * Create a node with the specified weight and character
   */
  public HuffmanElement(int weight, char element) {
    this.weightValue = weight;
    this.leafValue = element;
  }

  // ////////// ////////// //
  // Public Methods
  // ////////// ////////// //

  public char getLeafValue() {
    return leafValue;
  }

  public int getWeightValue() {
    return weightValue;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
