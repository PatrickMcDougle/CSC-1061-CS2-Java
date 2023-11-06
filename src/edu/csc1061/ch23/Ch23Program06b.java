/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;

// Sort Large File
public class Ch23Program06b {
  public static final String FILE_NAME_INPUT = "ch23_large.no.track.data";
  public static final String FILE_NAME_OUTPUT = "ch23_sorted_file.no.track.data";
  public static final int MAX_ARRAY_SIZE = 43;
  public static final int BUFFER_SIZE = 100_000;

  /**
   * The main method for this application.
   *
   * @param args arguments from the command line. Not used.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println("Start");

    // Sort ch23_large.no.track.data to ch23_sorted_file.no.track.data
    sort(FILE_NAME_INPUT, FILE_NAME_OUTPUT);

    // Display the first 100 numbers in the sorted file
    displayFile(FILE_NAME_OUTPUT);

    System.out.println("\nDone");
  }

  /**
   * Sort data in source file and into target file
   *
   * @param sourceFile
   * @param targetFile
   * @throws Exception
   */
  public static void sort(String sourceFile, String targetFile) throws IOException {
    // Implement Phase 1: Create initial segments
    int numberOfSegments =
        initializeSegments(MAX_ARRAY_SIZE, sourceFile, "ch23_file1.no.track.data");

    // Implement Phase 2: Merge segments recursively
    merge(
        numberOfSegments,
        MAX_ARRAY_SIZE,
        "ch23_file1.no.track.data",
        "ch23_file2.no.track.data",
        "ch23_file3.no.track.data",
        targetFile);
  }

