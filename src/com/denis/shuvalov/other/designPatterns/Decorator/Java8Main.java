package com.denis.shuvalov.other.designPatterns.Decorator;

public class Java8Main {
    public static void main(String[] args) {
        String finished = Java8PizzaDecorator.bakePizza(new BasicPizza(), Pizza::withChickenTikka,
                                                        Pizza::withProsciutto);
        System.out.println(finished);
    }
}
