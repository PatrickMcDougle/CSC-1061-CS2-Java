/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch22;

import java.util.Scanner;

public class Ch22Program08 {

  /**
   * Find GCD for integers m and n Brute Force.
   *
   * @param m the largest of the two integers
   * @param n the smallest of the two integers
   * @return the greatest common divisor.
   */
  public static int gcd_v5_9(int m, int n) {
    // Initial gcd is 1
    int gcd = 1;

    // Possible gcd
    for (int k = 2; k <= m && k <= n; k++) {
      if (m % k == 0 && n % k == 0) {
        gcd = k;
      }
    }

    return gcd;
  }

  /**
   * Find GCD for integers m and n
   *
   * @param m the largest of the two integers
   * @param n the smallest of the two integers
   * @return the greatest common divisor.
   */
  public static int gcd_v22_3(int m, int n) {
    // Initial gcd is 1
    int gcd = 1;

    if (m % n == 0) {
      return n;
    }

    for (int k = n / 2; k >= 1; k--) {
      if (m % k == 0 && n % k == 0) {
        gcd = k;
        break;
      }
    }

    return gcd;
  }

  /**
   * Find GCD for integers m and n using Euclid's Algorithm.
   *
   * @param m
   * @param n
   * @return
   */
  public static int gcd_v22_6(int m, int n) {
    /** Find GCD for integers m and n */
    if (m % n == 0) {
      return n;
    }
    return gcd_v22_6(n, m % n);
  }

  /**
   * Main Method
   *
   * @param args the arguments that are passed in at the command line.
   */
  public static void main(String[] args) {
    // Create a Scanner
    int n = 0;
    int m = 0;

    // Prompt the user to enter two integers
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter first integer: ");
      m = input.nextInt();
      System.out.print("Enter second integer: ");
      n = input.nextInt();
    }

    System.out.printf("The greatest common divisor for %d and %d:%n", m, n);

    System.out.printf("Brute Force  %d:%n", gcd_v5_9(m, n));
    System.out.printf("Smart Force  %d:%n", gcd_v22_3(m, n));
    System.out.printf("Euclid's Alg %d:%n", gcd_v22_6(m, n));
  }
}
