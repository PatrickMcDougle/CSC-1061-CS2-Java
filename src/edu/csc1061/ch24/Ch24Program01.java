package edu.csc1061.ch24;

public class Ch24Program01 {

  public static void main(String[] args) {
    // Create a list
    MyList<String> list = new MyArrayList<>();

    // Add elements to the list
    list.add("Denver");
    System.out.println("(01) " + list);

    list.add(0, "Boulder");
    System.out.println("(02) " + list);

    list.add("Loveland");
    System.out.println("(03) " + list);

    list.add("Greeley");
    System.out.println("(04) " + list);

    list.add(2, "Colorado Springs"); // Add item to the list at index 2
    System.out.println("(05) " + list);

    list.add(5, "Fort Collins"); // Add item to the list at index 5
    System.out.println("(06) " + list);

    list.add(5, "Littleton"); // Add item to the list at index 5
    System.out.println("(07) " + list);

    list.add(0, "Castle Rock");
    System.out.println("(08) " + list);

    list.add("Avon");
    System.out.println("(09) " + list);

    // Remove elements from the list
    list.remove("Greeley"); // Same as list.remove(0) in this case
    System.out.println("(10) " + list);

    list.remove(1); // Remove the element at index 1
    System.out.println("(11) " + list);

    list.remove(list.size() - 1); // Remove the last element
    System.out.println("(12) " + list);

    System.out.print("(13) ");
    for (String s : list) {
      System.out.print(s.toUpperCase() + " ");
    }
    System.out.println();

    System.out.print("(14) ");
    list.forEach(s -> System.out.print(s.toUpperCase() + " "));
    System.out.println();
  }
}
