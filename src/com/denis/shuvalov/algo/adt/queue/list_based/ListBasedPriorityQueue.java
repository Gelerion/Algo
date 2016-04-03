package com.denis.shuvalov.algo.adt.queue.list_based;

import com.denis.shuvalov.algo.adt.queue.AdtPriorityQueue;

/**
 * Реализуйте приоритетную очередь на базе сортированного связанного
 * списка. Операция извлечения из приоритетной очереди должна извлекать элемент
 * с наименьшим ключом.
 */
public class ListBasedPriorityQueue<T extends Comparable<T>> implements AdtPriorityQueue<T> {
    private Node<T> first;

    @Override
    public void insert(T elem) {
        Node<T> insertNode = new Node<>(elem);

        if(isEmpty()) first = insertNode;
        else {
            Node<T> current = this.first;

            while (current != null) {
                //elem is bigger
                if (elem.compareTo(current.item) > 0) {
                    //last elem
                    if (current.next == null) {
                        current.next = insertNode;
                        insertNode.previous = current;
                        break;
                    }

                    current = current.next;
                }
                else {
                    insertNode.next = current;
                    if(current.previous == null) {
                        //first elem
                        first.previous = insertNode;
                        first = insertNode;
                    }
                    else {
                        current.previous.next = insertNode;
                        insertNode.previous = current.previous;
                        current.previous = insertNode;
                    }
                    break;
                }
            }
        }
    }

    @Override
    public T remove() {
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void display() {
        System.out.print("Forward: " + first + " -> ");
        Node<T> tmp = null;
        if (!isEmpty()) tmp = first.next;
        while (tmp != null) {
            if (tmp.next == null)
                System.out.print(tmp + "\n");
            else
                System.out.print(tmp + " -> ");
            tmp = tmp.next;
        }

        Node<T> last = this.first;
        while (last.next != null) {
            last = last.next;
        }

        System.out.print("Backward: " + last + " -> ");
        last = last.previous;
        while (last != null) {
            if (last.previous == null)
                System.out.print(last + "\n");
            else
                System.out.print(last + " -> ");
            last = last.previous;
        }

    }
}
