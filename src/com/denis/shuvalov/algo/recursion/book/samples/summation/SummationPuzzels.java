package com.denis.shuvalov.algo.recursion.book.samples.summation;

import java.util.Arrays;

/**
 * Multiple Recursion
 * <p>
 * pot + pan = bib
 * dog + cat = pig
 * boy+ girl = baby
 * To solve such a puzzle, we need to assign a unique digit (that is, 0,1, . . . ,9) to each
 * letter in the equation, in order to make the equation true.
 */
public class SummationPuzzels {

    //TODO: not finished
    //An integer k, sequence S, and set U
    public static void puzzleSolve(int k, String sequence, String set) {

        char[] chars = set.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            sequence += aChar;
            System.out.println("Sequence: " + sequence);
            set = String.valueOf(Arrays.copyOf(chars, i));

            if (k == 1) {
                System.out.println("TESTING");
            } else {
                puzzleSolve(k - 1, sequence, set);
            }

            sequence = sequence.substring(0, sequence.length() - 1);
            set += aChar;
        }
    }

    static void puzzleSolve(String word) {
        puzzleSolve(word.length(), "", word.toCharArray());
    }

    static void puzzleSolve(int k, String sequence, char[] set) {
        for (int i = 0; i < set.length; i++) {
            sequence += set[i];
            System.out.println("sequence = " + sequence);
            char[] tmp = new char[set.length - i];
            int c = 0;
            for (char aChar : set) {
                if (!(aChar == set[i])) {
                    tmp[c++] = aChar;
                }
            }
            System.out.println("set = " + Arrays.toString(tmp));

            if (k == 1) {
                System.out.println("S = " + sequence);
                System.out.println("if S solves the puzzle then add S to output");
            } else {
                puzzleSolve(k - 1, sequence, tmp);
            }

            sequence = sequence.substring(0, sequence.length());
        }
    }

    static void puzzleSolve2(int k, String sequence, char[] set) {

    }

    public static void main(String[] args) {
        SummationPuzzels.puzzleSolve("abc");
    }
}
