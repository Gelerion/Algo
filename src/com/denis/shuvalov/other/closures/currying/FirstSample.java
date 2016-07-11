package com.denis.shuvalov.other.closures.currying;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * f(x, y, z) = x * y + z
 * <p>
 * we may apply the arguments 2, 4, 5 at the same time and get:
 * <p>
 * f(3, 4, 5) = 3 * 4 + 5 = 17
 * <p>
 * But we may also apply only 3 and get:
 * <p>
 * f(3, y, z) = g(y, z) = 3 * y + z
 * <p>
 * We have now a new function g, taking only two arguments. We can curry again this function, applying 4 to y:
 * <p>
 * g(4, z) = h(z) = 3 * 4 + z
 */
public class FirstSample {
    private static int b = 3;

    private static Stream<Integer> calculate(Stream<Integer> stream, Integer a) {
        return stream.map(((Function<Integer, Function<Integer, Function<Integer, Integer>>>) x -> y -> t -> x + y * t)
                .apply(b).apply(a));
    }

}
