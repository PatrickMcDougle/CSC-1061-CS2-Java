package edu.csc1061.ch18;

import java.io.File;
import java.util.Scanner;

// example directory:
// C:\Users\Cland\OneDrive - Arapahoe Community College\CSC 161 Computer Science 2 (Java)\Code-Examples
// D:\Drives\OneDrive - Colorado Community College System\CSC 1061 - Computer Science 2 - Java\Code-Examples

// Directory Size
public class DirectorySize {

  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter a directory or a file
    System.out.print("Enter a directory or a file: ");

    try (Scanner input = new Scanner(System.in)) {
      String directory = input.nextLine();

      // Display the size
      System.out.println(getSize(new File(directory)) + " bytes");
    }
  }

  public static long getSize(File file) {
    long size = 0; // Store the total size of all files

    if (file.isDirectory()) {
      File[] files = file.listFiles(); // All files and subdirectories
      for (int i = 0; files != null && i < files.length; i++) {
        size += getSize(files[i]); // Recursive call
      }
    } else { // Base case
      size += file.length();
    }

    return size;
  }
}
