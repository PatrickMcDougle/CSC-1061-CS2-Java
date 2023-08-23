package edu.csc1061.exercises_ch10;

public class programA2 {

    public class InsiderClass {
        int value;
        int size;
    }


  private int value = 1;

  public void setValue(int newValue) {
    value = newValue;
  }

  public programA2() {
    value = 2;
  }

  public int getValue() {
    return value;
  }

  public static void main(String[] args) {
    // where everything starts.
    MyInteger myInteger = new MyInteger(10);
  }
}
