package edu.csc1061.ch12;

public class WriteProgram {
	public static void main(String[] args) throws java.io.IOException {
		java.io.File file = new java.io.File("scores.no.track.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}

		// Create a file
		java.io.PrintWriter output = new java.io.PrintWriter(file);

		// Write formatted output to the file
		output.print("John T Smith ");
		output.println(90);
		output.print("Eric K Jones ");
		output.println(85);

		// Close the file
		output.close();
	}
}
