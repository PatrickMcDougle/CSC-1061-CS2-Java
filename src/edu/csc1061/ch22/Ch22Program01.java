/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch22;

import edu.csc1061.utils.Timer;

// performance Test
public class Ch22Program01 {

  public static void main(String[] args) {
    getTime(1_000_000); // 11 milliseconds
    getTime(10_000_000); // 3 milliseconds
    getTime(100_000_000); // 27 milliseconds
    getTime(1_000_000_000); // 25 milliseconds
    getTime(10_000_000_000L); // 5 seconds
    getTime(100_000_000_000L); // 1 minute
  }

  public static void getTime(long n) {
    Timer.getTimer().start();
    long k = 0;
    for (long i = 1; i <= n; i++) {
      k = k + 5;
    }
    Timer.getTimer().finish();
    System.out.println("Execution time for n = " + n + " is " + Timer.getTimer().getElapsedTime() + " milliseconds");
  }
}
