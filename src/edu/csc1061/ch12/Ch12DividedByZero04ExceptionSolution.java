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
 * The code with the issue is in a method.
 * That method will throw an exception if the denominator is zero.
 * The main method will catch that exception.
 */
public class Ch12DividedByZero04ExceptionSolution {

  public static int quotient(int numerator, int denominator) {
    if (denominator == 0) {
      throw new ArithmeticException("Divisor cannot be zero");
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

    try {
      int result = quotient(numerator, denominator);
      System.out.println(numerator + " / " + denominator + " is " + result);
    } catch (ArithmeticException ex) {
      System.out.println("Exception: an Arithmetic Exception has been thrown!");
      System.out.println(ex);
      System.out.println(ex.getMessage());
    }

    System.out.println("Execution continues to the end.");
  }
}
