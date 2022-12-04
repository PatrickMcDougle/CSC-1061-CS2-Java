package edu.csc1061.ch12;

public class CircleExceptionExampleProgram {

  public static void main(String[] args) {
    try {
      CircleExceptionExample c1 = new CircleExceptionExample(5);
      CircleExceptionExample c2 = new CircleExceptionExample(15);
      CircleExceptionExample c3 = new CircleExceptionExample(0);
      c1.setRadius(15);
      c2.setRadius(-15);
      c3.setRadius(10);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex);
    }

    System.out.println(
      "Number of objects created: " +
      CircleExceptionExample.getNumberOfObjects()
    );
  }
}
