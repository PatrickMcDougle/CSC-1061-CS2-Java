/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch22;

import java.util.Scanner;

public class Gcd {

  /** Find GCD for integers m and n */
  public static int gcd(int m, int n) {
    int gcd = 1;

    if (m % n == 0)
      return n;

    for (int k = n / 2; k >= 1; k--) {
      if (m % k == 0 && n % k == 0) {
        gcd = k;
        break;
      }
    }

    return gcd;
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
        "The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n));
  }
}
