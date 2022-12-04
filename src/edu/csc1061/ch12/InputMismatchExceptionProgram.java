package edu.csc1061.ch12;

// import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;

		do {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();

				// Display the result
				System.out.println("The number entered is " + number);

				continueInput = false;
			} catch (InputMismatchException ex) {
				// ////////// ////////// ////////// ////////// ////////// //////////
				// By handling InputMismatchException, the program will continuously read an
				// input until it is correct.
				// ////////// ////////// ////////// ////////// ////////// //////////

				System.out.println("Try again. (" + "Incorrect input: an integer is required)");
				input.nextLine(); // discard input
			}
		} while (continueInput);

		input.close();
	}
}
