package com.denis.shuvalov.other.functor;

import com.denis.shuvalov.other.functor.example.MyFunction;

public interface Monad<T, M extends Monad<?, ?>> extends Functor<T, M> {

    //public interface Function<T, R>
    //Stream<T> extends BaseStream<T, Stream<T>>
    //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

    M flatMap(MyFunction<T, M> function);

    //public <R> FOptional<R> map(MyFunction<T, R> function)
}

class Example {
    public static void main(String[] args) {
        FOptionalMonad<String> num = FOptionalMonad.of("42");
        FOptionalMonad<?> fOptionalMonad = num.flatMap(num::tryParse);

    }
}
