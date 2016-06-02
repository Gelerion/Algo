package com.denis.shuvalov.other.monads;

public interface Monad<V> {

    <V> Monad<V> pure(V value);

    /**
     * Chaining bind (>>=)
     * monad "m a"
     * function "a => mb"
     * return monad "m b"
     */
    <R> Monad<R> bind(CustomFunction<V, Monad<R>> f);
}
