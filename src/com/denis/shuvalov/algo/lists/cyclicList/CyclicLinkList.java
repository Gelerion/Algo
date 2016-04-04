package com.denis.shuvalov.algo.lists.cyclicList;

/**
 * Циклическим списком называется связанный список, в котором последний
 * элемент содержит ссылку на первый элемент. Существует много способов реализа-
 * ции циклических списков. Иногда объект списка содержит указатель на «начало»
 * списка. Однако в этом случае список уже не похож на замкнутый круг, а больше
 * напоминает обычный список, у которого конец связан с началом. Создайте класс
 * для односвязного списка, не имеющий ни начала, ни конца. Доступ к списку осу-
 * ществляется по единственной ссылке current, которая может указывать на любой
 * элемент списка. Ссылка перемещается по списку так, как требуется пользователю
 * (ситуация, для которой идеально подходит циклический список, представлена
 * в проекте 5.5). Список должен поддерживать операции вставки, поиска и удаления.
 * Вероятно, удобнее выполнять эти операции с элементом, следующим за тем, на
 * который указывает current. (Так как список является односвязным, вы не сможе-
 * те вернуться к предыдущему элементу без полного прохождения всей цепочки.)
 * Также следует предусмотреть возможность вывода содержимого списка (хотя его
 * придется разбить в некоторой точке для вывода на экран). Метод step(), который
 * перемещает current к следующему элементу, тоже может пригодиться.
 */
public class CyclicLinkList {
    private Node<Integer> current;
    private int size;

    /**
     * insert value after current
     */
    void insert(Integer value) {
        Node<Integer> node = new Node<>(value);
        if (isEmpty()) {
            current = node;
            current.previous = current;
            current.next = current;
        } else {
            current.next = node;
            node.previous = current;

            current.previous = node;
            node.next = current;

            current = node;
        }

//        Node<Integer> node = new Node<>(value, current);
//        if(isEmpty()) {
//            current = node;
//            current.next = current;
//        }
//        else current.next = node;
//        current = node;
        size++;
    }

    void moveForward() {

    }

    void moveBack() {

    }

    boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node<Integer> tmp = this.current;
        //iterating till first element
        for (int i = 0; i < size; i++) {
            tmp = tmp.next;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }


    }
}
