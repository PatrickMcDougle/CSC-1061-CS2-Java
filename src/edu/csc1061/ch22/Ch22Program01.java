package edu.csc1061.ch22;

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
    long startTime = System.currentTimeMillis();
    long k = 0;
    for (long i = 1; i <= n; i++) {
      k = k + 5;
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Execution time for n = " + n + " is " + (endTime - startTime) + " milliseconds");
  }
}
