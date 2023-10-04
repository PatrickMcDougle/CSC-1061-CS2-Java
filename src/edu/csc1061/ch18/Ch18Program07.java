/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch18;

import java.io.File;
import java.util.Scanner;

// example directory:
// C:\Java
// ./

// Directory Size
public class Ch18Program07 {

  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter a directory or a file
    System.out.print("Enter a directory or a file: ");

    try (Scanner input = new Scanner(System.in)) {
      String directory = input.nextLine();

      // Display the size
      File file = new File(directory);
      System.out.println(getSize(file) + " bytes");
    }
  }

  public static long getSize(File file) {
    // Base case
    if (!file.isDirectory()) {
      // It is a File
      return file.length();
    }

    // assume if not a file then a directory

    // Store the total size of all files
    long size = 0;

    // Get all files and subdirectories
    File[] files = file.listFiles();
    for (int i = 0; files != null && i < files.length; i++) {
      size += getSize(files[i]); // Recursive call
    }

    return size;
  }
}
