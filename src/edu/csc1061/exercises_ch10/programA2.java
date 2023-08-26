/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.exercises_ch10;

public class ProgramA2 {

  // I don't like Inside Classes. I don't see why you would do this.
  public class InsiderClass {
    int value;
    int size;
  }

  private int value = 1;

  public void setValue(int newValue) {
    value = newValue;
  }

  public ProgramA2() {
    value = 2;
  }

  public int getValue() {
    return value;
  }

  public static void main(String[] args) {
    // where everything starts.
    MyInteger myInteger = new MyInteger(10);
  }
}
