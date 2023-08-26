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

public class ProgramMyInteger {

  public static void main(String[] args) {
    MyInteger myInteger = new MyInteger(2);
    System.out.println("Program 10.3");

    System.out.println(myInteger.isPrime());
    System.out.println("MyInteger.isEven(#) == true");
    System.out.println(MyInteger.isEven(2));
    System.out.println(MyInteger.isEven(4));
    System.out.println(MyInteger.isEven(8));
    System.out.println(MyInteger.isEven(16));
    System.out.println(MyInteger.isEven(20));
    System.out.println("MyInteger.isOdd(#) == true");
    System.out.println(MyInteger.isOdd(1));
    System.out.println(MyInteger.isOdd(3));
    System.out.println(MyInteger.isOdd(5));
    System.out.println(MyInteger.isOdd(7));
    System.out.println(MyInteger.isOdd(11));

    System.out.println("MyInteger.isEven(#) == false");
    System.out.println(MyInteger.isOdd(2));
    System.out.println(MyInteger.isOdd(4));
    System.out.println(MyInteger.isOdd(8));
    System.out.println(MyInteger.isOdd(16));
    System.out.println(MyInteger.isOdd(20));
    System.out.println("MyInteger.isOdd(#) == false");
    System.out.println(MyInteger.isEven(1));
    System.out.println(MyInteger.isEven(3));
    System.out.println(MyInteger.isEven(5));
    System.out.println(MyInteger.isEven(7));
    System.out.println(MyInteger.isEven(11));

    System.out.println("MyInteger.isPrime(#) == true");
    System.out.println(MyInteger.isPrime(2));
    System.out.println(MyInteger.isPrime(3));
    System.out.println(MyInteger.isPrime(5));
    System.out.println(MyInteger.isPrime(7));
    System.out.println(MyInteger.isPrime(11));
    System.out.println("MyInteger.isPrime(#) == false");
    System.out.println(MyInteger.isPrime(4));
    System.out.println(MyInteger.isPrime(6));
    System.out.println(MyInteger.isPrime(8));
    System.out.println(MyInteger.isPrime(12));
    System.out.println(MyInteger.isPrime(1337));

    System.out.println("Program 10.6");
    StackOfIntegers soi = new StackOfIntegers();
    int primeLessThan = 120;

    for (int i = 2; i < primeLessThan; i++) {
      if (MyInteger.isPrime(i)) {
        soi.push(i);
      }
    }

    while (!soi.empty()) {
      System.out.print(soi.pop() + " ");
    }
  }
}
