package edu.csc1061.ch11;

public class Rectangle extends GeometricObject {
	private double width;
	private double height;

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}

	/** Return width */
	public double getWidth() {
		return width;
	}

	/** Set a new width */
	public void setWidth(double width) {
		this.width = width;
	}

	/** Return height */
	public double getHeight() {
		return height;
	}

	/** Set a new height */
	public void setHeight(double height) {
		this.height = height;
	}

	/** Return area */
	public double getArea() {
		return width * height;
	}

	/** Return perimeter */
	public double getPerimeter() {
		return 2 * (width + height);
	}

	/** Override the toString method defined in GeometricObject */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		sb.insert(0, "Rectangle: { ");
		sb.append(" [dimensions: " );
		sb.append(width);
		sb.append(" x ");
		sb.append(height);
		sb.append("] }");
		return sb.toString();
	}

}
