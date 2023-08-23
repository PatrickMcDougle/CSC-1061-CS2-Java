package edu.csc1061.ch09;

public class Student2 {
  private int id;
  private BirthDate birthDate;

  public Student2(int ssn, int year, int month, int day) {
    id = ssn;
    birthDate = new BirthDate(year, month, day);
  }

  public int getId() {
    return id;
  }

  public BirthDate getBirthDate() {
    return birthDate;
  }
}
