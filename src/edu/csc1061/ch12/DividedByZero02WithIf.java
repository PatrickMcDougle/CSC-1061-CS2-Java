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

public class DividedByZero02WithIf {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();

    input.close();

    if (number2 != 0) {
      System.out.println(
          number1 + " / " + number2 + " is " + (number1 / number2));
    } else {
      System.out.println("Divisor cannot be zero ");
    }
  }
}
