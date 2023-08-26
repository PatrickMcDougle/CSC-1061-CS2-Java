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

public class Student2 {
  private int ssn;
  private BirthDate birthDate;

  public Student2(int ssn, int year, int month, int day) {
    this.ssn = ssn;
    birthDate = new BirthDate(year, month, day);
  }

  public int getSsn() {
    return ssn;
  }

  public BirthDate getBirthDate() {
    return birthDate;
  }
}
