package edu.csc1061.ch09.student;

public class MyStudent2Program {

  public static void main(String[] args) {
    Student2 student = new Student2(111223333, 1970, 5, 3);
    BirthDate1 date = student.getBirthDate();
    date.setYear(2010); // Now the student birth year is changed!
  }
}
