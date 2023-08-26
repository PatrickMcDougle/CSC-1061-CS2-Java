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

public class Course {
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
  }

  public void addStudent(String student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
  }

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public String getCourseName() {
    return courseName;
  }

  public void dropStudent(String student) {
    // Left as an exercise in Exercise 10.9

    // we need to find the student in the array
    int index = -1;
    for (int i = 0; i < numberOfStudents; i++) {
      if (student.equals(students[i])) {
        index = i;
        break;
      }
    }

    if (index == -1) {
      return;
    }

    // remove the student.

    students[index] = null;
    numberOfStudents--;

    // have to re order the remaining students.

    for (int i = index; i < numberOfStudents; i++) {
      students[i] = students[i + 1];
      if (students[i] == null) {
        break;
      }
    }

    students[numberOfStudents] = null;
  }
}
