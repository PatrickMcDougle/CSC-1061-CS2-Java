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

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Object> list = new ArrayList<>();

    // Returns true if this stack is empty.
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the number of elements in this stack.
    public int getSize() {
        return list.size();
    }

    // Returns the top element in this stack.
    public Object peek() {
        return list.get(getSize() - 1);
    }

    // Returns and removes the top element in this stack.
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    // Adds a new element to the top of this stack.
    public void push(Object o) {
        list.add(o);
    }

    // Returns the position of the first element in the stack from the top that
    // matches the specified element.
    public Object search(Object o) {
        for (Object object : list) {
            if (object.equals(o)) {
                return object;
            }
        }
        return null;
    }

    @Override /** Override the toString in the Object class */
    public String toString() {
        return "stack: " + list.toString();
    }
}
