package com.denis.shuvalov.other.designPatterns.Decorator;

public class BasicMain {
    public static void main(String[] args) {
        Pizza  pizza         = new ChickenTikkaPizza(new BasicPizza());
        String finishedPizza = pizza.bakePizza();   //Basic Pizza with chicken topping

        pizza = new ChickenTikkaPizza(new ProsciuttoPizza(new BasicPizza()));
        finishedPizza = pizza.bakePizza();  //Basic Pizza with prosciutto with chicken topping
    }
}
