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

import java.util.Scanner;

// Prime Numbers
public class Ch22Program04 {

    public static void main(String[] args) {
        int n = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Find all prime numbers <= n, enter n: ");
            n = input.nextInt();
        }

        final int NUMBER_OF_PRIMES_PER_LINE = 20;
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

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
                count++; // Increase the count

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
