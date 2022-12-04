package edu.csc1061.ch13;

import java.math.BigInteger;

public class Program005 {
	public static void main(String[] args) {

		String[] cities = {"Savannah", "Boston", "Tampa", "Atlanta"};

		java.util.Arrays.sort(cities);
		for (String city : cities) {
			System.out.print(city + " ");
		}
		System.out.println();

		BigInteger[] hugeNumbers = {new BigInteger("2323231092923992"),
				new BigInteger("432232323239292"), new BigInteger("54623239292")};
		java.util.Arrays.sort(hugeNumbers);
		for (BigInteger number : hugeNumbers) {
			System.out.print(number + " ");
		}
	}
}
