/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch07;

public class Calculator {

  /** Main method */
  public static void main(String[] args) {
    // Check the number of strings passed
    if (args.length != 3) {
      System.out.println("Usage: java Calculator operand1 operator operand2");
      System.exit(1);
    }

    // The result of the operation
    int result = 0;

    // Determine the operator
    switch (args[1].charAt(0)) {
      case '+':
        result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
        break;
      case '-':
        result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
        break;
      case '.':
        result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
        break;
      case '/':
        result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        break;
      default:
        result = 0;
    }

    // Display the result
    System.out.println(
        args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
  }
}
