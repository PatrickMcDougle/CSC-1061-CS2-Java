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
package edu.csc1061.ch22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Prime Numbers - inefficient
// Stores values first into a list, than prints that list out.
// run this with 9_999_999 as the value without the _ in the number.
public class Ch22Program06b {

    private static int primeCounter = 0;

    public static void main(String[] args) {
        int n = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Find all prime numbers <= n, enter n: ");
            n = input.nextInt();
        }

        final int NUMBER_OF_PRIMES_PER_LINE = 20;
        int number = 2; // A number to be tested for primeness

        List<Integer> primes = new ArrayList<>();

        System.out.println("The prime numbers are:");

        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true;

            // ClosestPair if number is prime
            for (int divisor = 2; divisor <= (int) (Math.sqrt(number)); divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                primes.add(number);
            }

            // Check if the next number is prime
            number++;
        }

        primes.forEach(e -> {
            if (++primeCounter % NUMBER_OF_PRIMES_PER_LINE == 0) {
                // Print the number and advance to the new line
                System.out.printf("%7d%n", e);
            } else {
                System.out.printf("%7d", e);
            }
        });

        System.out.printf("%n%d prime(s) less than or equal to %d%n", primes.size(), n);
    }
}
