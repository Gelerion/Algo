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

    public static void main(String[] args) {
        loopAnagram("cats");
    }

    static void doAnagram() {

    }

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
