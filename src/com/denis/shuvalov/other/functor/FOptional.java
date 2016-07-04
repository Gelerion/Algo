package com.denis.shuvalov.other.functor;

import com.denis.shuvalov.other.functor.example.MyFunction;

/**
 * Now it becomes interesting. An FOptional<T> functor may hold a value, but just as well it might be empty.
 * It's a type-safe way of encoding null. There are two ways of constructing FOptional - by supplying a
 * value or creating an empty() instance. In both cases, just like with Identity,FOptional is immutable
 * and we can only interact with the value from inside. What differsFOptional is that the transformation
 * function f may not be applied to any value if it is empty. This means functor may not necessarily encapsulate
 * exactly one value of type T. It can just as well wrap an arbitrary number of values, just like List... functor
 */
class FOptional<T> implements Functor<T, FOptional<?>> {

    private final T valueOrNull;

    FOptional(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    static <R> FOptional<R> of(R value) {
        return new FOptional<>(value);
    }

    static <R> FOptional<R> empty() {
        return new FOptional<>(null);
    }

    @Override
    public <R> FOptional<R> map(MyFunction<T, R> function) {
        if (valueOrNull == null)
            return empty();
        else
            return of(function.apply(valueOrNull));
    }
}
