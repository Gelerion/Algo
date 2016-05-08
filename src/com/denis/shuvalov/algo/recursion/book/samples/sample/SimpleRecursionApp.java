package com.denis.shuvalov.algo.recursion.book.samples.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleRecursionApp {
    static int theNumber;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle: " + theAnswer);
        theAnswer = factorial(theNumber);
        System.out.println("Factorial: " + theAnswer);
    }

    //sum of all numbers
    //n-е треугольное число = (n2+n)/2
    //4 + 3 + 2 + 1 дает 10.
    private static int triangle(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return n + triangle(n - 1);
    }

/*    public static int triangle(int n)
    {
        System.out.println("Entering: n=" + n);
        if(n==1)
        {
            System.out.println("Returning 1");
            return 1;
        }
        else
        {
            int temp = n + triangle(n-1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }*/

    //факториал 5 вычисляется по формуле
    //5 × 4 × 3 × 2 × 1 = 120.
    private static int factorial(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
