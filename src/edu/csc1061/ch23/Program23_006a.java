package edu.csc1061.ch23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

// create a large file
public class Program23_006a {
  public static final String FILE_NAME = "large_data.dat";

  public static void main(String[] args) throws Exception {
    try (
      DataOutputStream output = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream(FILE_NAME))
      )
    ) {
      Random random = new Random();

      for (int i = 0; i < 2_000_000; i++) {
        output.writeInt(random.nextInt(1_000_000, 9_999_999));
      }
    }

    // Display first 100 numbers
    try (
      DataInputStream input = new DataInputStream(
        new BufferedInputStream(new FileInputStream(FILE_NAME))
      )
    ) {
      for (int i = 0; i < 100; i++) {
        System.out.print(input.readInt() + " ");
      }
    }
  }
}
