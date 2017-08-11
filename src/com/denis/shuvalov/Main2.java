package com.denis.shuvalov;

public class Main2 {

    public static void main(String[] args) {
        int[] a = { 2,-2, 3, 0, 4, -7 };
        int solution = solution(a);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] A) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int current = A[i];

            if(current == 0) {
                System.out.println("(" + i + "," +  i + ")");
                result++;
                continue;
            }

            int currSum = 0;

            for (int j = (i + 1); j < A.length; j++) {
                if(j == (i + 1)) {
                    currSum = current + A[j];
                } else {
                    currSum += A[j];
                }

                if(currSum == 0) {
                    System.out.println("(" + i + "," +  j + ")");
                    result++;
                }
            }

        }

        return result;
    }
}
