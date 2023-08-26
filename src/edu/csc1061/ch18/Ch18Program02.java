/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch18;

import java.util.Scanner;

// Computer Fibonacci
public class Ch18Program02 {

  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter an index for a Fibonacci number: ");
      int index = input.nextInt();

      // Find and display the Fibonacci number
      System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
    }
  }

  // fib(0) = 0
  // fib(1) = 1
  // fib(n) = fib(n -1) + fib(n -2) // where n >= 2

  /** The method for finding the Fibonacci number */
  public static long fib(long index) {
    // Base case
    if (index == 0) {
      return 0;
    }
    // Base case
    if (index == 1) {
      return 1;
    }

    // Reduction and recursive calls
    return fib(index - 1) + fib(index - 2);
  }
}
