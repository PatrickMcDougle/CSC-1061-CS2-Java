package edu.csc1061.ch09.circle;

public class MyCircle4Program {

  // Main method
  public static void main(String[] args) {
    // Create a Circle object with radius 1
    Circle3 myCircle = new Circle3(1);

    // Print areas for radius 1, 2, 3, 4, and 5.
    int n = 5;
    printAreas(myCircle, n);

    // See myCircle.radius and times
    System.out.println();
    System.out.println("Radius is " + myCircle.getRadius());
    System.out.println("n is " + n);
  }

  // Print a table of areas for radius
  public static void printAreas(Circle3 c, int times) {
    System.out.println("Radius \t\tArea");
    while (times >= 1) {
      System.out.println(c.getRadius() + "\t\t" + c.getArea());
      c.setRadius(c.getRadius() + 1);
      times--;
    }
  }
}
