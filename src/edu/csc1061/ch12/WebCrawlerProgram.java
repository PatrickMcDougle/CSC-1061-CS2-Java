/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

import java.util.Scanner;

public class WebCrawlerProgram {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter a URL: ");

      // example URL to try: https://github.com/PatrickMcDougle
      String url = input.nextLine();

      WebCrawler webCrawler = new WebCrawler(url);

      // Traverse the Web from the a starting url
      webCrawler.startCrawling();
    }

    System.out.println("Done!");
  }
}
