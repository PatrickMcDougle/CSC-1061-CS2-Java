/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch09;

public class Ch09TelevisionTest {

  public static void main(String[] args) {
    Ch09Television tv1 = new Ch09Television(); // Create a TV
    tv1.turnOn(); // Turn on tv1
    tv1.setChannel(30);
    tv1.setVolume(3);

    Ch09Television tv2 = new Ch09Television();
    tv2.turnOn();
    tv2.channelUp();
    tv2.channelUp();
    tv2.volumeUp(); // Increase tv2 volume up 1 level

    System.out.println("tv1's channel is " + tv1.channel + " and volume level is " + tv1.volumeLevel);
    System.out.println("tv2's channel is " + tv2.channel + " and volume level is " + tv2.volumeLevel);
  }
}
