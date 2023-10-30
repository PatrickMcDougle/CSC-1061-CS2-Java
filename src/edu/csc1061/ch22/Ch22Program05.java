/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Efficient Prime Number
public class Ch22Program05 {

  public static void main(String[] args) {
    int n = 0;
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Find all prime numbers <= n, enter n: ");
      n = input.nextInt();
    }

    // A list to hold prime numbers
    List<Integer> listOfPrimes = new ArrayList<>();

    final int NUMBER_OF_PRIMES_PER_LINE = 20; // Display 10 per line
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness
    int squareRoot = 1; // Check whether number <= squareRoot

    System.out.println("The prime numbers are \n");

    // Repeatedly find prime numbers
    while (number <= n) {
      // Assume the number is prime
      boolean isPrime = true;

      // Poor mans smart way to calculate the square root for this number.
      if (squareRoot * squareRoot < number) {
        squareRoot++;
      }

      // Test whether number is prime
      for (int k = 0; k < listOfPrimes.size() && listOfPrimes.get(k) <= squareRoot; k++) {
        if (number % listOfPrimes.get(k) == 0) {
          isPrime = false;
          break;
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        count++;

        // Add a new prime to the list
        listOfPrimes.add(number);

        if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
          // Print the number and advance to the new line
          System.out.printf("%7d%n", number);
        } else {
          System.out.printf("%7d", number);
        }
      }

      // Check if the next number is prime
      number++;
    }

    System.out.printf("%n%d prime(s) less than or equal to %d%n", count, n);
  }
}
