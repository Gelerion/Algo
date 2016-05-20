package com.denis.shuvalov.complex.pit_calculation;

//leader in the array is the value that occurs in
//more than half of the elements
public class LeaderInArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 2;
        array[1] = 2;
        array[2] = 2;
        array[3] = 2;
        array[4] = 2;
        array[5] = 3;
        array[6] = 4;
        array[7] = 4;
        array[8] = 4;
        array[9] = 6;
        //should return -1 because frequency of of value 2 is 5 and its not more than a half of 10

        System.out.println(solution(array));

        array = new int[]{1, 1, 1, 1, 50};
        System.out.println(solution(array));


    }

    static int solution(int[] array) {
        int   n = array.length;
        int[] L = new int[n + 1];
        L[0] = -1;
        for (int i = 0; i < n; i++) {
            L[i + 1] = array[i];
        }

        int count = 0;
        //        int candidate = n / 2;
        float pos       = (float) n / 2;
        int   candidate = L[Math.round(pos)];

        for (int i = 1; i <= n; i++) {
            if (L[i] == candidate) count++;
        }

        if (count > pos) return candidate;
        return -1;
    }
}
