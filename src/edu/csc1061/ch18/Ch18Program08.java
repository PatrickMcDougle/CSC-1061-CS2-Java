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
package edu.csc1061.ch18;

import java.util.Scanner;

// Tower of Hanoi
public class Ch18Program08 {
    private static long count = 0;

    /** Main method */
    public static void main(String[] args) {
        int n = 1;

        // Create a Scanner
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter number of disks: ");
            n = input.nextInt();
            runTower(n);
        }

        // for (int i = 0; i < 5; i++) {
        // runTower(n + i);
        // }
    }

    private static void runTower(int n) {
        count = 0;

        // Find the solution recursively
        long startTime = System.nanoTime();
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("Total moves is:" + count);
        long endTime = System.nanoTime();

        System.out.println("Number of disks: " + n);

        long duration = (endTime - startTime);
        System.out.println("Time To Complete (nano): " + duration);
        System.out.println("Time To Complete (msec): " + (duration / 1_000_000L));
        System.out.println("Time To Complete (sec) : " + (duration / 1_000_000_000L));
        System.out.println("Time To Complete (min) : " + (duration / 60_000_000_000L));
    }

    /**
     * The method for finding the solution to move n disks from fromTower to toTower with auxTower.
     *
     * @param n the number of disks
     * @param fromTower the tower position we are starting at
     * @param toTower the tower position we are ending at
     * @param auxTower the tower position of the tower that will help.
     */
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) {
            // Stopping condition
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            count++;
            return;
        }

        moveDisks(n - 1, fromTower, auxTower, toTower);
        System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        count++;
        moveDisks(n - 1, auxTower, toTower, fromTower);
    }
}
