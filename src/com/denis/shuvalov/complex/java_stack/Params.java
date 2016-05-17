package com.denis.shuvalov.complex.java_stack;

/**
 * Класс Params инкапсулирует адрес возврата и аргумент метода
 */
class Params {
    int methodArg;
    int returnAddress;

    public Params(int methodArg, int returnAddress) {
        this.methodArg = methodArg;
        this.returnAddress = returnAddress;
    }
}
