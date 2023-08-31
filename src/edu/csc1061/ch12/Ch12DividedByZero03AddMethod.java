/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch12;

import java.util.Scanner;

/**
 * Divide By Zero will crash the program
 * This program will check if the denominator is zero.
 * But all the code is in a new method now where the issue is.
 */
public class Ch12DividedByZero03AddMethod {

  public static int quotient(int numerator, int denominator) {
    if (denominator == 0) {
      System.out.println("Divisor cannot be zero");
      System.exit(1);
    }

    return numerator / denominator;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int numerator = input.nextInt();
    int denominator = input.nextInt();

    input.close();

    int result = quotient(numerator, denominator);
    System.out.println(numerator + " / " + denominator + " is " + result);
  }
}
