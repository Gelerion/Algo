package com.denis.shuvalov.algo.recursion.exercises;

/**
 * Write a short recursive Java method that takes a character string s and outputs its
 * reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'.
 */
public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("pots&pans"));
    }

    static String reverse(String word) {
        char[] characters = word.toCharArray();
        doReverse(0, characters.length - 1, characters);
        return String.valueOf(characters);
    }

    private static void doReverse(int low, int high, char[] characters) {
        if (low > high) return;
        rotate(low, high, characters);
        doReverse(++low, --high, characters);
    }

    private static void rotate(int low, int high, char[] characters) {
        char tmp = characters[low];
        characters[low] = characters[high];
        characters[high] = tmp;
    }
}
