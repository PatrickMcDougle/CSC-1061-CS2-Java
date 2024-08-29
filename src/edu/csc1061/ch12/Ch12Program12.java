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
package edu.csc1061.ch12;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/** Replace text in a file */
public class Ch12Program12 {

    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 4) {
            System.out.println(
                    "Usage: java edu.csc1061.ch12.Ch12Program12 <sourceFile> <targetFile> <oldStr> <newStr>");
            // Example of what should be used to execute this:
            // java edu.csc1061.ch12.Ch12Program12 ../scores.no.track.txt
            // ../scores-updated.no.track.txt John Patrick
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }

        try (
                // Create input and output files both in the try statement!!!
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);) {

            // once the files are created, do the work.
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
