package com.denis.shuvalov.other.jbreak.functional_style.refactoring;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Curry {
    static <P1, P2, R> Function<P1, Function<P2, R>> curry(BiFunction<P1, P2, R> biFunction) {
        return p1 -> p2 -> biFunction.apply(p1, p2);
    }

}
