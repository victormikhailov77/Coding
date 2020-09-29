package org.example;

import java.util.Scanner;

public class FizzBuzz {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        boolean isMultiply3 = n % 3 == 0;
        boolean isMultiply5 = n % 5 == 0;
        if (isMultiply3) {
            if (isMultiply5) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else {
            if (isMultiply5) {
                System.out.println("Buzz");
            } else {
                System.out.println(n);
            }
        }

    }

}



