package com.denis.shuvalov.algo.recursion.book.samples.anagrams;

/**
 * Перестановкой называется расположение объектов в определенном
 * порядке. Предположим, требуется составить полный список анаграмм заданного
 * слова, то есть всех возможных перестановок букв (независимо от того, являются
 * они допустимыми словами или нет). Например, для слова cat программа должна
 * вывести следующий список анаграмм:
 * cat
 * cta
 * atc
 * act
 * tca
 * tac
 * количество вариантов равно факториалу количества букв
 */
public class Anagrams {

    static int c = 0;
    static int level;

    public static void main(String[] args) {
        doAnagram("", "cats");
        System.out.println("Total Number of Anagrams = " + c);
    }

    static void doAnagram(String s1, String s2) {
        if (s2.length() <= 1) {
            c++;
            System.out.println(s1 + s2);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                System.out.println("s2: " + s2);
                String x = s2.substring(i, i + 1);
                String y = s2.substring(0, i);
                String z = s2.substring(i + 1);
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("doAnagram: (" + s1 + x + " , " + y + z + ") iter: " + i);
                doAnagram(s1 + x, y + z);
            }
        }

    }

    //TODO to be implemented
    static void loopAnagram(String word) {
        if (word.isEmpty()) return;

        int counter = 1;
        for (int i = 0; i < word.length(); i++) {
            char currentFirst = word.charAt(i);
            String tmp = word.substring(0, i) + word.substring(i + 1);
            if (counter % 10 == 0) System.out.println();
            System.out.print(counter++ + ":" + currentFirst + tmp + "\t");

            for (int j = 0; j < tmp.length(); j++) {
                tmp = tmp.substring(1) + tmp.substring(0, 1);
                if (counter % 10 == 0) System.out.println();
                System.out.print(counter++ + ":" + currentFirst + tmp + "\t");
            }
        }
    }
}
