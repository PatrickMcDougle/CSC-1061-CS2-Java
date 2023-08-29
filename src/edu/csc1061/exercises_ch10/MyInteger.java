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
    // return !MyInteger.isEven(value); // another way to return the value.
  }

  public static boolean isPrime(int value) {
    int halfValue = value / 2;

    for (int divisor = 2; divisor <= halfValue; ++divisor) {
      if (value % divisor == 0) {
        return false;
      }
    }

    return true;
  }

  public static int parseInt(char[] charArray) {
    // convert the char array to a single int value and return it.

    if (charArray.length == 0) {
      return -1;
    }
    return 0;
  }

  public static int parseInt(String str) {
    // convert the string array to a single int value and return it.

    if (str == null || str.trim().isEmpty()) {
      return -1;
    }
    return 0;
  }

  public boolean equals(int i) {
    return value == i;
  }

  public boolean equals(MyInteger myInteger) {
    if (myInteger == null) {
      return false;
    }
    return value == myInteger.value;
    // return myInteger.equals(value); // you can call the equals on myInteger to do
    // its equals testing.
  }

  @Override
  public int hashCode() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MyInteger)) {
      return false;
    }
    return equals((MyInteger) o);
  }

}
