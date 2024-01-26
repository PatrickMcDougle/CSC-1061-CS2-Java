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
import java.util.Scanner;

/** Read from a file */
public class Ch12Program09 {

  public static void main(String[] args) throws Exception {
    // Create a File instance
    File file = new File("scores.no.track.txt");

    // Create a Scanner for the file
    Scanner input = new Scanner(file);

    // Read data from a file
    while (input.hasNext()) {
      String firstName = input.next();
      String mi = input.next();
      String lastName = input.next();
      int score = input.nextInt();
      System.out.println(firstName + " " + mi + " " + lastName + " " + score);
    }

    // Close the file
    input.close();
  }
}
