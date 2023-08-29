/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch10;

public class Ch10Program02 {

  public static void main(String[] args) {
    BMI bmi1 = new BMI("John Doe", 18, 145, 70);
    System.out.println("The BMI for " + bmi1.getName() + " is " + bmi1.getBMI() + " " + bmi1.getStatus());

    BMI bmi2 = new BMI("Peter King", 215, 70);
    System.out.println("The BMI for " + bmi2.getName() + " is " + bmi2.getBMI() + " " + bmi2.getStatus());
  }
}
