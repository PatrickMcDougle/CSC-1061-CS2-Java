/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch13;

import java.math.BigInteger;
import java.util.Arrays;

public class Ch13Program05 {

    public static void main(String[] args) {
        String[] cities = {"Savannah", "Boston", "Tampa", "Atlanta"};

        Arrays.sort(cities);
        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();

        BigInteger[] hugeNumbers = {BigInteger.valueOf(2_323_231_092_923_992L),
                BigInteger.valueOf(432_232_323_239_292L), BigInteger.valueOf(54_623_239_292L),};

        Arrays.sort(hugeNumbers);
        for (BigInteger number : hugeNumbers) {
            System.out.print(number + " ");
        }
    }
}
