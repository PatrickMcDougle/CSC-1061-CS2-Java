package edu.csc1061.exercises_ch12;

public class MyNumber {

  public static int bin2Dec(String binaryString) throws NumberFormatException {
    int number = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      if (binaryString.charAt(i) == '0') {
        // do something
      } else if (binaryString.charAt(i) == '1') {
        // do something else

      } else {
        throw new NumberFormatException("Value not correct");
        // do something else
      }
    }
    return number;
  }
}
