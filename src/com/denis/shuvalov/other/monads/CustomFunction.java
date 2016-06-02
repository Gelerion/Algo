package com.denis.shuvalov.other.monads;


@FunctionalInterface
public interface CustomFunction<T, R> {

    R apply(T t);
}
