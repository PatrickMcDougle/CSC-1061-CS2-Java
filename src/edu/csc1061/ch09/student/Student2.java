package edu.csc1061.ch09.student;

public class Student2 {
  private int id;
  private BirthDate1 birthDate;

  public Student2(int ssn, int year, int month, int day) {
    id = ssn;
    birthDate = new BirthDate1(year, month, day);
  }

  public int getId() {
    return id;
  }

  public BirthDate1 getBirthDate() {
    return birthDate;
  }
}
