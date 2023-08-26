/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.exercises_ch18;

public class Example01 {
    public static void main(String[] args) {
        Example01 example01 = new Example01();
        for (int i = 1; i < 20; i++) {
            System.out.println(i + " : " + example01.recursive01(i));
        }
    }

    public int recursive01(int n) {
        if (n == 0) {
            return 1;
        }

        return n - recursive01(n - 1);
    }
}
