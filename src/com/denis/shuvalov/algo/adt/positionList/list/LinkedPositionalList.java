package com.denis.shuvalov.algo.adt.positionList.list;

import com.denis.shuvalov.algo.adt.positionList.Position;
import com.denis.shuvalov.algo.adt.positionList.PositionalList;

/**
 * size( ) O(1)
 * isEmpty( ) O(1)
 * first( ), last( ) O(1)
 * before(p), after(p) O(1)
 * addFirst(e), addLast(e) O(1)
 * addBefore(p, e), addAfter(p, e) O(1)
 * set(p, e) O(1)
 * remove(p) O(1)
 * The space usage is O(n)
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int capacity;

    public LinkedPositionalList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.setNext(tail);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public Position<E> first() {
        return position(head.getNext());
    }

    @Override
    public Position<E> last() {
        return position(tail.getPrevious());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrevious());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(head, e, head.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(tail.getPrevious(), e, tail);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node.getPrevious(), e, node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node, e, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> successor = node.getNext();
        Node<E> predecessor = node.getPrevious();

        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        this.capacity--;

        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrevious(null);

        return answer;
    }

    private Position<E> addBetween(Node<E> previous, E element, Node<E> next) {
        Node<E> newest = new Node<>(previous, element, next);
        previous.setNext(newest);
        next.setPrevious(newest);
        capacity++;
        return newest;
    }


    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("position is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == head || node == tail) return null;
        return node;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        if (!isEmpty()) {
            sb.append("[");
            int tmp = this.capacity;

            Node<E> n = this.head.getNext();
            while (tmp > 0) {
                sb.append(n.getElement());
                n = n.getNext();
                tmp--;
                if (tmp != 0) sb.append(", ");
            }
            sb.append("]");
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    private static class Node<E> implements Position<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }

        public Node(Node<E> previous, E element, Node<E> next) {
            this(element);
            this.previous = previous;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node setNext(Node<E> next) {
            this.next = next;
            return this;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node setPrevious(Node<E> previous) {
            this.previous = previous;
            return this;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node setElement(E element) {
            this.element = element;
            return this;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}
