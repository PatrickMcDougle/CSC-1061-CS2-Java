package edu.csc1061.ch18;

import java.util.Scanner;

// Compute Factorial Tail Recursion
public class Ch18Program10 {

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

  /** Return the factorial for a specified number */
  public static long factorial(int n) {
    return factorial(n, 1); // Call auxiliary method
  }

  /** Auxiliary tail-recursive method for factorial */
  private static long factorial(int n, int result) {
    // Base case
    if (n == 0) {
      return result;
    }

    return factorial(n - 1, n * result); // Recursive call
  }
}
