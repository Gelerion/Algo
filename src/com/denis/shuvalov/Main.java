package com.denis.shuvalov;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = { 0, 3, 3, 7, 5, 3, 11, 1 };
        int i = smallestDistance(a);
        System.out.println("i = " + i);
    }

    static int parse(int n) {
        int num = n;
        PriorityQueue<Integer> ints = new PriorityQueue<>(10, Collections.reverseOrder());

        while (num != 0) {
            int last = num % 10;
            ints.add(last);
            num = num / 10;
        }

        int result = 0;
        while (!ints.isEmpty()) {
            if (result == 0) {
                result = ints.poll();
            }
            else {
                result = (result * 10) + ints.poll();
            }

        }

        return result;
    }

    static int smallestDistance(int[] a) {
        TreeSet<Integer> ints = new TreeSet<>();
        for (int value : a) {
            ints.add(value);
        }

        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int current = a[i];

            for (int j = (i + 1); j < a.length; j++) {
                int possiblePair = a[j];
                addIfStrictlyDecreasing(ints, pairs, i, current, j, possiblePair);
                addIfStrictlyIncreasing(ints, pairs, i, current, j, possiblePair);
            }
        }

        int minDistance = 0;
        for (Pair pair : pairs) {
            int currentDistance = Math.abs(a[pair.i1] - a[pair.i2]);
            if (minDistance > currentDistance) {
                minDistance = currentDistance;
            }

        }

        return minDistance;
    }

    private static void addIfStrictlyDecreasing(TreeSet<Integer> ints, ArrayList<Pair> pairs,
                                                int i, int current, int j, int possiblePair) {
        if (Integer.compare(current, possiblePair) < 1) {
            Integer lower = ints.lower(possiblePair);
            if(lower != null && current >= lower) {
                Pair pair = new Pair();
                pair.i1 = i;
                pair.i2 = j;
                pairs.add(pair);
            }
        }
    }

    private static void addIfStrictlyIncreasing(TreeSet<Integer> ints, ArrayList<Pair> pairs,
                                                int i, int current, int j, int possiblePair) {
        if (Integer.compare(current, possiblePair) > 0) {
            Integer lower = ints.lower(current);
            if(lower != null && possiblePair >= lower) {
                Pair pair = new Pair();
                pair.i1 = i;
                pair.i2 = j;
                pairs.add(pair);
            }
        }
    }

    static class Pair {
        int i1;
        int i2;

        @Override
        public String toString() {
            return "(" + i1 + "," +  i2 + ")";
        }
    }

}
