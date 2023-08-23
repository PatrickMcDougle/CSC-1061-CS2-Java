package edu.csc1061.ch10;

public class Ch10Program04 {

  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers();

    for (int i = 0; i < 10; i++) {
      stack.push(i); // Push i to the stack
    }

    // Test if stack is empty
    while (!stack.empty()) {
      // Remove and return from stack
      System.out.print(stack.pop() + " ");
    }
  }
}
