/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.mandelbrot.testing;

import edu.csc1061.mandelbrot.Complex;

// % java Complex
// a = 5.0 + 6.0i
// b = -3.0 + 4.0i
// Re(a) = 5.0
// Im(a) = 6.0
// b + a = 2.0 + 10.0i
// a - b = 8.0 + 2.0i
// a//b = -39.0 + 2.0i
// b//a = -39.0 + 2.0i
// a / b = 0.36 - 1.52i
// (a / b) * b = 5.0 + 6.0i
// conj(a) = 5.0 - 6.0i
// |a| = 7.810249675906654
// tan(a) = -6.685231390246571E-6 + 1.0000103108981198i

public class ComplexTest {

    // sample client for testing
    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("Re(a)        = " + a.getRealNumber());
        System.out.println("Im(a)        = " + a.getImaginaryNumber());
        System.out.println("b + a        = " + b.plus(a));
        System.out.println("a - b        = " + a.minus(b));
        System.out.println("a * b        = " + a.times(b));
        System.out.println("b * a        = " + b.times(a));
        System.out.println("a / b        = " + a.divides(b));
        System.out.println("(a / b) * b  = " + a.divides(b).times(b));
        System.out.println("conj(a)      = " + a.conjugate());
        System.out.println("|a|          = " + a.abs());
        System.out.println("tan(a)       = " + a.tan());
    }

}
