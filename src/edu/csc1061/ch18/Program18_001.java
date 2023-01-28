package edu.csc1061.ch18;

import java.util.Scanner;

// Compute Factorial
public class Program18_001 {

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
    if (n == 0) { // Base case
      return 1;
    }

    return n * factorial(n - 1); // Recursive call
  }
}
