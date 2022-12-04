package edu.csc1061.ch09.circle;

public class MyCircle1Program {
	 // Main method
	  public static void main(String[] args) {
	    // Create a circle with radius 1
	    Circle1 circle1 = new Circle1();
	    System.out.println("The area of the circle with a radius "
	      + circle1.getRadius() + " is " + circle1.getArea());

	    // Create a circle with radius 25
	    Circle1 circle2 = new Circle1(25);
	    System.out.println("The area of the circle with a radius "
	      + circle2.radius + " is " + circle2.getArea());

	    // Create a circle with radius 125
	    Circle1 circle3 = new Circle1(125);
	    System.out.println("The area of the circle with a radius "
	      + circle3.radius + " is " + circle3.getArea());

	    // Modify circle radius
	    circle2.setRadius(100);
	    System.out.println("The area of the circle with a radius "
	  	      + circle2.getRadius() + " is " + circle2.getArea());
	    System.out.println("The perimeter of the circle with a radius "
	  	      + circle2.getRadius() + " is " + circle2.getPerimeter());
	  }
}
