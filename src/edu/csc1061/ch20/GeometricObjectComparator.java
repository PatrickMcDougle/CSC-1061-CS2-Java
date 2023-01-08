package edu.csc1061.ch20;

import java.io.Serializable;
import java.util.Comparator;

public class GeometricObjectComparator
  implements Comparator<GeometricObject>, Serializable {
  /**
   * Auto Generated Serial Version UID
   */
  private static final long serialVersionUID = -5361279448585876327L;

  public int compare(GeometricObject o1, GeometricObject o2) {
    return o1.getArea() > o2.getArea()
      ? 1
      : o1.getArea() == o2.getArea() ? 0 : -1;
  }
}
