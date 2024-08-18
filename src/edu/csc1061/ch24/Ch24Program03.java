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
package edu.csc1061.ch24;

public class Ch24Program03 {

    public static void main(String[] args) {
        Ch24Program03 program03 = new Ch24Program03();

        System.out.println("\n ========== ========== ========== \n");
        program03.testingStack();
        System.out.println("\n ========== ========== ========== \n");
    }

    /** This method shows off and tests the stack class that we created. */
    public void testingStack() {
        // Create a stack
        MyStack<String> stack = new MyStack<>();

        // Add elements to the stack
        stack.push("Daniel"); // Push a string to the stack
        System.out.println("(01) {" + stack.getSize() + "} " + stack);

        stack.push("Ben"); // Push another string to the the stack
        System.out.println("(02) {" + stack.getSize() + "} " + stack);

        stack.push("Frank"); // Push it to the stack
        stack.push("Gryphon"); // Push another string to the stack
        stack.push("Patrick"); // Push another string to the stack
        stack.push("John"); // Push another string to the stack
        stack.push("Sophia"); // Push another string to the stack
        stack.push("Sora"); // Push another string to the stack
        stack.push("Carter"); // Push another string to the stack
        stack.push("Ron"); // Push another string to the stack
        System.out.println("(03) {" + stack.getSize() + "} " + stack);

        // Remove elements from the stack
        System.out.println("(04) Pop: " + stack.pop());
        System.out.println("(05) Pop: " + stack.pop());
        System.out.println("(06) {" + stack.getSize() + "} " + stack);
    }
}
