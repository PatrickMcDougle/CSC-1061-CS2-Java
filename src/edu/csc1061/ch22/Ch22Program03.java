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

// Prime Number
public class Ch22Program03 {

    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 50_000; // Number of primes to display
        final int NUMBER_OF_PRIMES_PER_LINE = 20;
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        System.out.printf("Find the first %d prime numbers:%n", NUMBER_OF_PRIMES);

        // Repeatedly find prime numbers
        while (count < NUMBER_OF_PRIMES) {
            // Assume the number is prime
            boolean isPrime = true;

            // Test if number is prime
            for (int divisor = 2; divisor <= number / 2; divisor++) {
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
    }
}
