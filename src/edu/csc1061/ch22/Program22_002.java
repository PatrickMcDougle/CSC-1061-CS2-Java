package edu.csc1061.ch22;

import java.util.Scanner;

public class Program22_002 {

	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter an index for the Fibonacci number: ");
			int index = input.nextInt();

			// Find and display the Fibonacci number
			System.out.println("Fibonacci number at index " + index + " is " + fib(index));
		}
	}

	/** The method for finding the Fibonacci number */
	public static long fib(long n) {
		long f0 = 0; // For fib(0)
		long f1 = 1; // For fib(1)
		long f2 = 1; // For fib(2)

		if (n == 0)
			return f0;
		if (n == 1)
			return f1;
		if (n == 2)
			return f2;

		for (int i = 3; i <= n; i++) {
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}

		return f2;
	}

	//
	//
	//

	// Obviously, the complexity of this new algorithm is . This is a tremendous
	// improvement over the recursive algorithm.

	// O(n)

}
