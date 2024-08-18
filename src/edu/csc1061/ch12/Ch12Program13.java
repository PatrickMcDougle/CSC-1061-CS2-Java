/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch12;

import java.net.*;
import java.util.Scanner;

/** Read a file from a URL */
public class Ch12Program13 {

    public static void main(String[] args) {
        System.out.print("Enter a URL: ");
        String urlString;
        try (Scanner scan = new Scanner(System.in)) {
            urlString = scan.next();
        }

        try {
            // java.net.URL is deprecated in Java 20.
            // https://inside.java/2023/02/15/quality-heads-up/
            // JDK 20 will deprecate all public constructors of java.net.URL. To construct a URL,
            // the URI::toURL alternative should instead be preferred.
            URL urlIsDeprecated = new URL(urlString);

            URI uri = new URI(urlString);

            int count = 0;
            Scanner input = new Scanner(uri.toURL().openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println(line);
                count += line.length();
            }
            input.close();

            System.out.println("The file size is " + count + " characters");
        } catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL was entered [" + urlString + "]");
        } catch (URISyntaxException ex) {
            System.out.println("Invalid URI was entered [" + urlString + "]");
        } catch (java.io.IOException ex) {
            System.out.println("IO Errors");
        }
    }
}
