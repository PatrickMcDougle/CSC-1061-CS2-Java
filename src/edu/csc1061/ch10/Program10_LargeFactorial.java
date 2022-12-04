package edu.csc1061.ch10;

import java.util.Scanner;
import java.math.*;

public class Program10_LargeFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = input.nextInt();
		System.out.println(n + "! is \n" + factorial(n));
		input.close();
	}

	public static BigInteger factorial(long n) {
		BigInteger result = BigInteger.ONE; // Assign 1 to result
		for (int i = 1; i <= n; i++) // Multiply each i
			result = result.multiply(new BigInteger(i + ""));

		return result;
	}
}
