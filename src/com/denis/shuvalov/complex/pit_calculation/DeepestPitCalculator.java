package com.denis.shuvalov.complex.pit_calculation;


import java.util.LinkedHashSet;
import java.util.Set;

/**
 * pit is triplet of integers (P,Q,R) such that
 * - 0 =< P < Q < R < N
 * - sequence [A[P], A[P + 1],...,A[Q]] is strictly decreasing
 * i.e. A[P] > A[P + 1] > ... > A[Q]
 * - sequence [A[Q], A[Q + 1],...,A[R]] is strictly increasing
 * i.e. A[Q] < A[Q + 1] < ... < A[R]
 * <p>
 * The depth of a pit (P,Q,R) is the number {A[P] - A[Q], A[R] - A[Q]}
 */
public class DeepestPitCalculator {
    public static void main(String[] args) {

        //triplet (2,3,4) is one of pits, because [A[2], A[3]]
        //is strictly decreasing (3 > -2) and sequence [A[3], A[4]]
        //is strictly increasing (-2 < 0) Its depth = 2
        //(2,3,5) and (5,7,8) also pits
        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;
        array[3] = -2;
        array[4] = 0;
        array[5] = 1;
        array[6] = 0;
        array[7] = -3;
        array[8] = 2;
        array[9] = 3;

        int[] testArr = {3, 2, 1, 1}; //-1

        System.out.println(calculateDeepestPit(array));
        System.out.println("===============================");
        System.out.println(fun1(array));

    }

    static int calculateDeepestPit(int[] array) {
        Set<Pit> pits = new LinkedHashSet<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j] && strictlyDecreasing(array, i, j)) {
                    boolean first = true;
                    //possible pit
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[j] < array[k] && first) {
                            first = false;
                            pits.add(new Pit(i, j, k));
                        }
                        else if (array[j] < array[k] && strictlyIncreasing(array, j, k)) {
                            pits.add(new Pit(i, j, k));
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }
        }

        for (Pit pit : pits) {
            System.out.println("pit " + pit +
                                       " values [" + array[pit.P] + " > " + array[pit.Q] + " < " + array[pit.R]
                                       + "] depth: " + Math.min(array[pit.P] - array[pit.Q], array[pit.R] - array[pit
                    .Q]));
        }

        return pits.stream().mapToInt(pit -> Math.min(array[pit.P] - array[pit.Q], array[pit.R] - array[pit.Q]))
                   .max().orElseGet(() -> -1);
    }

    private static boolean strictlyIncreasing(int[] array, int i, int j) {
        for (int k = i; k != j; k++) {
            if (array[k] > array[k + 1]) return false;
        }
        return true;
    }

    private static boolean strictlyDecreasing(int[] array, int i, int j) {
        if (i == (j - 1)) return true;
        for (int k = i; k != j; k++) {
            if (array[k] < array[k + 1]) return false;
        }
        return true;
    }

    //O(N)
    private static int fun1(int[] a) {
        int     P[]    = new int[a.length];
        int     Q[]    = new int[a.length];
        int     R[]    = new int[a.length];
        int     p      = 0, q = 0, r = 0;
        int     tmp    = 0;
        int     tmp2[] = new int[a.length];
        boolean flag1  = false, flag2 = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                if (flag1 == true)
                    continue;
                //
                //              System.out.println("CHK....");
                flag1 = true;
                tmp2[p] = i;
                P[p++] = a[i];
            }
            else
                flag1 = false;
        }
        for (int i = tmp2[0]; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                if (flag1 == true)
                    continue;
                //
                //              System.out.println("CHK....");
                flag1 = true;
                tmp2[q] = i;
                Q[q++] = a[i];
            }
            else
                flag1 = false;
        }
        int tmp3 = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            tmp2[tmp3++] = a[i];
            //
            //      System.out.print(a[i] + " ");
        }
        flag1 = false;
        for (int i = 0; i < tmp2.length - 1; i++) {
            if (tmp2[i] > tmp2[i + 1]) {
                if (flag1 == true)
                    continue;
                //
                //          System.out.println("CHK....");
                flag1 = true;
                // tmp2[p]= i;
                R[r++] = tmp2[i];
            }
            else
                flag1 = false;
        }
        int finalLength = q;
        System.out.println("P---->");
        for (int i = 0; i < finalLength; i++) {
            System.out.print(P[i] + " ");
        }
        System.out.println("\nQ---->");
        for (int i = 0; i < finalLength; i++) {
            System.out.print(Q[i] + " ");
        }
        System.out.println("\nR---->");
        for (int i = finalLength - 1; i >= 0; i--) {
            System.out.print(R[i] + " ");
        }
        int depth[] = new int[a.length];
        int d3      = 0;
        for (int i = 0; i < finalLength; i++) {
            int p1 = P[i] - Q[i];
            int p2 = R[finalLength - 1 - i] - Q[i];

            depth[d3++] = p1 > p2 ? p2 : p1;
        }
        int maxDepth = depth[0];

        for (int i = 1; i < d3; i++) {
            if (maxDepth < depth[i])
                maxDepth = depth[i];
        }
        return maxDepth;
    }

    private static class Pit {
        int P;
        int Q;
        int R;

        public Pit(int p, int q, int r) {
            P = p;
            Q = q;
            R = r;
        }

        @Override
        public String toString() {
            return "(" + P + "," + Q + "," + R + ")";
        }
    }
}
