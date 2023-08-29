/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch05;

import java.util.Random;
import java.util.Scanner;

public class RepeatAdditionQuiz {

  public static void main(String[] args) {
    Random random = new Random();

    int number1 = random.nextInt() * 10;
    int number2 = random.nextInt() * 10;

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.print("What is " + number1 + " + " + number2 + "? ");
    int answer = input.nextInt();

    while (number1 + number2 != answer) {
      System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
      answer = input.nextInt();
    }

    input.close();

    System.out.println("You got it!");
  }
}
