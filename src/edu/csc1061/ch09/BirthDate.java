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

public class BirthDate {
  private int year;
  private int month;
  private int day;

  public BirthDate() {
    // do nothing at this time.
    System.out.println("Default BirthDate constructor called!");
  }

  public BirthDate(int year) {
    this(); // Call BirthDate() constructor.
    this.year = year;
  }

  public BirthDate(int year, int month, int day) {
    this(year); // call BirthDate(year) constructor.
    this.month = month;
    this.day = day;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

}
