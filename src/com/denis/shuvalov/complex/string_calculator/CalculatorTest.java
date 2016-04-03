package com.denis.shuvalov.complex.string_calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        StackBasedCalculator calculator = new StackBasedCalculator();

        calculator.infixToPostfix("14 + 7 - 3").display().evaluate();

    }
}
