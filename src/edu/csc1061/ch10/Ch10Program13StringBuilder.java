/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch10;

public class Ch10Program13StringBuilder {

  public static void main(String[] args) {
    StringBuilder stringBuilder = new StringBuilder();

    System.out.println(stringBuilder.toString());
    stringBuilder.append("Welcome to Java");
    System.out.println(stringBuilder.toString());
    stringBuilder.insert(11, "HTML and ");
    System.out.println(stringBuilder.toString());
    stringBuilder.delete(8, 11);
    System.out.println(stringBuilder.toString());
    stringBuilder.deleteCharAt(8);
    System.out.println(stringBuilder.toString());
    stringBuilder.reverse();
    System.out.println(stringBuilder.toString());
    stringBuilder.reverse();
    System.out.println(stringBuilder.toString());
    stringBuilder.replace(11, 15, "HTML");
    System.out.println(stringBuilder.toString());
    stringBuilder.setCharAt(0, 'w');
    System.out.println(stringBuilder.toString());
    System.out.println();
  }
}
