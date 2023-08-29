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

public class Ch09Television {
  int channel = 1; // Default channel is 1
  int volumeLevel = 1; // Default volume level is 1
  boolean on = false; // By default TV is off

  public Ch09Television() {
    // The default no-arg constructor for this class.
  }

  public void turnOn() {
    on = true;
  }

  public void turnOff() {
    on = false;
  }

  public void setChannel(int newChannel) {
    if (on && newChannel >= 1 && newChannel <= 120) {
      channel = newChannel;
    }
  }

  public void setVolume(int newVolumeLevel) {
    if (on && newVolumeLevel >= 0 && newVolumeLevel <= 100) {
      volumeLevel = newVolumeLevel;
    }
  }

  public void channelUp() {
    if (on && channel < 120) {
      channel++;
    }
  }

  public void channelDown() {
    if (on && channel > 1) {
      channel--;
    }
  }

  public void volumeUp() {
    if (on && volumeLevel < 100) {
      volumeLevel++;
    }
  }

  public void volumeDown() {
    if (on && volumeLevel > 0) {
      volumeLevel--;
    }
  }
}
