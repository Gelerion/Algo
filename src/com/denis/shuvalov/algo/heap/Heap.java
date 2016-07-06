package com.denis.shuvalov.algo.heap;

/**
 * В пирамиде упорядоченный перебор узлов затрудняется тем, что принцип орга-
 * низации пирамиды (условие пирамиды) не так силен, как принцип организации де-
 * рева. Единственное, что можно гарантировать по поводу пирамиды — то, что на каж-
 * дом пути от корня к листу узлы упорядочены по убыванию. Ключи узлов, находящихся
 * слева или справа от заданного узла, на более высоких или
 * низких уровнях (и не принадлежащих тому же пути), могут быть больше или меньше
 * ключа узла. Пути, не имеющие общих узлов, полностью независимы друг от друга.
 * Вследствие слабой упорядоченности пирамиды некоторые операции с ней за-
 * труднены или невозможны. Из-за отсутствия нормальной возможности перебора
 * пирамида не предоставляет удобных средств поиска заданного ключа. Дело в том,
 * что алгоритм поиска не располагает достаточной информацией для принятия реше-
 * ния о том, какого из двух потомков узла следует выбрать для перехода на нижней
 * уровень. Соответственно узел с заданным ключом невозможно удалить (по крайней
 * мере за время O(logN )), потому что его нельзя найти. (Операции можно выполнить
 * последовательным просмотром всех ячеек последовательности, но это может быть
 * сделано только за время O(N ).)
 * <p>
 * -------
 * Тем не менее
 * упорядоченности пирамиды достаточно для быстрого удаления наибольшего узла
 * и быстрой вставки новых узлов. Этих операций достаточно для использования
 * пирамиды в качестве приоритетной очереди.
 */
public class Heap {
    private HeapNode heapArray[];
    private int size;

    /**
     * индекс родителя равен (x – 1) / 2;
     * индекс левого потомка равен 2 * x + 1;
     * индекс правого потомка равен 2 * x + 2.
     */
    Heap(int capacity) {
        this.heapArray = new HeapNode[capacity];
    }

    /**
     * вставляемый узел помещается
     * в первую свободную позицию в конце массива, в результате чего размер массива
     * увеличивается на единицу
     */
    void insert(int key) {
        HeapNode newest = new HeapNode(key);
        heapArray[size] = newest;
        trickleUp(size++);
    }

    private void trickleUp(int index) {
        int parent = parentIndex(index);
        HeapNode bottom = heapArray[index];

        while (parent >= 0 && bottom.getValue() > heapArray[parent].getValue()) {
            heapArray[index] = heapArray[parent]; // Узел перемещается вниз
            index = parent; // index перемещается вверх
            if (parent == 0) break;
            parent = parentIndex(parent); // parent <- его родитель
        }

        heapArray[index] = bottom;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightIndex(int index) {
        return (2 * index) + 2;
    }

    /**
     * Под удалением подразумевается удаление с наибольшим ключом. Этот узел всег-
     * да является корневым, поэтому его удаление выполняется просто.
     */
    HeapNode remove() {
        HeapNode max = heapArray[0];
        //last value is now new top
        heapArray[0] = heapArray[--size];
        trickleDown(0);
        return max;
    }

    public void changePriority(int index, int priority) {
        if (index < 0 || index > size) return;

        HeapNode node = heapArray[index];
        int oldValue = node.getValue();
        node.value = priority;

        if (oldValue > priority)
            trickleDown(index);  // Если узел понижается, выполняется смещение вниз
        else
            trickleUp(index); // Если узел повышается, выполняется смещение вверх
    }

    private void trickleDown(int index) {
        HeapNode top = heapArray[index];
        int currentIndex = index;
        int largerChild;
        //going down
        while (currentIndex < size / 2) { // Пока у узла имеется хотя бы один потомок
            int left = leftIndex(currentIndex);
            int right = rightIndex(currentIndex);

            if (isRightSuccessorExist(right) && isRightSuccessorIsBiggerThanLeft(heapArray[left], heapArray[right])) {
                largerChild = right;
            }
            else {
                largerChild = left;
            }

            if (top.getValue() > heapArray[largerChild].getValue()) break;

            heapArray[currentIndex] = heapArray[largerChild];
            currentIndex = largerChild;
        }

        heapArray[currentIndex] = top;

    }

    private boolean isRightSuccessorIsBiggerThanLeft(HeapNode heapNode, HeapNode heapNode1) {return heapNode1.getValue() > heapNode.getValue();}

    private boolean isRightSuccessorExist(int right) {return right < size;}

    void display() {
        System.out.print("heapArray: ");
        // Формат массива
        for (int m = 0; m < size; m++)
            if (heapArray[m] != null)
                System.out.print(heapArray[m].getValue() + " ");
            else
                System.out.print("-- ");
        System.out.println(); // Формат пирамиды
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // Текущий элемент
        String dots = "...............................";
        System.out.println(dots + dots); // Верхний пунктир

        while (size > 0) // Для каждого элемента пирамиды
        {
            if (column == 0) // Первый элемент в строке?
                for (int k = 0; k < nBlanks; k++) // Предшествующие пробелы
                    System.out.print(' ');

            System.out.print(heapArray[j].getValue());
            if (++j == size) // Вывод завершен?
                break;
            if (++column == itemsPerRow) // Конец строки?
            {
                nBlanks /= 2; // Половина пробелов
                itemsPerRow *= 2; // Вдвое больше элементов
                column = 0; // Начать заново
                System.out.println(); // Переход на новую строку
            }
            else // Следующий элемент в строке
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' '); // Внутренние пробелы
        }
        System.out.println("\n" + dots + dots); // Нижний пунктир


    }

    static class HeapNode {
        private int value;

        public HeapNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }


}
