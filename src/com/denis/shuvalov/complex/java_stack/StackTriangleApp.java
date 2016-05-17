package com.denis.shuvalov.complex.java_stack;

public class StackTriangleApp {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) {
        theNumber = 10;

        recTriangle();

        System.out.println("Simulation: " + theAnswer);
        System.out.println("Real: " + triangle(theNumber));
    }

    static int triangle(int n) {
        if (n == 1)
            return 1;
        else
            return (n + triangle(n - 1));
    }

    private static void recTriangle() {
        theStack = new StackX(100);
        codePart = 1;
        while (!step()) ;
    }

    private static boolean step() {
        switch (codePart) {

            case 1: // Исходный вызов
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;

            case 2: // Вход в метод
                theseParams = theStack.peek();

                if (theseParams.methodArg == 1) {
                    theAnswer = 1;
                    codePart = 5;
                } else {
                    codePart = 3;
                }
                break;

            case 3:
                Params newParams = new Params(theseParams.methodArg - 1, 4);
                theStack.push(newParams);
                codePart = 2; // Вход в метод
                break;

            case 4: // Вычисление
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.methodArg;
                codePart = 5;
                break;

            case 5: // Выход из метода
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress; // (4 или 6)
                theStack.pop();
                break;

            case 6: // Точка возврата
                return true;
        }

        return false;
    }
}
