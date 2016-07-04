package com.denis.shuvalov.other.functor;

import com.denis.shuvalov.other.functor.example.MyFunction;

class FOptionalMonad<T> implements Monad<T, FOptionalMonad<?>> {

    private final T valueOrNull;

    FOptionalMonad(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    static <R> FOptionalMonad<R> of(R value) {
        return new FOptionalMonad<>(value);
    }

    static <R> FOptionalMonad<R> empty() {
        return new FOptionalMonad<>(null);
    }

    @Override
    public <R> FOptionalMonad<R> map(MyFunction<T, R> function) {
        if (valueOrNull == null)
            return empty();
        else
            return of(function.apply(valueOrNull));
    }

    @Override
    public FOptionalMonad<?> flatMap(MyFunction<T, FOptionalMonad<?>> function) {
        return null;
    }

    FOptionalMonad<Integer> tryParse(String s) {
        try {
            return of(Integer.parseInt(s));
        }
        catch (NumberFormatException e) {
            return empty();
        }
    }
}
