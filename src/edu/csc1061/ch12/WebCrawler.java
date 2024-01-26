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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebCrawler {
  private static final int MAX_URL_LINKS = 100;

  private ArrayList<String> listOfPendingUrls = new ArrayList<>();
  private ArrayList<String> listOfTraversedUrls = new ArrayList<>();

  /**
   * @param startingUrl The starting URL to crawl from.
   */
  public WebCrawler(String startingUrl) {
    listOfPendingUrls.add(startingUrl);
  }

  /** Method to start crawling the webpage. */
  public void startCrawling() {
    int counter = 1;

    System.out.println("----- Crawling URLs -----");

    while (!listOfPendingUrls.isEmpty() && listOfTraversedUrls.size() <= MAX_URL_LINKS) {
      String urlString = listOfPendingUrls.remove(0);
      listOfTraversedUrls.add(urlString);
      System.out.println(String.format("C [%03d]: %s", counter++, urlString));

      for (String s : getSubURLs(urlString)) {
        if (!listOfTraversedUrls.contains(s) && !listOfPendingUrls.contains(s)) {
          listOfPendingUrls.add(s);
        }
      }
    }

    printLists();
  }

  /** This method prints the list of traversed URLs and the URLs still pending to be traversed. */
  private void printLists() {
    int counter = 1;
    System.out.println();
    System.out.println("----- Traversed URLs -----");
    for (String url : listOfTraversedUrls) {
      System.out.println(String.format("T [%04d]: %s", counter++, url));
    }
    System.out.println();
    System.out.println("----- Pending URLs -----");
    for (String url : listOfPendingUrls) {
      System.out.println(String.format("P [%04d]: %s", counter++, url));
    }
    System.out.println();
  }

  /**
   * @param line the string to search for URL.
   * @param fromIndex the index from which to start the search.
   * @return the index of the first occurrence of a URL, starting at the specified index, or -1 if
   *     there is no such occurrence.
   */
  private int whereDoesTheLinkStart(String line, int fromIndex) {
    int exist = 0;

    // check to see if http:// is in the line of webpage.
    exist = line.indexOf("http://", fromIndex);

    // if we did not find the http, then check for https
    if (exist == -1) {
      // check to see if https:// is in the line of webpage.
      exist = line.indexOf("https://", fromIndex);
    }

    return exist;
  }

  /**
   * @param urlString
   * @return
   */
  private List<String> getSubURLs(String urlString) {
    ArrayList<String> list;

    try {
      list = readWebPageForUrls(new URI(urlString));
    } catch (URISyntaxException ex) {
      list = new ArrayList<>();
      System.out.println("URL Issues: " + urlString);
      System.out.println("URL Issues: " + ex.getMessage());
    }

    return list;
  }

  /**
   * @param url
   * @return
   */
  private ArrayList<String> readWebPageForUrls(URI url) {
    ArrayList<String> list = new ArrayList<>();
    try (Scanner input = new Scanner(url.toURL().openStream())) {
      // Does the page have more to look at?
      while (input.hasNext()) {
        // Get the next line from the webpage so that we can analyze it.
        String line = input.nextLine();

        list.addAll(readLineForUrls(line));
      }
    } catch (IOException ex) {
      int httpResponseCodeIndex = ex.getMessage().indexOf(RESPONSE_CODE_SEARCH_STRING);
      if (httpResponseCodeIndex >= 0) {
        printResponseCode(ex.getMessage(), httpResponseCodeIndex);
      } else {
        System.err.println("IOException Error: " + ex.getMessage());
        System.err.println("IOException Error: " + ex);
      }
    } catch (Exception ex) {
      System.err.println("Exception Error: " + ex.getMessage());
    }

    return list;
  }

  private static final String RESPONSE_CODE_SEARCH_STRING = "HTTP response code: ";

  private void printResponseCode(String errorMessage, int codeIndex) {

    String codeMeaning;
    codeIndex += RESPONSE_CODE_SEARCH_STRING.length();

    int codeNumber = Integer.parseInt(errorMessage.substring(codeIndex).split(" ")[0]);

    switch (codeNumber) {
      case 204:
        codeMeaning = "No Content";
        break;
      case 400:
        codeMeaning = "Bad Request";
        break;
      case 403:
        codeMeaning = "Forbidden";
        break;
      case 404:
        codeMeaning = "Not Found";
        break;
      case 999:
        codeMeaning = "Request Denied - Too many requests - Slow Down!";
        break;
      default:
        codeMeaning = "???";
        break;
    }

    System.err.println(
        String.format("= =====: ERROR [%d] %s: %s", codeNumber, codeMeaning, errorMessage));
  }

  private ArrayList<String> readLineForUrls(String line) {
    ArrayList<String> list = new ArrayList<>();

    int startOfUrlIndex = whereDoesTheLinkStart(line, 0);

    while (startOfUrlIndex >= 0) {
      // Found start of URL, now find the end.
      int endOfUrlIndex = line.indexOf("\"", startOfUrlIndex);

      // Ensure that a correct URL is found, i.e. there is an end to the URL string and its after
      // the start of the URL.
      if (endOfUrlIndex > startOfUrlIndex) {
        // Now take the URL out of the string.
        String foundUrl = line.substring(startOfUrlIndex, endOfUrlIndex);

        if (shouldWeUseThisUrl(foundUrl)) {
          list.add(foundUrl);
        }

        // Check to see if there is another URL in this string before moving on.
        startOfUrlIndex = whereDoesTheLinkStart(line, endOfUrlIndex);
      } else {
        // Not sure why we didn't find an end of the URL, so just assume bad webpage development
        // and move on.
        startOfUrlIndex = -1;
      }
    }

    return list;
  }

  private boolean shouldWeUseThisUrl(String checkUrl) {
    return checkUrl.indexOf(".png") == -1 // ignore images
        && checkUrl.indexOf(".gif") == -1
        && checkUrl.indexOf(".jpg") == -1
        && checkUrl.indexOf(".jpeg") == -1
        && checkUrl.indexOf(".webp") == -1
        && checkUrl.indexOf(".svg") == -1
        && checkUrl.indexOf(".mp4") == -1 // ignore video
        && checkUrl.indexOf("}}") == -1 // ignore whatever this is
        && checkUrl.indexOf(".css") == -1 // ignore css
        && checkUrl.indexOf(".js") == -1 // ignore javascript
        && checkUrl.indexOf("/js?") == -1
        // ignore links less than 10 character in length i.e. "https://.x"
        && checkUrl.length() > 10;
  }
}
