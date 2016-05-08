package com.denis.shuvalov.algo.recursion.exercises;

public class RecursiveStringToInteger {

    public static void main(String[] args) {
        System.out.println(convert("13538"));
    }

    static int convert(String number) {
        char[] chars = number.toCharArray();
        return convert(chars, 0);

    }

    private static int convert(char[] chars, int index) {
        if (index == (chars.length - 1)) return Character.getNumericValue(chars[chars.length - 1]);
        else
            return Character.getNumericValue(chars[index]) * ((int) Math.pow(10, chars.length - 1 - index)) + convert(chars, ++index);
    }
}
