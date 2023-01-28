package edu.csc1061.ch14;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// Binding Demo
public class JavaFx006Program {

  public static void main(String[] args) {
    // Unidirectional Binding
    DoubleProperty d1 = new SimpleDoubleProperty(1);
    DoubleProperty d2 = new SimpleDoubleProperty(2);

    d1.bind(d2); // Bind d1 with d2

    System.out.println(
      "d1 is " + d1.getValue() + " and d2 is " + d2.getValue()
    );
    d2.setValue(70.2);
    System.out.println(
      "d1 is " + d1.getValue() + " and d2 is " + d2.getValue()
    );
    // Can not setValue on d1. Exception will be thrown.

    // Bidirectional Binding
    DoubleProperty d3 = new SimpleDoubleProperty(1);
    DoubleProperty d4 = new SimpleDoubleProperty(2);

    d3.bindBidirectional(d4);

    System.out.println(
      "d3 is " + d3.getValue() + " and d4 is " + d4.getValue()
    );
    d3.setValue(50.1);
    System.out.println(
      "d3 is " + d3.getValue() + " and d4 is " + d4.getValue()
    );
    d4.setValue(70.2);
    System.out.println(
      "d3 is " + d3.getValue() + " and d4 is " + d4.getValue()
    );
  }
}
