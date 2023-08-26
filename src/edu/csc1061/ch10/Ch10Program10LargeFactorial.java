/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch10;

import java.math.*;
import java.util.Scanner;

public class Ch10Program10LargeFactorial {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();
    System.out.println(n + "! is \n" + factorial(n));
    input.close();
  }

  public static BigInteger factorial(long n) {
    BigInteger result = BigInteger.ONE; // Assign 1 to result
    for (int i = 1; i <= n; i++) {
      result = result.multiply(new BigInteger(i + "")); // Multiply each i
    }
    return result;
  }
}
