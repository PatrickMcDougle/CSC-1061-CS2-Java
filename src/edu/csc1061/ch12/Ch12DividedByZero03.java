/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

import java.util.Scanner;

/**
 * By providing a value of 0 (zero) for the denominator, this presents a Divide By Zero issue which
 * will crash the program. This program will check if the denominator is zero before using it. But
 * now the issue is in a method and the method now needs to exit "un"-gracefully.
 */
public class Ch12DividedByZero03 {

    /**
     * This method will take in a numerator and denominator and produce the quotient. i.e. it will
     * divide the two numbers.
     *
     * @param numerator is an integer and the first number for division
     * @param denominator is an integer and the second number for division
     * @return an integer that is the quotient value of the division. i.e. the answer.
     */
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
