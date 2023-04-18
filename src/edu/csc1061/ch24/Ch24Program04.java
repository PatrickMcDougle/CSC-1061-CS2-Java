package edu.csc1061.ch24;

public class Ch24Program04 extends Ch24Program03 {

  public static void main(String[] args) {
    Ch24Program04 program04 = new Ch24Program04();

    System.out.println("\n ========== ========== ========== \n");
    program04.testingStack();
    System.out.println("\n ---------- ---------- ---------- \n");
    program04.testingQueue();
    System.out.println("\n ========== ========== ========== \n");
  }

  public void testingQueue() {
    // Create a queue
    MyQueue<String> queue = new MyQueue<>();

    // Add elements to the queue
    queue.enqueue("Daniel"); // Add a string to the queue
    System.out.println("(07) {" + queue.getSize() + "} " + queue);

    queue.enqueue("Ben"); // Add another string to the queue
    System.out.println("(08) {" + queue.getSize() + "} " + queue);

    queue.enqueue("Frank"); // Add a string to the queue
    queue.enqueue("Gryphon"); // Add another string to the queue
    queue.enqueue("Patrick"); // Add another string to the queue
    queue.enqueue("John"); // Add another string to the queue
    queue.enqueue("Sophia"); // Add another string to the queue
    queue.enqueue("Sora"); // Add another string to the queue
    queue.enqueue("Carter"); // Add another string to the queue
    queue.enqueue("Ron"); // Add another string to the queue
    System.out.println("(09) {" + queue.getSize() + "} " + queue);

    // Remove elements from the queue
    System.out.println("(10) Dequeue: " + queue.dequeue());
    System.out.println("(11) Dequeue: " + queue.dequeue());
    System.out.println("(12) {" + queue.getSize() + "} " + queue);
  }
}
