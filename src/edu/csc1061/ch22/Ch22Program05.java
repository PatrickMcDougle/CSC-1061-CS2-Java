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

// Efficient Prime Number
public class Ch22Program05 {

    static final int NUMBER_OF_PRIMES_PER_LINE = 20;

    public static void main(String[] args) {
        int maxPrime = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Find all prime numbers <= n, enter n: ");
            maxPrime = input.nextInt();
        }

        System.out.println("The prime numbers are:");

        Ch22Program05 program05 = new Ch22Program05();
        int[] primeList = program05.findPrimes(maxPrime);
        program05.printPrimes(primeList);

        System.out.printf("%n%d prime(s) less than or equal to %d%n", primeList.length, maxPrime);
    }

    public int[] findPrimes(int numberOfPrimes) {
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        List<Integer> primeList = new ArrayList<>();

        // Repeatedly find prime numbers
        while (number <= numberOfPrimes) {
            // Assume the number is prime
            boolean isPrime = true;

            // Poor mans smart way to calculate the square root for this number.
            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // Test whether number is prime
            for (int k = 0; k < primeList.size() && primeList.get(k) <= squareRoot; k++) {
                if (number % primeList.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
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
