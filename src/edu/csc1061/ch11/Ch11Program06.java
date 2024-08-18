/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch11;

import java.math.BigInteger;

/**
 * My Stack
 */
public class Ch11Program06 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        // The constructor Integer(int) has been deprecated since version 9 and marked
        // for removal. But we show the old way to do this and the new way.
        myStack.push(new Integer(1)); // noncompliant - old deprecated version.
        myStack.push(Integer.valueOf(2)); // compliant - preferred way.

        myStack.push(Double.valueOf(3.0));

        myStack.push(Long.valueOf(4));

        myStack.push(new BigInteger("5")); // noncompliant - not the preferred way to do this.
        myStack.push(BigInteger.valueOf(6)); // compliant - preferred way to do this. but does not
                                             // accept strings.

        System.out.println(myStack.peek());

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
