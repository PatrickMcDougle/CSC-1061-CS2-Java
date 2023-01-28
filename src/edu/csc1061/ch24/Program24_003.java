package edu.csc1061.ch24;

public class Program24_003 {

  public static void main(String[] args) {
    System.out.println("\n ========== ========== ========== ");
    TestingStack();
    System.out.println("\n ---------- ---------- ---------- ");
    TestingQueue();
    System.out.println("\n ========== ========== ========== ");
  }

  public static void TestingStack() {
    // Create a stack
    MyStack<String> stack = new MyStack<>();

    // Add elements to the stack
    stack.push("Daniel"); // Push a string to the stack
    System.out.println("(01) {" + stack.getSize() + "} " + stack);

    stack.push("Ben"); // Push another string to the the stack
    System.out.println("(02) {" + stack.getSize() + "} " + stack);

    stack.push("Frank"); // Push it to the stack
    stack.push("Gryphon"); // Push another string to the stack
    stack.push("Patrick"); // Push another string to the stack
    stack.push("John"); // Push another string to the stack
    stack.push("Sophia"); // Push another string to the stack
    stack.push("Sora"); // Push another string to the stack
    stack.push("Carter"); // Push another string to the stack
    stack.push("Ron"); // Push another string to the stack
    System.out.println("(03) {" + stack.getSize() + "} " + stack);

    // Remove elements from the stack
    System.out.println("(04) Pop: " + stack.pop());
    System.out.println("(05) Pop: " + stack.pop());
    System.out.println("(06) {" + stack.getSize() + "} " + stack);
  }

  public static void TestingQueue() {
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
