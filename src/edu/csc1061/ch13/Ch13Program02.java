package edu.csc1061.ch13;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Ch13Program02 {

  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList<>();

    list.add(45); // Add an integer
    list.add(3445.53); // Add a double
    list.add(Byte.valueOf((byte) 172));
    list.add(Double.valueOf(3.14159265359));
    list.add(Float.valueOf((float) 1.57079632679));
    list.add(Integer.valueOf(172256));
    list.add(Long.valueOf(75_172_029_000_135L));
    list.add(Short.valueOf((short) 16_384));

    // Add a BigInteger
    list.add(new BigInteger("3432323234344343101124578"));

    // The following BigIntegers show that this code has a logic issue.
    // This code is from the book.
    list.add(new BigInteger("123456789012345678901234567890123456789012345678901234567895"));
    list.add(new BigInteger("123456789012345678901234567890123456789012345678901234567890"));
    list.add(new BigInteger("123456789012345678901234567890123456789012345678901234567896"));
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
