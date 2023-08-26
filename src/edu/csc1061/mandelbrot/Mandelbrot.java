/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.mandelbrot;

public final class Mandelbrot {

    // no need to instantiate this class.
    private Mandelbrot() {
    }

    /**
     * Does stuff.
     *
     * @param n0  The starting complex number
     * @param max the maximum number of iterations
     * @return number of iterations to check if c = a + ib is in Mandelbrot set
     */
    public static int numberOfIterations(Complex n0, int max) {
        Complex n = n0;

        for (int i = 0; i < max; ++i) {
            if (n.abs() > 2.0) {
                return i;
            }
            n = n.times(n).plus(n0);
        }
        return max;
    }
}
