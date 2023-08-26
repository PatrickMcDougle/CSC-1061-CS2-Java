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

public class Ch09MyStudent1Program {

  public static void main(String[] args) {
    Student1 student = new Student1();
    // int localX;

    System.out.println("name           [String]  | " + student.name + "  |");
    System.out.println("age            [int]     | " + student.age + "     |");
    System.out.println("isScienceMajor [boolean] | " + student.isScienceMajor + " |");
    System.out.println("gender         [char]    | " + student.gender + "     |");
    // System.out.println("localX [int] | " + localX + " |");
  }
}
