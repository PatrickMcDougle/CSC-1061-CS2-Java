package edu.csc1061.ch09;

public class Ch09MyStudent2Program {

  public static void main(String[] args) {
    Student2 student = new Student2(111223333, 1970, 5, 3);
    BirthDate date = student.getBirthDate();
    date.setYear(2010); // Now the student birth year is changed!
  }
}
