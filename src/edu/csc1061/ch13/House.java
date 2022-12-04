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

	@Override /**
				 * Override the protected clone method defined in
				 * the Object class, and strengthen its accessibility
				 */
	public Object clone() {
		try {
			House h = (House)super.clone();
			h.whenBuilt = (Date) whenBuilt.clone();
			// return super.clone();
			return h;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}

	@Override // Implement the compareTo method defined in Comparable
	public int compareTo(House o) {
		if (area > o.area) {
			return 1;
		}

		if (area < o.area) {
			return -1;
		}

		return 0;
	}
}