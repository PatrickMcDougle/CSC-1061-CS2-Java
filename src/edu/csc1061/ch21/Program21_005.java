package edu.csc1061.ch21;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program21_005 {

  public static void main(String[] args) throws Exception {
    Program21_005 program = new Program21_005();

    program.Run();
  }

  // example filename with path:
  // \src\csc161\ch21\Program21_001.java
  // D:\Drives\OneDrive - Colorado Community College System\CSC 1061 - Computer Science 2 - Java\Code-Examples\csc1061\src\edu\csc1061\ch21
  public void Run() throws Exception {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a Java source file: ");
      String filename = input.nextLine();

      File file = new File(filename);
      if (file.exists()) {
        System.out.println(
          "The number of keywords in " +
          file.getName() +
          " is " +
          countKeywords(file)
        );
      } else {
        System.out.println("File " + filename + " does not exist");
      }
    }
  }

  public int countKeywords(File file) throws Exception {
    // Array of all Java keywords + true, false and null
    String[] keywordString = {
      "abstract",
      "assert",
      "boolean",
      "break",
      "byte",
      "case",
      "catch",
      "char",
      "class",
      "const",
      "continue",
      "default",
      "do",
      "double",
      "else",
      "enum",
      "extends",
      "for",
      "final",
      "finally",
      "float",
      "goto",
      "if",
      "implements",
      "import",
      "instanceof",
      "int",
      "interface",
      "long",
      "native",
      "new",
      "package",
      "private",
      "protected",
      "public",
      "return",
      "short",
      "static",
      "strictfp",
      "super",
      "switch",
      "synchronized",
      "this",
      "throw",
      "throws",
      "transient",
      "try",
      "void",
      "volatile",
      "while",
      "true",
      "false",
      "null",
    };

    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;

    try (Scanner input = new Scanner(file)) {
      while (input.hasNext()) {
        String word = input.next();
        if (keywordSet.contains(word)) {
          count++;
        }
      }
    }

    return count;
  }
}
