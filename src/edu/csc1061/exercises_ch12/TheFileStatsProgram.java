package edu.csc1061.exercises_ch12;

import java.io.File;
import java.util.Scanner;

public class TheFileStatsProgram {

	public static void main(String[] args) throws Throwable {
		File theFile = getFile();

		showStats(theFile);

		System.out.println("End of Program!");
	}

	private static void showStats(File theFile) {
		FileStats fileStats = new FileStats();

		fileStats.setFile(theFile);

		System.out.println("Characters: " + fileStats.getCharacterCount());
		System.out.println("Words: " + fileStats.getWordCount());
		System.out.println("New Lines: " + fileStats.getLineCount());
		System.out.println(fileStats.printLetterOccurrences());
	}

	public static File getFile() {

		Scanner input = new Scanner(System.in);

		File theFile;

		do {
			System.out.print("Enter File To Scan: ");
			String filename = input.nextLine();
			theFile = new File(filename);
		} while (!theFile.exists());

		input.close();

		return theFile;
	}
}
