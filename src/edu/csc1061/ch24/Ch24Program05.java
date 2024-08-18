/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch24;

public class Ch24Program05 {

    public static void main(String[] args) {
        Ch24Program05 program05 = new Ch24Program05();

        program05.usePriorityQueue();
    }

    /** This method uses the priority queue class that we created. */
    public void usePriorityQueue() {
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

    /**
     * Takes in a priority queue and prints out the contents as it dequeues everything in the list.
     *
     * @param priorityQueue
     */
    private void printQueue(MyPriorityQueue<Patient> priorityQueue) {
        while (priorityQueue.getSize() > 0) {
            System.out.print("| " + priorityQueue.dequeue() + " |");
        }
        System.out.println();
    }
}
