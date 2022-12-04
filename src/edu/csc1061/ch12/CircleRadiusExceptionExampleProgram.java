package edu.csc1061.ch12;

public class CircleRadiusExceptionExampleProgram {

  /** Main method */
  public static void main(String[] args) {
    try {
      CircleRadiusExceptionExample c1 = new CircleRadiusExceptionExample(5);
      c1.setRadius(-5);
      CircleRadiusExceptionExample c3 = new CircleRadiusExceptionExample(0);
      c3.setRadius(10);
    } catch (InvalidRadiusException ex) {
      System.out.println(ex);
    }

    System.out.println(
      "Number of objects created: " +
      CircleRadiusExceptionExample.getNumberOfObjects()
    );
  }
}
