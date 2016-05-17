package com.denis.shuvalov.algo.recursion.exercises;

import java.util.*;

/**
 * Write a recursive method that will output all the subsets of a set of n elements
 * (without repeating any subsets).
 */
public class Subsets {
    public static void main(String[] args) {
//        int[] data = {1, 2, 3};
//        int[] two = {4, 5, 6};
//        System.out.println(Arrays.toString(merge(data, two)));

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
//        System.out.println(powerSet(set));
//        System.out.println(customSubSet(set));

        System.out.println("\n" + createSubsetUsingTree("abc"));

//        ArrayList<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        System.out.println(bitSubsets(list));
    }

    static void solve(int[] data) {
//        doSolve(0, 0, data);
    }

    private static void doSolve(int[] one, int[] two) {
        if (two.length <= 1) System.out.println(Arrays.toString(merge(one, two)));
        else {
            for (int i = 0; i < two.length; i++) {
                int x = two[i]; //take 1 current elem
                doSolve(new int[]{x}, two);
            }
        }

    }

    private static int[] merge(int[] one, int[] two) {
        int[] res = new int[one.length + two.length];
        System.arraycopy(one, 0, res, 0, one.length);
        System.arraycopy(two, 0, res, one.length, two.length);
        return res;
    }

    static void puzzleSolve(int count, int[] sequence, int[] data) {
        for (int e : data) {
            sequence[sequence.length - 1] = e;
        }
    }

    /**
     * http://javabypatel.blogspot.co.il/2015/10/all-subsets-of-set-powerset.html
     * <p>
     * I will give you an example to explain how the algorithm works for the powerset of {1, 2, 3}:
     * <p>
     * - Remove {1}, and execute powerset for {2, 3};
     * <p>
     * - Remove {2}, and execute powerset for {3};
     * <p>
     * - Remove {3}, and execute powerset for {};
     * <p>
     * - Powerset of {} is {{}};
     * <p>
     * - Powerset of {3} is 3 combined with {{}} = { {}, {3} };
     * <p>
     * - Powerset of {2, 3} is {2} combined with { {}, {3} } = { {}, {3}, {2}, {2, 3} };
     * <p>
     * - Powerset of {1, 2, 3} is {1} combined with { {}, {3}, {2}, {2, 3} } = { {}, {3}, {2}, {2, 3}, {1}, {3, 1}, {2, 1}, {2, 3, 1} }.
     */
    static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }

        ArrayList<Integer> list = new ArrayList<>(originalSet);
        Integer head = list.get(0);
        HashSet<Integer> rest = new HashSet<>(list.subList(1, list.size()));

        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }

        return sets;
    }

    /**
     * Subsets of set using Bit Manipulation
     * http://javabypatel.blogspot.co.il/2015/10/all-subsets-of-set-powerset.html
     */
    static <T> Set<Set<T>> bitSubsets(List<T> list) {
        Set<Set<T>> result = new HashSet<>();

//        For example, if we have S =[a, b, c],length of set here is 3,
//        So,for finding total subsets, we have to shift binary 1, 3 times,
//        1 << 3 = (0001 << 3) = (1000) = 2 ^ 3 = 8 subsets of set S.
        int numOfSubsets = 1 << list.size(); //OR Math.pow(2, list.size())


        for (int i = 0; i < numOfSubsets; i++) {
            Set<T> subSet = new HashSet<>();

            int mask = 1; // we will use this mask to check any bit is set in binary representation of value i.

            for (int k = 0; k < list.size(); k++) {
//                How to identify whether bit at position 1 is set in 5(0101)?
//                Solution:
//                Do a Logical AND of 2 and 5 that is (0010 & 0101).
//                If the result is greater than 0, then bit at position 1 is set
                if ((mask & i) != 0) { // If result is !=0 (or >0) then bit is set.
                    subSet.add(list.get(k)); // include the corresponding element from a given set in a subset.
                }

                mask = mask << 1;
            }

            result.add(subSet);
        }

        return result;
    }


    static <T> Set<Set<T>> customSubSet(Set<T> original) {
        Set<Set<T>> result = new HashSet<>();

        if (original.isEmpty()) {
            System.out.println("empty");
            result.add(new HashSet<>());
            return result;
        }

        ArrayList<T> list = new ArrayList<>(original);
        T head = list.get(0);
        System.out.println("head = " + head);
        Set<T> rest = new HashSet<>(list.subList(1, list.size()));
        System.out.println("rest = " + rest);
        System.out.println("----------------");
        for (Set<T> set : customSubSet(rest)) {
            System.out.println("----------------");
            System.out.println("set = " + set);
            HashSet<T> newSet = new HashSet<>();
            newSet.add(head);
            System.out.println("head = " + head);
            newSet.addAll(set);
            System.out.println("newSet = " + newSet);
            result.add(newSet);
            result.add(set);
            System.out.println("iteration result: " + result);
            System.out.println("end iteration");
        }
        System.out.println("End loop");

        System.out.println("result = " + result);
        return result;
    }

    static List<String> createSubsetUsingTree(String str) {
        List<String> result = new ArrayList<>(); // take set if you want unique results.
        result.add("[]");

        if (str != null && str.length() > 0) {

            for (int i = 0; i < str.length(); i++) {
                //Working on str.charAt(i);
                //Store the result of subset of str.charAt(i) in tempList.
                List<String> tempList = new ArrayList<>();

                for (String val : result) {
                    // If val is [], it means str.charAt(i) is not included, So include it in result.
                    if (val.equals("[]")) {
                        tempList.add("[" + str.charAt(i) + "]");
                    } else {
                        //For each item, there will be 2 subset, one including it and one without including it.
                        //If val is not [], it means it already contain some subset without str.charAt(i), So just include it.
                        tempList.add("[" + val.substring(1, val.length() - 1) + ", " + str.charAt(i) + "]");
                    }
                }

                //Add all subsets present in tempList to final result.
                result.addAll(tempList);
            }
        }

        return result;
    }
}
