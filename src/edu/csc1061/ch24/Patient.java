package edu.csc1061.ch24;

import java.util.Objects;

public class Patient implements Comparable<Patient> {

  private String name;
  private int priority;

  public Patient(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }

  @Override
  public String toString() {
    return name + "(priority:" + priority + ")";
  }

  @Override
  public int compareTo(Patient o) {
    return this.priority - o.priority;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, priority);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Patient)) {
      return false;
    }
    Patient that = (Patient) obj;
    return Objects.equals(name, that.name) && priority == that.priority;
  }
}
