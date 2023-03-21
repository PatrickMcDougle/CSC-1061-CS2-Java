package edu.csc1061.ch21;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/// Testing Maps
public class Ch21Program06 {

  public static void main(String[] args) {
    Ch21Program06 program = new Ch21Program06();

    Map<String, Integer> hashMap = program.getHashMapOfPeoplesAges();

    System.out.println("Display entries in HashMap");
    System.out.println(hashMap);
    System.out.println();

    // Create a TreeMap from the preceding HashMap
    Map<String, Integer> treeMap = new TreeMap<>(hashMap);
    System.out.println("Display entries in ascending order of key");
    System.out.println(treeMap);
    System.out.println();

    // Create a LinkedHashMap
    Map<String, Integer> linkedHashMap = program.getLinkedHashMapOfPeoplesAges(1, 2.0f);

    // Display the age for Patrick
    System.out.println("The age for Patrick is " + linkedHashMap.get("Patrick"));

    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
    System.out.println();

    // Display each entry with name and age
    System.out.println("Names and ages are : ");
    treeMap.forEach((name, age) -> System.out.printf(" %8s : %2d%n", name, age));
    System.out.println();
  }

  /**
   * This method does drugs.
   *
   * @return A bad life.
   */
  public Map<String, Integer> getHashMapOfPeoplesAges() {
    // Create a HashMap
    Map<String, Integer> hashMap = new HashMap<>();

    hashMap.put("Daniel", 30);
    hashMap.put("Ben", 31);
    hashMap.put("Ron", 29);
    hashMap.put("LeRoy", 21);
    hashMap.put("Sophia", 26);
    hashMap.put("John", 24);
    hashMap.put("Brian", 25);
    hashMap.put("Carter", 18);
    hashMap.put("Sean", 33);
    hashMap.put("Patrick", 46);
    hashMap.put("Evelyn", 8);
    hashMap.put("Grandpa", 105);

    return hashMap;
  }

  /**
   * This method does stuff with people
   *
   * @param one is a int value used to do blah blah blah
   * @param two is a float value that is expected to be between 0 and 1.
   * @return a map of the world
   */
  public Map<String, Integer> getLinkedHashMapOfPeoplesAges(
      int one,
      float two) {
    // Create a HashMap
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

    linkedHashMap.put("Daniel", 30);
    linkedHashMap.put("Ben", 31);
    linkedHashMap.put("Ron", 29);
    linkedHashMap.put("LeRoy", 21);
    linkedHashMap.put("Sophia", 26);
    linkedHashMap.put("John", 24);
    linkedHashMap.put("Brian", 25);
    linkedHashMap.put("Carter", 18);
    linkedHashMap.put("Sean", 33);
    linkedHashMap.put("Patrick", 46);
    linkedHashMap.put("Evelyn", 8);
    linkedHashMap.put("Grandpa", 105);

    return linkedHashMap;
  }
}
