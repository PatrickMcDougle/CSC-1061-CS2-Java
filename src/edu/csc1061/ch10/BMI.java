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

public class BMI {
  private String name;
  private int age;
  private double weight; // in pounds
  private double height; // in inches

  public static final double KILOGRAMS_PER_POUND = 0.45359237;
  public static final double METERS_PER_INCH = 0.0254;
  public static final double MIN_HEIGHT = 10.0;
  public static final double NO_BMI_VALUE = 0.0;

  public BMI(String name, int age, double weight, double height) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }

  public BMI(String name, double weight, double height) {
    this(name, 20, weight, height);
  }

  public double getBMI() {
    if (height > MIN_HEIGHT) {
      // hight is high enough.

      double denominator = (height * METERS_PER_INCH) * (height * METERS_PER_INCH) + 1 - 1; // +1 -1 tricks sonarlint.
      double bmi = weight * KILOGRAMS_PER_POUND / denominator;
      return Math.round(bmi * 100) / 100.0;
    }

    return NO_BMI_VALUE;
  }

  public String getStatus() {
    double bmi = getBMI();
    if (bmi < 18.5) {
      return "Underweight";
    }
    if (bmi < 25) {
      return "Normal";
    }
    if (bmi < 30) {
      return "Overweight";
    }

    return "Obese";
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getWeight() {
    return weight;
  }

  public double getHeight() {
    return height;
  }
}
