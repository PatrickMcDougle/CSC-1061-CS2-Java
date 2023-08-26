/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch09;

public class Ch09MyCircle5Program {

  // Main method
  public static void main(String[] args) {
    // Declare circleArray
    Ch09Circle3[] circleArray;

    // Create circleArray
    circleArray = createCircleArray();

    // Print circleArray and total areas of the circles
    printCircleArray(circleArray);
  }

  // Create an array of Circle objects
  public static Ch09Circle3[] createCircleArray() {
    Ch09Circle3[] circleArray = new Ch09Circle3[5];

    for (int i = 0; i < circleArray.length; i++) {
      circleArray[i] = new Ch09Circle3(Math.random() * 100);
    }

    // Return Circle array
    return circleArray;
  }

  // Print an array of circles and their total area
  public static void printCircleArray(Ch09Circle3[] circleArray) {
    System.out.printf("%-30s%-15s%n", "Radius", "Area");
    for (int i = 0; i < circleArray.length; i++) {
      System.out.printf(
          "%-30f%-15f\n",
          circleArray[i].getRadius(),
          circleArray[i].getArea());
    }

    System.out.println("-----------------------------------------");

    // Compute and display the result
    System.out.printf(
        "%-30s%-15f%n",
        "The total areas of circles is",
        sum(circleArray));
  }

  // Add circle areas
  public static double sum(Ch09Circle3[] circleArray) {
    // Initialize sum
    double sum = 0;

    // Add areas to sum
    for (int i = 0; i < circleArray.length; i++)
      sum += circleArray[i].getArea();

    return sum;
  }
}