  /**
   * Sort original file into sorted segments
   *
   * @param segmentSize
   * @param originalFile
   * @param file1
   * @return
   * @throws SecurityException
   * @throws IOException
   */
  private static int initializeSegments(int segmentSize, String originalFile, String file1)
      throws SecurityException, IOException {
    int[] list = new int[segmentSize];
    int numberOfSegments = 0;
    try (DataInputStream input =
            new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        DataOutputStream output =
            new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file1)))) {
      while (input.available() > 0) {
        numberOfSegments++;
        int i = 0;
        while (input.available() > 0 && i < segmentSize) {
          list[i++] = input.readInt();
        }

        // Sort an array list[0..i-1]
        java.util.Arrays.sort(list, 0, i);

        // Write the array to ch23_file1.no.track.data
        for (int j = 0; j < i; j++) {
          output.writeInt(list[j]);
        }
      }
    }
    return numberOfSegments;
  }

  /**
   * @param numberOfSegments
   * @param segmentSize
   * @param file1
   * @param file2
   * @param file3
   * @param targetFile
   * @throws NoSuchFileException
   * @throws DirectoryNotEmptyException
   * @throws IOException
   */
  private static void merge(
      int numberOfSegments,
      int segmentSize,
      String file1,
      String file2,
      String file3,
      String targetFile)
      throws IOException {
    if (numberOfSegments > 1) {
      mergeOneStep(numberOfSegments, segmentSize, file1, file2, file3);

      int newNumOfSegments = (numberOfSegments + 1) / 2;
      int newSegments = segmentSize * 2;
      merge(newNumOfSegments, newSegments, file3, file1, file2, targetFile);
    } else {
      // Rename file1 as the final sorted file
      File sortedFile = new File(targetFile);
      if (sortedFile.exists() && (!sortedFile.delete())) {
        // file delete failed.  Take appropriate action.
        System.err.printf("File %s was not deleted%n", sortedFile);
      }
      if (!new File(file1).renameTo(sortedFile)) {
        // file was not renamed.  Take appropriate action.
        System.err.printf("File %s was not renamed to %s%n", file1, sortedFile);
      }
    }
  }

  /**
   * @param numberOfSegments
   * @param segmentSize
   * @param file1
   * @param file2
   * @param file3
   * @throws SecurityException
   * @throws IllegalArgumentException
   * @throws IOException
   */
  private static void mergeOneStep(
      int numberOfSegments, int segmentSize, String file1, String file2, String file3)
      throws SecurityException, IllegalArgumentException, IOException {
    try (DataInputStream file1Input =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file1), BUFFER_SIZE))) {
      try (DataOutputStream file2Output =
          new DataOutputStream(
              new BufferedOutputStream(new FileOutputStream(file2), BUFFER_SIZE))) {
        // Copy half number of segments from file1.dat to file2.dat
        copyHalfToFile2(numberOfSegments, segmentSize, file1Input, file2Output);
      }

      // Merge remaining segments in file1 with segments in file2 into file3
      try (DataInputStream file2Input =
              new DataInputStream(
                  new BufferedInputStream(new FileInputStream(file2), BUFFER_SIZE));
          DataOutputStream file3Output =
              new DataOutputStream(
                  new BufferedOutputStream(new FileOutputStream(file3), BUFFER_SIZE))) {
        mergeSegments(numberOfSegments / 2, segmentSize, file1Input, file2Input, file3Output);
      }
    }
  }

  /**
   * Copy first half number of segments from ch23_file1.no.track.data to ch23_file2.no.track.data
   *
   * @param numberOfSegments
   * @param segmentSize
   * @param file1
   * @param file2
   * @throws IOException
   */
  private static void copyHalfToFile2(
      int numberOfSegments, int segmentSize, DataInputStream file1, DataOutputStream file2)
      throws IOException {
    int toValue = (numberOfSegments * segmentSize) / 2;
    for (int i = 0; i < toValue; i++) {
      file2.writeInt(file1.readInt());
    }
  }

  /**
   * Merge all segments
   *
   * @param numberOfSegments
   * @param segmentSize
   * @param file1
   * @param file2
   * @param file3
   * @throws IOException
   */
  private static void mergeSegments(
      int numberOfSegments,
      int segmentSize,
      DataInputStream file1,
      DataInputStream file2,
      DataOutputStream file3)
      throws IOException {
    for (int i = 0; i < numberOfSegments; i++) {
      mergeTwoSegments(segmentSize, file1, file2, file3);
    }

    // If file1 has one extra segment, copy it to file3
    while (file1.available() > 0) {
      file3.writeInt(file1.readInt());
    }
  }

  /**
   * Merges two segments
   *
   * @param segmentSize
   * @param file1
   * @param file2
   * @param file3
   * @throws IOException
   */
  private static void mergeTwoSegments(
      int segmentSize, DataInputStream file1, DataInputStream file2, DataOutputStream file3)
      throws IOException {
    int intFromFile1 = file1.readInt();
    int intFromFile2 = file2.readInt();
    int file1Count = 1;
    int file2Count = 1;

    boolean keepWorking = true;
    while (keepWorking) {
      if (intFromFile1 < intFromFile2) {
        file3.writeInt(intFromFile1);
        if (file1.available() == 0 || file1Count++ >= segmentSize) {
          file3.writeInt(intFromFile2);
          // break
          keepWorking = false;
        } else {
          intFromFile1 = file1.readInt();
        }
      } else {
        file3.writeInt(intFromFile2);
        if (file2.available() == 0 || file2Count++ >= segmentSize) {
          file3.writeInt(intFromFile1);
          // break
          keepWorking = false;
        } else {
          intFromFile2 = file2.readInt();
        }
      }
    }

    readFromWriteTo(file1, file3, file1Count, segmentSize);
    readFromWriteTo(file2, file3, file2Count, segmentSize);
  }

  /**
   * Updated code so that code that does the same stuff is written once in a method and called
   * multiple times to get the job done.
   *
   * @param inputStream input stream where int values are read from.
   * @param outputStream output stream where int values are written to.
   * @param count The count so far of the ints read in from input stream
   * @param segmentSize The Size of the segment we are working with.
   * @throws IOException
   */
  private static void readFromWriteTo(
      DataInputStream inputStream, DataOutputStream outputStream, int count, int segmentSize)
      throws IOException {
    while (inputStream.available() > 0 && count++ < segmentSize) {
      outputStream.writeInt(inputStream.readInt());
    }
  }

  /**
   * Display the first 100 numbers in the specified file
   *
   * @param filename
   */
  public static void displayFile(String filename) {
    try (DataInputStream input = new DataInputStream(new FileInputStream(filename))) {
      for (int i = 0; i < 100; i++) System.out.print(input.readInt() + " ");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
