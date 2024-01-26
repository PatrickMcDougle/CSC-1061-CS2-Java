/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Handling an input mismatch exception. */
public class Ch12Program05 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean continueInput = true;

    do {
      try {
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Display the result
        System.out.println("The number entered is " + number);

        continueInput = false;
      } catch (InputMismatchException ex) {
        // ////////// ////////// ////////// ////////// ////////// //////////
        // By handling InputMismatchException, the program will continuously
        // read an input until it is correct.
        // ////////// ////////// ////////// ////////// ////////// //////////

        System.out.println("Try again. (Incorrect input: an integer is required)");
        input.nextLine(); // discard input
      }
    } while (continueInput);

    input.close();
  }
}
