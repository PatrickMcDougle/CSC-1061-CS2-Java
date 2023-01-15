package edu.csc1061.ch22;

import java.util.Scanner;

public class GcdEuclid {

  /** Find GCD for integers m and n */
  public static int gcd(int m, int n) {
    if (m % n == 0) {
      return n;
    }
    return gcd(n, m % n);
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter first integer: ");
    int m = input.nextInt();
    System.out.print("Enter second integer: ");
    int n = input.nextInt();

    input.close();

    System.out.println(
      "The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n)
    );
  }
}
