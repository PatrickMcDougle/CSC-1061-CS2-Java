/**
 * HOMEWORK FILE
 * This file is part of the homework.  Use this file to test your TwoWayLinkedList class.
 */

package edu.csc1061.ch24;

import java.util.ListIterator;
import java.util.Scanner;

public class TestTwoWayLinkedList {

    public static void main(String[] args) {
        new TestTwoWayLinkedList();
    }

    public TestTwoWayLinkedList() {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();

        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);

        double[] v = new double[5];
        for (int i = 0; i < 5; i++) {
            v[i] = input.nextDouble();
        }

        input.close();

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        ListIterator<Double> iterator1 = list.listIterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);

        System.out.println();
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous() + " ");
        }
    }
}
