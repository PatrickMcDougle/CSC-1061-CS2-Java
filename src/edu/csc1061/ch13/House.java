/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch13;

import java.util.Date;

public class House implements Cloneable, Comparable<House> {
  private int id;
  private double area;
  private java.util.Date whenBuilt;

  public House(int id, double area) {
    this.id = id;
    this.area = area;
    whenBuilt = new java.util.Date();
  }

  public int getId() {
    return id;
  }

  public double getArea() {
    return area;
  }

  public java.util.Date getWhenBuilt() {
    return whenBuilt;
  }

  /**
   * Override the protected clone method defined in
   * the Object class, and strengthen its accessibility
   */
  @Override
  public Object clone() {
    try {
      House h = (House) super.clone();
      h.whenBuilt = (Date) whenBuilt.clone();
      return h;
    } catch (CloneNotSupportedException ex) {
      return new House(0, 0.0);
    }
  }

  // Implement the compareTo method defined in Comparable
  @Override
  public int compareTo(House o) {
    if (area > o.area) {
      return 1;
    }

    if (area < o.area) {
      return -1;
    }

    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof House) {
      House other = (House) obj;
      return this.id == other.id && this.area == other.area;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    int prime = 31;
    hash = prime * hash + id + (int) area;
    return hash;
  }
}
