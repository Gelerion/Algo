package com.denis.shuvalov.other.functor.example;

/**
 * A functor is a typed data structure that encapsulates some value(s)
 */
public interface SimpleFunctor<T> {

    /**
     * The only operation that functor provides is map() that takes a function f.
     * This function receives whatever is inside a box, transforms it and wraps
     * the result as-is into a second functor. Please read that carefully.
     * Functor<T> is always an immutable container, thus map never mutates the
     * original object it was executed on.
     */
    <R> SimpleFunctor<R> map(MyFunction<T, R> function);
}
