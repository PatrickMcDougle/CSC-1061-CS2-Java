/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch10;

/**
 * This class is called TestStackOfIntegers in the book.
 * Listing 10.7
 */
public class Ch10Program04 {

  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers();

    for (int i = 0; i < 10; i++) {
      stack.push(i); // Push i to the stack
    }

    // Test if stack is empty
    while (!stack.empty()) {
      // Remove and return from stack
      System.out.print(stack.pop() + " ");
    }
  }
}
