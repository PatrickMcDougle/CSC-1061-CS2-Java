package edu.csc1061.ch13;

public class Program006 {

	public static void main(String[] args) {

		RectangleComparable[] rectangles =
				{new RectangleComparable(3.4, 5.4), new RectangleComparable(13.24, 55.4),
						new RectangleComparable(7.4, 35.4), new RectangleComparable(1.4, 25.4)};

		java.util.Arrays.sort(rectangles);

		for (Rectangle rectangle : rectangles) {
			System.out.print(rectangle + " ");
			System.out.println();
		}
	}
}
