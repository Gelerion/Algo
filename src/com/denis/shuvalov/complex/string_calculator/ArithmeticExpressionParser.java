package com.denis.shuvalov.complex.string_calculator;

import java.util.Stack;

public class ArithmeticExpressionParser {
    private Stack<Character> signs = new Stack<>();
    private Stack<Integer> values = new Stack<>();

    public static void main(String[] args) {
//        System.out.println("A + B - C => " + new ArithmeticExpressionParser().toInfixExpression("A + B - C"));
//        System.out.println("A + B * C => " + new ArithmeticExpressionParser().toInfixExpression("A + B * C"));
//        System.out.println("A × (B + C) => " + new ArithmeticExpressionParser().toInfixExpression("A * (B + C)"));
//        System.out.println("A + B × (C – D) => " + new ArithmeticExpressionParser().toInfixExpression("A + B * (C - D)"));
//        System.out.println("A * (B + C) - D / (E + F) => " + new ArithmeticExpressionParser().toInfixExpression("A * (B + C) - D / (E + F)"));
//        System.out.println("A + B * (C / D) + E => " + new ArithmeticExpressionParser().toInfixExpression("A + B * (C / D) + E"));
//        System.out.println("3 + 5 * (8 / 2) + 1 => " + new ArithmeticExpressionParser().toInfixExpression("3 + 5 * (8 / 2) + 1"));
        ArithmeticExpressionParser parser = new ArithmeticExpressionParser();
        String infixExpression = parser.toInfixExpression("3 + 5 * (8 / 2) + 1");
        System.out.println("infixExpression = " + infixExpression);
        System.out.println("3 + 5 * (8 / 2) + 1 => " + parser.evaluateInfix(infixExpression));
        System.out.println("13 + 25 * (18 / 2) + 15 => " + parser.evaluateInfix(parser.toInfixExpression("13 + 25 * (18 / 2) + 15")));
    }

    private String toInfixExpression(String postFixExpression) {
        postFixExpression = postFixExpression.replaceAll(" ", "");
        char[] chars = postFixExpression.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (!isOperator(aChar)) {
                sb.append(aChar);
            }
            else if (isClosingBracket(aChar)){
                revalidate(sb);
            }
            else if(isOpenBracket(aChar)) {
                signs.push(aChar);
            }
            else {
                push(aChar, sb);
            }
        }

        while (!signs.isEmpty()) {
            sb.append(signs.pop());
        }

        return sb.toString();
    }

    private int evaluateInfix(String infixExpression) {
        char[] chars = infixExpression.toCharArray();

        for (char aChar : chars) {
            if (!isOperator(aChar)) {
                values.push(Character.getNumericValue(aChar));
                continue;
            }

            doEvaluate(aChar);
        }

        return values.pop();
    }

    private void doEvaluate(char aChar) {
        Integer first = values.pop();
        Integer second = values.pop();

        switch (aChar) {
            case '+':
                values.push(second + first);
                break;
            case '-':
                values.push(second - first);
                break;
            case '*':
                values.push(second * first);
                break;
            case '/':
                values.push(second / first);
                break;
        }
    }

    private boolean isOpenBracket(char aChar) {
        return aChar == '(';
    }

    private void push(char aChar, StringBuilder sb) {
        int thisPriority = getPriority(aChar);

        while (!signs.empty()) {
            Character top = signs.pop();

            if (top == '(') {
                signs.push(top);
                break;
            }

            int topPriority = getPriority(top);
            //        -     <       *
            if (topPriority < thisPriority) {
                signs.push(top);
                break;
            }
            else {
                sb.append(top);
            }
        }

        signs.push(aChar);
    }

    private int getPriority(char aChar) {
        switch (aChar) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new UnsupportedOperationException("Could not be determined " + aChar);
        }
    }

    private void revalidate(StringBuilder sb) {
        while (!signs.empty()) {
            Character chx = signs.pop();

            if(chx == '(') break;
            sb.append(chx);
        }

    }

    private boolean isClosingBracket(char aChar) {
        return aChar == ')';
    }

    private boolean isOperator(char aChar) {
        return aChar == '*' || aChar == '/' || aChar == '+' || aChar == '-' || aChar == '(' || aChar == ')';
    }
}