package com.denis.shuvalov.other.jbreak.generics.recursive;

abstract class RecGeneric<T, S extends RecGeneric<T, S>> {

    abstract S method1();

    abstract S method2();

    //Stream<T> extends BaseStream<T, Stream<T>>
}
