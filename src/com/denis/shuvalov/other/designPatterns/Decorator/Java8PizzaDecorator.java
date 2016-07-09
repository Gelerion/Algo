package com.denis.shuvalov.other.designPatterns.Decorator;

import java.util.function.Function;
import java.util.stream.Stream;

class Java8PizzaDecorator {
    private final Function<Pizza, Pizza> toppings;

    private Java8PizzaDecorator(Function<Pizza, Pizza>... desiredToppings) {
        this.toppings = Stream.of(desiredToppings).reduce(Function.identity(), Function::andThen);
    }

    static String bakePizza(Pizza pizza, Function<Pizza, Pizza>... desiredToppings) {
        return new Java8PizzaDecorator(desiredToppings).bakePizza(pizza);
    }

    private String bakePizza(Pizza pizza) {
        return this.toppings.apply(pizza).bakePizza();
    }
}
