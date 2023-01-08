package edu.csc1061.ch18;

import java.util.Scanner;

public class ComputeFibonacci {

  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an index for a Fibonacci number: ");
    int index = input.nextInt();
    input.close();

    // Find and display the Fibonacci number
    System.out.println(
      "The Fibonacci number at index " + index + " is " + fib(index)
    );
  }

  /** The method for finding the Fibonacci number */
  public static long fib(long index) {
    if (index == 0) return 0; // Base case
    if (index == 1) return 1; // Base case
    // Reduction and recursive calls
    return fib(index - 1) + fib(index - 2);
  }
}
