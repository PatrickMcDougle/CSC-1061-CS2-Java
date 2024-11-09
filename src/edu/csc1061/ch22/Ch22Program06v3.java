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
// Lets use some REGEX magic.
// YouTube: https://youtu.be/5vbk0TwkokM?si=Myie0yCEja_wvHwN
public class Ch22Program06v3 {

    static final int NUMBER_OF_PRIMES_PER_LINE = 20;

    static final String THE_PRIME_REGEX = "^.?$|^(..+?)\\1+$";

    public static void main(String[] args) {
        int maxPrime = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Find all prime numbers <= n, enter n: ");
            maxPrime = input.nextInt();
        }

        System.out.println("The prime numbers are:");

        Ch22Program06v3 program06 = new Ch22Program06v3();
        int[] primeList = program06.findPrimes(maxPrime);
        program06.printPrimes(primeList);

        System.out.printf("%n%d prime(s) less than or equal to %d%n", primeList.length, maxPrime);
    }

    public int[] findPrimes(int numberOfPrimes) {
        int number = 2; // A number to be tested for primeness

        List<Integer> primeList = new ArrayList<>();

        // Repeatedly find prime numbers
        while (number <= numberOfPrimes) {
            String theNumber = "1".repeat(number);

            // Print the prime number and increase the count
            if (!theNumber.matches(THE_PRIME_REGEX)) {
                primeList.add(number);
            }

            // Check if the next number is prime
            number++;
        }

        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void printPrimes(int[] primeList) {
        for (int i = 0; i < primeList.length; i++) {
            if (i % NUMBER_OF_PRIMES_PER_LINE == 0) {
                // Print the number and advance to the new line
                System.out.printf("%7d%n", primeList[i]);
            } else {
                System.out.printf("%7d", primeList[i]);
            }
        }
    }
}
