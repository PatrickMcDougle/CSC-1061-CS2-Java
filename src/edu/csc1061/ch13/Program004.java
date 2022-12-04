package edu.csc1061.ch13;

// You can now use the Edible interface to specify whether an object is edible.
// This is accomplished by letting the class for the object implement this
// interface using the implements keyword. For example, the classes Chicken and
// Fruit implement the Edible interface (See Program004).

public class Program004 {
	public static void main(String[] args) {
		Object[] objects = {new Tiger(), new Chicken(), new Apple()};
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof IEdible)
				System.out.println(((IEdible) objects[i]).howToEat());

			if (objects[i] instanceof Animal) {
				System.out.println(((Animal) objects[i]).sound());
			}
		}
	}

}
