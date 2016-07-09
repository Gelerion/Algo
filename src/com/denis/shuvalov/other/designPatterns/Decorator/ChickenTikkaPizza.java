package com.denis.shuvalov.other.designPatterns.Decorator;

public class ChickenTikkaPizza extends PizzaDecorator {

    protected ChickenTikkaPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with chicken topping";
    }
}
