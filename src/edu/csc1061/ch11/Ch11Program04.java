/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch11;

import java.util.ArrayList;

/**
 * ArrayList
 */
public class Ch11Program04 {
    private static final String STRING_MIAMI = "Miami";
    private static final String STRING_DENVER = "Denver";

    public static void main(String[] args) {
        // Create a list to store cities
        ArrayList<String> cityList = new ArrayList<>();

        // Add some cities in the list
        cityList.add("London");
        // cityList now contains [London]
        cityList.add(STRING_DENVER);
        // cityList now contains [London, Denver]
        cityList.add("Paris");
        // cityList now contains [London, Denver, Paris]
        cityList.add(STRING_MIAMI);
        // cityList now contains [London, Denver, Paris, Miami]
        cityList.add("Seoul");
        // cityList now contains [London, Denver, Paris, Miami, Seoul]
        cityList.add("Tokyo");
        // cityList now contains [London, Denver, Paris, Miami, Seoul, Tokyo]

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? " + cityList.contains(STRING_MIAMI));
        System.out
                .println("The location of Denver in the list? " + cityList.indexOf(STRING_DENVER));
        System.out.println("Is the list empty? " + cityList.isEmpty()); // Print false

        // Insert a new city at index 2
        cityList.add(2, "Xian");
        // contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]

        // Remove a city from the list
        cityList.remove(STRING_MIAMI);
        // contains [London, Denver, Xian, Paris, Seoul, Tokyo]

        // Remove a city at index 1
        cityList.remove(1);
        // contains [London, Xian, Paris, Seoul, Tokyo]

        // Display the contents in the list
        System.out.println(cityList.toString());

        // Display the contents in the list in reverse order
        for (int i = cityList.size() - 1; i >= 0; i--) {
            System.out.print(cityList.get(i) + " ");
        }
        System.out.println();

        // Create a list to store two circles
        ArrayList<Circle> list = new ArrayList<>();

        // Add two circles
        list.add(new Circle(2));
        list.add(new Circle(3));

        // Display the area of the first circle in the list
        System.out.println("The area of the circle? " + list.get(0).getArea());
    }
}
