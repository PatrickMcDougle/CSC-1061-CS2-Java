/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch12;

public class WriteAutoCloseProgram {

  public static void main(String[] args) throws Exception {
    java.io.File file = new java.io.File("scores2.no.track.txt");
    if (file.exists()) {
      System.out.println("File already exists");
      System.exit(0);
    }

    // Create a file
    try (java.io.PrintWriter output = new java.io.PrintWriter(file);) {
      // Write formatted output to the file
      output.print("Corey T Smith ");
      output.println(90);
      output.print("Nathan K Jones ");
      output.println(85);
    }
  }
}
