/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

// create a large file
public class Ch23Program06a {
    public static final String FILE_NAME = "ch23_large.no.track.data";

    public static final int NUMBERS_OF_NUMBERS = 1_000_000;
    public static final int NUMBER_MIN = 1_000_000;
    public static final int NUMBER_MAX = 9_999_999;

    public static void main(String[] args) throws Exception {
        try (DataOutputStream output =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {
            Random random = new Random();

            for (int i = 0; i < NUMBERS_OF_NUMBERS; i++) {
                output.writeInt(random.nextInt(NUMBER_MIN, NUMBER_MAX));
            }
        }

        // Display first 100 numbers
        try (DataInputStream input =
                new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            for (int i = 0; i < 100; i++) {
                System.out.print(input.readInt() + " ");
            }
        }
    }
}
