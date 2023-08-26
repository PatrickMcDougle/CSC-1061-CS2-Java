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

// Compute Factorial
public class Ch18Program01 {

  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a non-negative integer: ");
      int n = input.nextInt();

      // Display factorial
      System.out.println("Factorial of " + n + " is " + factorial(n));
    }
  }

  // Mathematic notation:
  // n! = n * (n-1)!, n > 0
  // 0! = 1

  // Function:
  // factorial(0) = 1
  // factorial(n) = n * factorial(n-1) // where n > 0

  /** Return the factorial for a specified number */
  public static long factorial(int n) {
    // Base case
    if (n == 0) {
      return 1;
    }

    return n * factorial(n - 1); // Recursive call
  }
}
