package edu.csc1061.ch24;

public class Program24_004 {

  public static void main(String[] args) {
    Patient patient1 = new Patient("John", 2);
    Patient patient2 = new Patient("Jim", 1);
    Patient patient3 = new Patient("Tim", 5); // Create Tim with priority 5
    Patient patient4 = new Patient("Cindy", 7);

    MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
    priorityQueue.enqueue(patient1);
    priorityQueue.enqueue(patient2);
    priorityQueue.enqueue(patient3);
    priorityQueue.enqueue(patient4); // Enqueue patient4

    printQueue(priorityQueue);
  }

  // takes in a priority queue and prints out the contents as it dequeues
  // everything in the list.
  public static void printQueue(MyPriorityQueue<Patient> priorityQueue) {
    while (priorityQueue.getSize() > 0) {
      System.out.print(priorityQueue.dequeue() + " | ");
    }
    System.out.println();
  }

  static class Patient implements Comparable<Patient> {
    private String name;
    private int priority;

    public Patient(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }

    @Override
    public String toString() {
      return name + "(priority:" + priority + ")";
    }

    @Override
    public int compareTo(Patient o) {
      return this.priority - o.priority;
    }
  }
}
