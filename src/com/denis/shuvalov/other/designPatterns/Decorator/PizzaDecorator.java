package com.denis.shuvalov.other.designPatterns.Decorator;

public class PizzaDecorator implements Pizza {

    private final Pizza pizza;

    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza();
    }
}
