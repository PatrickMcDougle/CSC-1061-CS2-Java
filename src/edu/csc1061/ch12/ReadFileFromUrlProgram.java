package edu.csc1061.ch12;

import java.util.Scanner;

public class ReadFileFromUrlProgram {

  public static void main(String[] args) {
    System.out.print("Enter a URL: ");
    String urlString;
    try (Scanner scan = new Scanner(System.in)) {
      urlString = scan.next();
    }

    try {
      java.net.URL url = new java.net.URL(urlString);
      int count = 0;
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();
        count += line.length();
      }
      input.close();

      System.out.println("The file size is " + count + " characters");
    } catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    } catch (java.io.IOException ex) {
      System.out.println("IO Errors");
    }
  }
}
