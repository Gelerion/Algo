package com.denis.shuvalov.algo.trees.binary.exercises.letter.tree;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Напишите программную реализацию кодирования и декодирования Хафф-
 * мана. Программа должна делать следующее:
 * - Получать текстовое сообщение — возможно, состоящее из нескольких строк.
 * - Создавать дерево Хаффмана для этого сообщения.
 * - Создавать кодовую таблицу.
 * - Кодировать сообщение в двоичную форму.
 * - Декодировать сообщение из двоичной формы обратно в текстовую.
 * Для коротких сообщений программа должна выводить построенное дерево
 * Хаффмана. Вероятно, в работе над проектом вам помогут описания из п. 8.1, 8.2
 * и 8.3. Для хранения последовательностей двоичных нулей и единиц можно вос-
 * пользоваться переменными String. Не используйте поразрядные операции с битами
 * без необходимости.
 */
public class HuffmanDecoder {
    /**
     * Чтобы упростить, будем считать, что
     * вместо кода ASCII наш компьютер использует упрощенный алфавит из 28 символов
     * верхнего регистра. Буква A обозначается кодом 0, B — 1 и так далее до
     * буквы Z, которая обозначается кодом 25. Пробелу ставится в соответствие код 26,
     * а символу
     * новой строки — код 27. (Конечно, это не код со сжатием, а всего лишь
     * упрощение кода ASCII — обычного способа хранения символьной информации
     * в компьютере.)
     */
    private int[] coding = new int[28];

    public static void main(String[] args) {
        HuffmanDecoder decoder = new HuffmanDecoder();
//        decoder.decode("SUSIE SAYS IT IS EASY\n");
        decoder.decode("DENNIS SHUVALOV\n");

    }

    void decode(String sentence) {
        HuffmanTree tree = createTree(sentence);
        tree.traverse();
    }

    /**
     * 1. Создать объект Node (см. программу tree.java) для каждого символа, исполь-
     * зуемого в сообщении. В сообщении из нашего примера будет 9 узлов. Каждый
     * узел состоит из двух элементов данных: символа и частоты этого символа в со-
     * общении.
     * 2. Создать объект дерева для каждого из этих узлов. Узел становится корнем
     * дерева.
     * 3. Вставить эти деревья в приоритетную очередь (см. главу 4). Деревья упорядо-
     * чиваются по частоте, при этом наименьшая частота обладает наибольшим при-
     * оритетом. Таким образом, при извлечении всегда выбирается дерево с наименее
     * часто используемым символом.
     * Далее происходит следующее:
     * - 1. Извлечь два дерева из приоритетной очереди и сделать их потомками нового
     * узла. Частота нового узла является суммой частот потомков; поле символа
     * может остаться пустым.
     * - 2. Вставить новое дерево из трех узлов обратно в приоритетную очередь.
     * - 3. Продолжить выполнение шагов 1 и 2. Деревья постепенно увеличиваются, а их
     * количество постепенно сокращается. Когда в очереди останется только одно
     * дерево, оно представляет собой дерево Хаффмана. Работа алгоритма на этом
     * завершается.
     */
    private HuffmanTree createTree(String sentence) {
        DynamicArray table = new DynamicArray();

        char[] chars = sentence.toCharArray();

        char current;
        int frequency;

        for (int i = 0; i < chars.length; i++) {
            current = chars[i];

            if (!table.isAlreadyProcessed(current)) {
                frequency = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (current == chars[j]) frequency++;
                }
                table.add(new CharFrequency().aChar(current).frequency(frequency));
            }
        }

//        System.out.println("table = " + table);

        PriorityQueue pq = new PriorityQueue();
        HuffmanTree[] forest = new HuffmanTree[table.size + 1];
        for (int i = 0; i < forest.length; i++) {
            forest[i] = new HuffmanTree(new HuffmanTree.HuffmanNode()
                    .setKey(table.array[i].frequency)
                    .setValue(table.array[i]));
            pq.insert(forest[i]);
        }

        System.out.println("pq = " + pq);

        while (pq.size >= 2) {
            HuffmanTree first = pq.remove();
            HuffmanTree second = pq.remove();
            HuffmanTree tree = new HuffmanTree(
                    new HuffmanTree.HuffmanNode()
                            .setKey(first.root.key + second.root.key)
                            .setLeft(first.root)
                            .setRigth(second.root)
            );
            pq.insert(tree);
        }

