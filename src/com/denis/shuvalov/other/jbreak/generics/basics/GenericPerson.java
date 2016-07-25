package com.denis.shuvalov.other.jbreak.generics.basics;

import java.util.stream.Stream;

public class GenericPerson<T> {
    public static void main(String[] args) {
        Stream.of(GenericPerson.class.getDeclaredMethods()) //compareTo(java.lang.Object)
              .forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        //Two methods Reflection: isSynthetic()
        Stream.of(CompGenericPerson.class.getDeclaredMethods()) //compareTo(java.lang.Object) - synthetic
              .forEach(System.out::println);                    //compareTo(CompGenericPerson)

    }

    public int compareTo(T o) {
        return 0;
    }

    static class CompGenericPerson implements Comparable<CompGenericPerson> {

        @Override
        public int compareTo(CompGenericPerson o) {
            return 0;
        }
    }

}


