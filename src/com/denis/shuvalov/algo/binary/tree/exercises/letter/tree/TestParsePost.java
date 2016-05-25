package com.denis.shuvalov.algo.binary.tree.exercises.letter.tree;

import com.denis.shuvalov.algo.binary.tree.exercises.letter.tree.LetterTree.LetterNode;
import com.denis.shuvalov.algo.binary.tree.exercises.letter.tree.LetterTree.Printer;

import java.util.Arrays;

/**
 * Напишите программу, которая преобразует постфиксное выражение в дере-
 * во, изображенное на рис. 8.11 этой главы. Вам придется внести изменения в класс
 * Tree из программы tree.java (см. листинг 8.1) и класс ParsePost из программы
 * postfix.java (см. листинг 4.8) главы 4. Более подробная информация приведена
 * в комментариях к рис. 8.11.
 * После того, как дерево будет сгенерировано, обход дерева позволит получить
 * префиксный, инфиксный и постфиксный эквиваленты алгебраического выра-
 * жения. В инфиксной версии потребуются круглые скобки для предотвращения
 * неоднозначности генерируемых выражений. В методе inOrder() перед первым
 * рекурсивным вызовом выводится открывающая круглая скобка, а после второго —
 * закрывающая.
 * <p>
 * ABC+*
 * infix = C + D * (E / B) + A"
 * postfix = CDEB/*+A+
 * <p>
 * а=в+с - выражение
 * a,b,c - операнды
 * "+" - операция
 */
public class TestParsePost {

    public static void main(String[] args) {
        TreeCalculator calculator = new TreeCalculator();

        calculator.evaluatePostfix("ABC+*");
        calculator.evaluatePostfix("CDEB/*+A+");
    }

    private static class TreeCalculator {

        /**
         * 1. Создать дерево с единственным узлом, содержащим операнд.
         * 2. Занести дерево в стек.
         * Действия при обнаружении оператора:
         * 1. Извлечь из стека два дерева операндов B и C.
         * 2. Создать новое дерево A, корнем которого является оператор.
         * 3. Присоединить B в качестве левого потомка A.
         * 4. Присоединить C в качестве левого потомка A.
         * 5. Занести полученное дерево обратно в стек.
         * Когда обработка постфиксной строки будет
         */
        void evaluatePostfix(String expression) {
            PostStack stack = new PostStack();
            char[] chars = expression.toCharArray();

            for (char aChar : chars) {
                if (isOperator(aChar)) {
                    revalidate(aChar, stack);
                } else {
                    stack.push(new ParseTree().add(aChar));
                }
            }

            ParseTree tree = stack.pop();
            tree.display();
            System.out.print("Prefix: ");
            tree.preOrder();
            System.out.println();
            System.out.print("Postfix: ");
            tree.postOrder();
            System.out.println();

        }


        private void revalidate(char aChar, PostStack stack) {
            ParseTree firstOperand = stack.pop();
            ParseTree secondOperand = stack.pop();
            ParseTree operator = new ParseTree().add(aChar);

            operator.addRightNode(firstOperand.root);
            operator.addLeftNode(secondOperand.root);

            stack.push(operator);
        }

        private boolean isOperator(char aChar) {
            return aChar == '*' || aChar == '/' || aChar == '+' || aChar == '-';
        }
    }

    private static class ParseTree {
        private LetterNode root;

        ParseTree add(char value) {
            if (root == null) root = new LetterNode().setValue(value);
            return this;
        }

        ParseTree addLeftNode(LetterNode node) {
            root.setLeft(node);
            return this;
        }

        ParseTree addRightNode(LetterNode node) {
            root.setRight(node);
            return this;
        }

        void display() {
            Printer.printNode(root);
        }

        void preOrder() {
            walkPre(root);
        }

        void postOrder() {
            walkPost(root);
        }

        private void walkPost(LetterNode node) {
            if (node == null) return;

            walkPost(node.getLeft());
            walkPost(node.getRight());
            System.out.print(node.getValue());
        }

        private void walkPre(LetterNode node) {
            if (node == null) return;

            System.out.print(node.getValue());
            walkPre(node.getLeft());
            walkPre(node.getRight());
        }
    }

    private static class PostStack {
        int size = -1;
        int capacity;
        private ParseTree[] forest;

        public PostStack() {
            this.forest = new ParseTree[2];
            capacity = forest.length;
        }

        void push(ParseTree value) {
            if (size == capacity - 1) grow();
            forest[++size] = value;
        }

        ParseTree pop() {
            if (size == -1) throw new IllegalStateException("No more elements");
            return forest[size--];
        }

        private void grow() {
            capacity = (int) (capacity * 1.6);
            forest = Arrays.copyOf(forest, capacity);
        }
    }
}
