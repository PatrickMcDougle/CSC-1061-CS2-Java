package edu.csc1061.ch09.date;

import java.util.Date;
import java.util.Random;

public class MyDateProgram {

  public static void main(String[] args) {
    // DATE STUFF
    System.out.println(" -- DATE STUFF -- ");
    java.util.Date date1 = new java.util.Date();
    System.out.println(date1.toString());
    System.out.println(date1.getTime());
    System.out.println();

    java.util.Date date2 = new java.util.Date(1_547_703_343_509L);
    System.out.println(date2.toString());
    System.out.println(date2.getTime());
    System.out.println();

    // RANDOM STUFF
    System.out.println(" -- RANDOM STUFF -- ");
    // Math.random()
    System.out.println(Math.random());
    System.out.println(Math.random());
    System.out.println(Math.random());
    System.out.println();

    // java.util.Random
    java.util.Random myRandom = new java.util.Random();
    System.out.println(myRandom.nextInt(100));
    System.out.println(myRandom.nextDouble());
    System.out.println(myRandom.nextBoolean());
    System.out.println();

    // java.util.Random(seed)
    Random random1 = new Random(42);
    Random random2 = new Random(42);

    System.out.print("From random1: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(random1.nextInt(100) + " ");
    }
    System.out.println();

    System.out.print("From random2: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(random2.nextInt(100) + " ");
    }
    System.out.println();
  }
}
