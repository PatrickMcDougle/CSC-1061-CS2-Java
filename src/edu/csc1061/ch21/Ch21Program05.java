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
package edu.csc1061.ch21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Ch21Program05 {

    public static void main(String[] args) throws Exception {
        Ch21Program05 program = new Ch21Program05();
        program.run();
    }

    // example filename with path:
    // src\edu\csc1061\ch21\Ch21Program01.java
    public void run() throws NullPointerException, FileNotFoundException, IllegalStateException,
            ClassCastException, NoSuchElementException, SecurityException {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a Path and Java source file: ");
            String filename = input.nextLine();

            File file = new File(filename);
            if (file.exists()) {
                System.out.println("The number of keywords in " + file.getName() + " is "
                        + countKeywords(file));
            } else {
                System.out.println("File " + filename + " does not exist");
            }
        }
    }

    /**
     * This method will take in a file and read it to see if it contains any key words in it.
     *
     * @param file - The file to search for key words.
     * @return the number of key words that were found in the file.
     * @throws NullPointerException
     * @throws FileNotFoundException
     * @throws IllegalStateException
     * @throws ClassCastException
     * @throws NoSuchElementException
     */
    public int countKeywords(File file) throws NullPointerException, FileNotFoundException,
            IllegalStateException, ClassCastException, NoSuchElementException {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch",
                "char", "class", "const", "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null",};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }

        return count;
    }
}
