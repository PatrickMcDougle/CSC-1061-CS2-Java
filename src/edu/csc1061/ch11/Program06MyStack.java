package edu.csc1061.ch11;

import java.math.BigInteger;

public class Program06MyStack {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		// The constructor Integer(int) has been deprecated since version 9 and marked
		// for removal
		new Integer(1);

		// Use this instead.
		myStack.push(Integer.valueOf(1));

		myStack.push(Double.valueOf(2.0));

		myStack.push(Long.valueOf(3));

		myStack.push(new BigInteger("4"));
		myStack.push(BigInteger.valueOf(5));

		System.out.println(myStack.peek());

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}

	}
}
