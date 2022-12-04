package edu.csc1061.ch10;

public class Program10_004 {

	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();

		for (int i = 0; i < 10; i++)
			stack.push(i); // Push i to the stack

		while (!stack.empty()) // Test if stack is empty
			System.out.print(stack.pop() + " "); // Remove and return from stack
	}
}
