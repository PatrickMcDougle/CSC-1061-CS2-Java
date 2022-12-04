package edu.csc1061.ch13;

import java.math.BigInteger;
import java.util.Arrays;

public class Ch13Program05 {

  public static void main(String[] args) {
    String[] cities = { "Savannah", "Boston", "Tampa", "Atlanta" };

    Arrays.sort(cities);
    for (String city : cities) {
      System.out.print(city + " ");
    }
    System.out.println();

    BigInteger[] hugeNumbers = {
      BigInteger.valueOf(2323231092923992L),
      BigInteger.valueOf(432232323239292L),
      BigInteger.valueOf(54623239292L),
    };

    Arrays.sort(hugeNumbers);
    for (BigInteger number : hugeNumbers) {
      System.out.print(number + " ");
    }
  }
}
