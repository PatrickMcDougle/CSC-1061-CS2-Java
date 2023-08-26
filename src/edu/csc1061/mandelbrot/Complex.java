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

/******************************************************************************
 *
 * Data type for complex numbers.
 *
 * The data type is "immutable" so once you create and initialize a Complex
 * object, you cannot change it. The "final" keyword when declaring realNumber
 * and imaginaryNumber enforces this rule, making it a compile-time error to
 * change the .realNumber or .imaginaryNumber instance variables after they've
 * been initialized.
 *
 ******************************************************************************/

import java.util.Objects;

public class Complex {
    private final double realNumber; // the real part
    private final double imaginaryNumber; // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imaginary) {
        realNumber = real;
        imaginaryNumber = imaginary;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (imaginaryNumber == 0) {
            return realNumber + "";
        }
        if (realNumber == 0) {
            return imaginaryNumber + "i";
        }
        if (imaginaryNumber < 0) {
            return realNumber + " - " + (-imaginaryNumber) + "i";
        }
        return realNumber + " + " + imaginaryNumber + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(realNumber, imaginaryNumber);
    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(imaginaryNumber, realNumber);
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this; // invoking object
        double real = a.realNumber + b.realNumber;
        double imaginary = a.imaginaryNumber + b.imaginaryNumber;
        return new Complex(real, imaginary);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.realNumber - b.realNumber;
        double imaginary = a.imaginaryNumber - b.imaginaryNumber;
        return new Complex(real, imaginary);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.realNumber * b.realNumber - a.imaginaryNumber * b.imaginaryNumber;
        double imaginary = a.realNumber * b.imaginaryNumber + a.imaginaryNumber * b.realNumber;
        return new Complex(real, imaginary);
    }

    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new object whose value is (this * alpha)
    public Complex scale(double alpha) {
        return new Complex(alpha * realNumber, alpha * imaginaryNumber);
    }

    // return a new Complex object whose value is the conjugate of this
    public Complex conjugate() {
        return new Complex(realNumber, -imaginaryNumber);
    }

    // return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = realNumber * realNumber + imaginaryNumber * imaginaryNumber;
        return new Complex(realNumber / scale, -imaginaryNumber / scale);
    }

    // return the real or imaginary part
    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(realNumber) * Math.cos(imaginaryNumber),
                Math.exp(realNumber) * Math.sin(imaginaryNumber));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(realNumber) * Math.cosh(imaginaryNumber),
                Math.cos(realNumber) * Math.sinh(imaginaryNumber));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(realNumber) * Math.cosh(imaginaryNumber),
                -Math.sin(realNumber) * Math.sinh(imaginaryNumber));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }

    public boolean equals(Object x) {
        if (x == null) {
            return false;
        }
        if (this.getClass() != x.getClass()) {
            return false;
        }
        Complex that = (Complex) x;
        return (this.realNumber == that.realNumber)
                && (this.imaginaryNumber == that.imaginaryNumber);
    }

    public int hashCode() {
        return Objects.hash(realNumber, imaginaryNumber);
    }
}
