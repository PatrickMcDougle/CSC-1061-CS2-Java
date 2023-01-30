package edu.csc1061.ch13;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Ch13Program02 {

  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList<>();

    list.add(45); // Add an integer
    list.add(3445.53); // Add a double

    // Add a BigInteger
    list.add(new BigInteger("3432323234344343101124578"));
    // Add a BigDecimal
    list.add(new BigDecimal("2.0909090989091343433344343"));

    System.out.println("The largest number is " + getLargestNumber(list));
  }

  public static Number getLargestNumber(List<Number> list) {
    if (list == null || list.isEmpty()) {
      return null;
    }

    Number number = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (number.doubleValue() < list.get(i).doubleValue()) {
        number = list.get(i);
      }
    }

    return number;
  }
}
