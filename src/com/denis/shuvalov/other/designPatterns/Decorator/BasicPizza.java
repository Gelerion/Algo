package com.denis.shuvalov.other.designPatterns.Decorator;

public class BasicPizza implements Pizza {
    @Override
    public String bakePizza() {
        return "Basic Pizza";
    }
}
