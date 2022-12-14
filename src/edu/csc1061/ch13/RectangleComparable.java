package edu.csc1061.ch13;

public class RectangleComparable
  extends Rectangle
  implements Comparable<RectangleComparable> {

  /** Construct a ComparableRectangle with specified properties */
  public RectangleComparable(double width, double height) {
    super(width, height);
  }

  @Override // Implement the compareTo method defined in Comparable
  public int compareTo(RectangleComparable o) {
    if (getArea() > o.getArea()) {
      return 1;
    }
    if (getArea() < o.getArea()) {
      return -1;
    }

    return 0;
  }

  @Override // Implement the toString method in GeometricObject
  public String toString() {
    return (
      "Width: " + getWidth() + " Height: " + getHeight() + " Area: " + getArea()
    );
  }
}
