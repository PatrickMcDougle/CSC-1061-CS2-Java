package edu.csc1061.exercises_ch10;

public class MyInteger {

	private int value = 0;

	public MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean isEven() {
		return MyInteger.isEven(value);
	}

	public boolean isOdd() {
		return MyInteger.isOdd(value);
	}

	public boolean isPrime() {
		return MyInteger.isPrime(value);
	}

	public static boolean isEven(int value) {
		return (value & 1) == 0;
		// return value % 2 == 0; // another way to return the value.
	}

	public static boolean isOdd(int value) {
		return (value & 1) == 1;
		// return value % 2 == 1; // another way to return the value.
	}

	public static boolean isPrime(int value) {
		// if (value == 2) return true; // a check for if the value is 2 and prime.

		int halfValue = value / 2;

		for (int i = 2; i <= halfValue; ++i) {
			if (value % i == 0) {
				return false;
			}
		}

		return true;
	}

	public boolean equals(int i) {
		return value == i;
	}

	public boolean equals(MyInteger myInteger) {
		if (myInteger == null)
			return false;
		return value == myInteger.value;
		// return myInteger.equals(value); // you can call the equals on myInteger to do its equals
		// testing.
	}
}
