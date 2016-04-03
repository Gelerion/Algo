package com.denis.shuvalov.algo.adt.stack.list_based;

public class TestListBasedStack {
    public static void main(String[] args) {
        ListBasedStack stack = new ListBasedStack();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
