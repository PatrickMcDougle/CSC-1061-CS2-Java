package edu.csc1061.ch13;

/**
 * You can now use the Edible interface to specify whether an object is edible.
 * This is accomplished by letting the class for the object implement this
 * interface using the implements keyword. For example, the classes Chicken and
 * Fruit implement the Edible interface (See Ch13Program04).
 */
public class Chicken extends Animal implements IEdible {

  @Override
  public String howToEat() {
    return "Chicken: Fry it";
  }

  @Override
  public String sound() {
    return "Chicken: cock-a-doodle-doo";
  }
}
