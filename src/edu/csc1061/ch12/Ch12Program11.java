/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

import java.io.File;
import java.io.PrintWriter;

/** Writing to a class but using the try-with-resources that was introduced in Java 7. */
public class Ch12Program11 {

  public static void main(String[] args) throws Exception {
    File file = new File("scores2.no.track.txt");
    if (file.exists()) {
      System.out.println("File already exists");
      System.exit(0);
    }

    // Create a file
    try (PrintWriter output = new PrintWriter(file); ) {
      // Write formatted output to the file
      output.print("Corey T Smith ");
      output.println(90);
      output.print("Nathan K Jones ");
      output.println(85);
    }
  }
}
