package com.denis.shuvalov.other.monads;

public class Trick {
    public static void main(String[] args) {
        CustomFunction<String, Integer> f = Integer::valueOf;

        String prefix = "JFokus: ";

        CustomFunction<String, Integer> f2 = (str) -> {
            System.out.println(prefix + str);
            return str.hashCode();
        };

        f2.apply("Denis!");
    }


    private static class MonadImpl<V> {

        private final V value;

        private MonadImpl(V value) {
            this.value = value;
        }

        public static <V> MonadImpl<V> pure(V value) {
            return new MonadImpl<>(value);
        }

        public <R> MonadImpl<R> bind(CustomFunction<V, Monad<R>> f) {
            return null;
        }
    }
}
