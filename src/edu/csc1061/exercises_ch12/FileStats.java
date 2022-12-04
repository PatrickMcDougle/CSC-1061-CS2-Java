package edu.csc1061.exercises_ch12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStats {

	private static final int ALPHABET_NUMBER = 26;

	private long[] pAlphabetCount = new long[ALPHABET_NUMBER];

	private File pTheFile;

	public void countOccurrencesOfEachLetter() {

		// reset the counters to zero.
		for (int i = 0; i < ALPHABET_NUMBER; ++i) {
			pAlphabetCount[i] = 0;
		}

		try (Scanner fileScanner = new Scanner(pTheFile)) {
			while (fileScanner.hasNextLine()) {
				// read in line of text to analyze
				String line = fileScanner.nextLine();

				// check each character in the line ....
				for (int i = 0; i < line.length(); ++i) {
					// see if it is a letter ....
					if (Character.isLetter(line.charAt(i))) {
						// and if it is a letter, count them up.
						pAlphabetCount[Character.toUpperCase(line.charAt(i)) - 'A']++;
					}
					// else ignore the character
				}
			}
		} catch (FileNotFoundException ex) {
			// File was no found
			System.err.print(
					"\nCharacter occurrence count method in FileStats class could not find the file! ");
			System.err.println("[" + pTheFile + "]\n");
			ex.printStackTrace();
		}
	}

	public long getCharacterCount() {
		long charCount = 0;

		charCount = pTheFile.length();

		return charCount;
	}

	public int getLineCount() {
		int lineCount = 0;

		try (Scanner fileScanner = new Scanner(pTheFile)) {
			while (fileScanner.hasNext()) {
				fileScanner.nextLine();
				lineCount++;
			}
		} catch (FileNotFoundException ex) {
			// File was no found
			System.err.print("\nLine count method in FileStats class could not find the file! ");
			System.err.println("[" + pTheFile + "]\n");
			ex.printStackTrace();
		}

		return lineCount;
	}

	public int getWordCount() {
		int wordCount = 0;

		try (Scanner fileScanner = new Scanner(pTheFile)) {
			while (fileScanner.hasNext()) {
				fileScanner.next();
				wordCount++;
			}
		} catch (FileNotFoundException ex) {
			// File was no found
			System.err.print("\nWord count method in FileStats class could not find the file! ");
			System.err.println("[" + pTheFile + "]\n");
			ex.printStackTrace();
		}

		return wordCount;
	}

	public String printLetterOccurrences() {

		countOccurrencesOfEachLetter();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ALPHABET_NUMBER; ++i) {
			sb.append((char) ('A' + i));
			sb.append(": " + pAlphabetCount[i] + "\n");
		}

		return sb.toString();
	}

	public void setFile(File theFile) throws NullPointerException {
		if (theFile == null) {
			throw new NullPointerException();
		}
		pTheFile = theFile;
	}
}
