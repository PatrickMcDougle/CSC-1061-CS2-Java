package edu.csc1061.ch09.student;

public class BirthDate1 {

	private int year;
	private int month;
	private int day;

	public BirthDate1() {
		// do nothing at this time.
		System.out.println("Default BirthDate constructor called!");
	}

	public BirthDate1(int year) {
		this(); // Call BirthDate() constructor.
		this.year = year;
	}

	public BirthDate1(int year, int month, int day) {
		this(year);  // call BirthDate(year) constructor.
		this.month = month;
		this.day = day;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
