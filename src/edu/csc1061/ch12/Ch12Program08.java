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
import java.io.IOException;

/** Testing the File Class */
public class Ch12Program08 {

  public static void main(String[] args) {
    File file = new File(".\\src\\edu\\csc1061\\ch12\\Ch12Program08.java");
    System.out.println("Does it exist     | " + file.exists());
    System.out.println("The file has      | " + file.length() + " bytes");
    System.out.println("Can it be read    | " + file.canRead());
    System.out.println("Can it be written | " + file.canWrite());
    System.out.println("Is it a directory | " + file.isDirectory());
    System.out.println("Is it a file      | " + file.isFile());
    System.out.println("Is it absolute    | " + file.isAbsolute());
    System.out.println("Is it hidden      | " + file.isHidden());
    System.out.println("Absolute path     | " + file.getAbsolutePath());
    try {
      System.out.println("Canonical path    | " + file.getCanonicalPath());
    } catch (IOException ex) {
      // Do Nothing
    }
    System.out.println("Name              | " + file.getName());
    System.out.println("Path              | " + file.getPath());
    System.out.println("Last modified on  | " + new java.util.Date(file.lastModified()));
    System.out.println("Path Separator    | " + File.pathSeparatorChar);
    System.out.println("Name Separator    | " + File.separatorChar);
  }
}
