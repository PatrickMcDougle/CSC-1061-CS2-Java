package edu.csc1061.ch12;

public class CircleWithExceptionProgram {

  public static void main(String[] args) {
    try {
      CircleWithException c1 = new CircleWithException(5);
      CircleWithException c2 = new CircleWithException(15);
      CircleWithException c3 = new CircleWithException(0);
      c1.setRadius(15);
      c2.setRadius(-15);
      c3.setRadius(10);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex);
    }

    System.out.println(
      "Number of objects created: " + CircleWithException.getNumberOfObjects()
    );
  }
}
