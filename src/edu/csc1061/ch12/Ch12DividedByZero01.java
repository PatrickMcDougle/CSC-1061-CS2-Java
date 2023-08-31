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
 */
public class Ch12DividedByZero01 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int numerator = input.nextInt();
    int denominator = input.nextInt();

    input.close();

    System.out.println(numerator + " / " + denominator + " is " + (numerator / denominator));
  }
}
