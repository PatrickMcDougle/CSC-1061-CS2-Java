package edu.csc1061.ch18;

import java.io.File;
import java.util.Scanner;

// example directory:
// C:\Users\<username>\Documents
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
    // Store the total size of all files
    long size = 0;

    // Base case
    if (!file.isDirectory()) {
      size += file.length();
      return size;
    }

    // assume if not a file then a directory

    // Get all files and subdirectories
    File[] files = file.listFiles();
    for (int i = 0; files != null && i < files.length; i++) {
      size += getSize(files[i]); // Recursive call
    }

    return size;
  }
}