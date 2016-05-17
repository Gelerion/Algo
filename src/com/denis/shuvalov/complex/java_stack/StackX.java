package com.denis.shuvalov.complex.java_stack;

public class StackX {
    int top;
    int maxSize;
    private Params[] stackArray;

    StackX(int capacity) {
        this.maxSize = capacity;
        this.stackArray = new Params[capacity];
        top = -1;
    }

    void push(Params param) {
        this.stackArray[++top] = param;
    }

    Params pop() {
        return this.stackArray[top--];
    }

    Params peek() {
        return this.stackArray[top];
    }
}
