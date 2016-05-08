package com.denis.shuvalov.algo.recursion.book.samples.sample.linear;

//linear recursion
public class PowerFunction {
    //recursive call to this version of power(x,n) runs in O(n) time
    static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

//    there is a much faster way to compute the power function using an
//    alternative definition that employs a squaring technique

    /**
     * power(x, n) =>
     * [ 1                      if n = 0
     * [ power(x, n/2)^2 * x    if n > 0 is odd  (1, 3, 5, 7...)
     * [ power(x, n/2)^2        if n > 0 is even (0, 2, 4, 6...)
     * <p>
     * example:
     * 2^13 = (2^6 * 2^6) * 2;
     */
    static double employsSquaringPower(double x, int n) {
        if (n == 0) return 1;
        else {
            double partial = employsSquaringPower(x, n / 2);
            double result = partial * partial;
            if (n % 2 == 1)
                result *= x;
            return result;
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(power(2, 13));
        long first = System.nanoTime() - start;
        System.out.println("Time took: " + first);

        start = System.nanoTime();
        System.out.println(employsSquaringPower(2, 13));
        long second = System.nanoTime() - start;
        System.out.println("Time took: " + second);

        System.out.println("Difference: " + (first - second));

    }
}
