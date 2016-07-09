package com.denis.shuvalov.other.designPatterns.Decorator;

public interface Pizza {
    static Pizza withChickenTikka(Pizza pizza) {
        return () -> pizza.bakePizza() + " with chicken";
    }

    static Pizza withProsciutto(Pizza pizza) {
        return () -> pizza.bakePizza() + " with prosciutto";
    }

    String bakePizza();
}
