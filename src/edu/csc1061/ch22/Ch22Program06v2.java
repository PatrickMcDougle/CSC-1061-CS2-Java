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

// Sieve Of Eratosthenes
public class Ch22Program06v2 {

    static final int NUMBER_OF_PRIMES_PER_LINE = 20;

    public static void main(String[] args) {
        int maxPrime = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Find all prime numbers <= n, enter n: ");
            maxPrime = input.nextInt();
        }

        System.out.println("The prime numbers are:");

        Ch22Program06v2 program06 = new Ch22Program06v2();
        int[] primeList = program06.findPrimes(maxPrime);
        program06.printPrimes(primeList);

        System.out.printf("%n%d prime(s) less than or equal to %d%n", primeList.length, maxPrime);
    }

    public int[] findPrimes(int numberOfPrimes) {

        // Prime number sieve
        boolean[] primes = new boolean[numberOfPrimes + 1];

        // Initialize primes[i] to true
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k * k <= numberOfPrimes; ++k) {
            if (primes[k]) {
                // for loop optimized to not use multiplication.
                for (int notPrime = k * k; notPrime <= numberOfPrimes; notPrime += k) {
                    primes[notPrime] = false; // i is not prime
                }
            }
        }

        // Save prime numbers into a list so we can make an array our of it.
        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }

        // return the array of integers
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