        return pq.remove();
    }

    private static class HuffmanTree {
        private HuffmanNode root;

        HuffmanTree(HuffmanNode node) {
            this.root = node;
        }

        void traverse() {
            inOrder(root, "");
        }

        void inOrder(HuffmanNode node, String code) {
            if (node == null) return;

            inOrder(node.left, code + "0");

            if (node.value != null) {
                char cur = node.value.aChar;
                if ('\n' == cur) System.out.println("Code: " + code + ", value: " + "CRLF");
                else if (' ' == cur) System.out.println("Code: " + code + ", value: " + "WS");
                else System.out.println("Code: " + code + ", value: " + node.value.aChar);
            }

            inOrder(node.rigth, code + "1");
        }

        private static class HuffmanNode {
            private int key;
            private CharFrequency value;
            private HuffmanNode left;
            private HuffmanNode rigth;

            public HuffmanNode setKey(int key) {
                this.key = key;
                return this;
            }

            public HuffmanNode setValue(CharFrequency value) {
                this.value = value;
                return this;
            }

            public HuffmanNode setLeft(HuffmanNode left) {
                this.left = left;
                return this;
            }

            public HuffmanNode setRigth(HuffmanNode rigth) {
                this.rigth = rigth;
                return this;
            }

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("HuffmanNode{");
                sb.append("key=").append(key);
                sb.append(", value=").append(value);
                sb.append('}');
                return sb.toString();
            }
        }
    }

    private static class PriorityQueue {
        QueueNode head;
        int size = 0;

        void insert(HuffmanTree elem) {
            QueueNode newNode = new QueueNode(elem);
            if (size == 0) {
                head = newNode;
                size++;
                return;
            }

            QueueNode current = head;

            while (true) {
                //if equals
                int cmpr = Integer.compare(current.elem.root.key, newNode.elem.root.key);
                if (cmpr > 0 || cmpr == 0) {
                    if (current == head) {
                        head = newNode;
                        head.next = current;
                        current.previous = head;
                        break;
                    } else {
                        current.previous.next = newNode;
                        newNode.next = current;
                        newNode.previous = current.previous;
                        current.previous = newNode;
                        break;
                    }
                }

                if (current.next == null) {
                    current.next = newNode;
                    newNode.previous = current;
                    break;
                }
                current = current.next;
            }

            size++;
        }

        HuffmanTree remove() {
            if (size == 0) return null;
            else {
                HuffmanTree res = head.elem;
                head = head.next;
                size--;
                return res;
            }
        }

        @Override
        public String toString() {
            QueueNode cur = head;
            StringJoiner joiner = new StringJoiner(" -> ");
            for (int i = 0; i < size; i++) {
                if (cur.elem.root.value == null) joiner.add(cur.elem.root.key + ":tree");
                else if ('\n' == cur.elem.root.value.aChar) joiner.add(cur.elem.root.key + ":CRLF");
                else if (' ' == cur.elem.root.value.aChar) joiner.add(cur.elem.root.key + ":WS");
                else joiner.add(cur.elem.root.key + ":" + cur.elem.root.value.aChar);
                cur = cur.next;
            }
            return joiner.toString();
        }

        private static class QueueNode {
            HuffmanTree elem;
            QueueNode next;
            QueueNode previous;

            public QueueNode(HuffmanTree elem) {
                this.elem = elem;
            }

            public QueueNode(QueueNode previous, HuffmanTree elem, QueueNode next) {
                this.elem = elem;
                this.next = next;
                this.previous = previous;
            }

            public QueueNode setElem(HuffmanTree elem) {
                this.elem = elem;
                return this;
            }

            public QueueNode setNext(QueueNode next) {
                this.next = next;
                return this;
            }

            public QueueNode setPrevious(QueueNode previous) {
                this.previous = previous;
                return this;
            }

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("QueueNode{");
                sb.append("elem=").append(elem.root);
                sb.append('}');
                return sb.toString();
            }
        }
    }

    private static class CharFrequency {
        private char aChar;
        private int frequency;

        public CharFrequency aChar(char aChar) {
            this.aChar = aChar;
            return this;
        }

        public CharFrequency frequency(int frequency) {
            this.frequency = frequency;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("CharFrequency{");
            sb.append("aChar=").append(aChar);
            sb.append(", frequency=").append(frequency);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class DynamicArray {
        private CharFrequency[] array;
        private int capacity;
        private int size;


        public DynamicArray() {
            this.capacity = 16;
            this.array = new CharFrequency[capacity];
            this.size = -1;
        }

        void add(CharFrequency elem) {
            if (size == capacity - 1) grow();
            array[++size] = elem;
        }

        CharFrequency get() {
            if (size == -1) return null;
            return array[size--];
        }


        private void grow() {
            capacity = (int) (capacity * 1.6);
            array = Arrays.copyOf(array, capacity);
        }


        public boolean isAlreadyProcessed(char aChar) {
            for (int i = 0; i <= size; i++) {
                if (array[i].aChar == aChar) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(", ");
            for (int i = 0; i <= size; i++) {
                if (array[i].aChar == ' ') joiner.add("WS:" + array[i].frequency);
                else if (array[i].aChar == '\n') joiner.add("CRLF:" + array[i].frequency);
                else joiner.add(array[i].aChar + ":" + array[i].frequency);
            }
            return joiner.toString();
        }
    }
}
