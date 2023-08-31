/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch12;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebCrawler {
  private static final int MAX_URL_LINKS = 100;

  private ArrayList<String> listOfPendingUrls = new ArrayList<>();
  private ArrayList<String> listOfTraversedUrls = new ArrayList<>();

  /**
   *
   * @param startingUrl The starting URL to crawl from.
   */
  public WebCrawler(String startingUrl) {
    listOfPendingUrls.add(startingUrl);
  }

  /**
   * Method to start crawling the webpage.
   */
  public void startCrawling() {
    int counter = 1;

    System.out.println("----- Crawling URLs -----");

    while (!listOfPendingUrls.isEmpty() && listOfTraversedUrls.size() <= MAX_URL_LINKS) {
      String urlString = listOfPendingUrls.remove(0);
      listOfTraversedUrls.add(urlString);
      System.out.println("C [" + String.format("%03d", counter++) + "]: " + urlString);

      for (String s : getSubURLs(urlString)) {
        if (!listOfTraversedUrls.contains(s) && !listOfPendingUrls.contains(s)) {
          listOfPendingUrls.add(s);
        }
      }
    }

    printLists();
  }

  /**
   *
   */
  private void printLists() {
    int counter = 1;
    System.out.println();
    System.out.println("----- Traversed URLs -----");
    for (String url : listOfTraversedUrls) {
      System.out.println("T [" + String.format("%04d", counter++) + "]: " + url);
    }
    System.out.println();
    System.out.println("----- Pending URLs -----");
    for (String url : listOfPendingUrls) {
      System.out.println("P [" + String.format("%04d", counter++) + "]: " + url);
    }
    System.out.println();
  }

  /**
   *
   * @param line      the string to search for URL.
   * @param fromIndex the index from which to start the search.
   * @return the index of the first occurrence of a URL, starting at the specified
   *         index, or -1 if there is no such occurrence.
   */
  private int doesStringHaveLink(String line, int fromIndex) {
    int exist = 0;
    exist = line.indexOf("http://", fromIndex);
    if (exist == -1) {
      exist = line.indexOf("https://", fromIndex);
    }
    return exist;
  }

  /**
   *
   * @param urlString
   * @return
   */
  private List<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();

    try {
      URL url = new URL(urlString);
      list = readWebPageForUrls(url);
    } catch (MalformedURLException ex) {
      System.out.println("URL Issues: " + urlString);
      System.out.println("URL Issues: " + ex.getMessage());
    }

    return list;
  }

  /**
   *
   * @param url
   * @return
   */
  private ArrayList<String> readWebPageForUrls(URL url) {
    ArrayList<String> list = new ArrayList<>();
    try (Scanner input = new Scanner(url.openStream())) {
      int current = 0;

      while (input.hasNext()) {
        String line = input.nextLine();

        current = doesStringHaveLink(line, current);

        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) { // Ensure that a correct URL is found, i.e. there is an end to the URL string
            String foundUrl = line.substring(current, endIndex);

            if (foundUrl.indexOf(".png") == -1 &&
                foundUrl.indexOf(".gif") == -1 &&
                foundUrl.indexOf(".jpg") == -1 &&
                foundUrl.indexOf(".jpeg") == -1 &&
                foundUrl.indexOf(".webp") == -1 &&
                foundUrl.indexOf(".svg") == -1 &&
                foundUrl.indexOf(".mp4") == -1 &&
                foundUrl.indexOf(".css") == -1 &&
                foundUrl.indexOf(".js") == -1 &&
                foundUrl.indexOf("/js?") == -1 &&
                foundUrl.length() > 10) {
              // don't add files of types: js, css, images, and so on.
              // make sure URL is longer than "https://"
              list.add(foundUrl);
            }

            current = doesStringHaveLink(line, endIndex);
          } else {
            current = -1;
          }
        }
      }
    } catch (Exception ex) {
      System.err.println("Error: " + ex.getMessage());
    }

    return list;
  }
}
