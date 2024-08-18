/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Arrays Vs ArrayList
 */
public class Ch11Program05 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt(); // Read a value from the input

            if (!list.contains(value) && value != 0) {
                list.add(value); // Add the value if it is not in the list
            }
        } while (value != 0);

        // Display the distinct numbers
        System.out.print("The distinct integers are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        input.close();
    }
}
