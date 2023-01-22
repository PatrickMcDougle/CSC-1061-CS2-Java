package edu.csc1061.ch09.student;

public class MyStudent1Program {

  public static void main(String[] args) {
    Student1 student = new Student1();
    //int localX;

    System.out.println("name           [String]  | " + student.name + "  |");
    System.out.println("age            [int]     | " + student.age + "     |");
    System.out.println(
      "isScienceMajor [boolean] | " + student.isScienceMajor + " |"
    );
    System.out.println(
      "gender         [char]    | " + student.gender + "     |"
    );
    //System.out.println("localX         [int]     | " + localX + "     |");
  }
}
