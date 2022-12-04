package edu.csc1061.ch21;

import java.util.Set;
import java.util.TreeSet;

/// Testing Tree Set With Comparator
public class Program21_003 {

	public static void main(String[] args) {

		Program21_001 program = new Program21_001();

		Set<String> set;
		set = program.GetHashSet();

		TreeSet<String> treeSet = new TreeSet<>(new CityNameComparator());
		treeSet.addAll(set);

		// Display geometric objects in the tree set
		System.out.println("A sorted set of City Names");
		treeSet.forEach(cityName -> System.out.print(cityName + ", "));
		System.out.println();
	}
}
