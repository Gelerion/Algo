package com.denis.shuvalov.algo.adt.stack.array_based.test;


import com.denis.shuvalov.algo.adt.stack.array_based.ArrayStack;

public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
