package com.denis.shuvalov.algo.hash.chain;

import java.lang.reflect.Array;

class ChainHashing<T extends Comparable<T>> {
    private static final int THRESHOLD = 2;
    private SortedList<T>[] buckets;
    private int capacity;

    @SuppressWarnings("unchecked")
    ChainHashing(int capacity) {
        this.capacity = capacity;
        buckets = (SortedList<T>[]) Array.newInstance(SortedList.class, capacity);
    }

    public void insert(T elem) {
        int bucketIndex = hashPrimary(elem);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new SortedList<T>().insert(elem);
        }
        else {
            if (buckets[bucketIndex].size > THRESHOLD) {
                resize();
                insert(elem);
            }
            else buckets[bucketIndex].insert(elem);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        System.out.println("RESIZING");
        capacity *= 1.6;
        SortedList<T>[] tmp = buckets;
        buckets = (SortedList<T>[]) Array.newInstance(SortedList.class, capacity);

        for (SortedList<T> bucket : tmp) {
            if (bucket != null) {
                HashNode<T> node = bucket.root;
                while (node != null) {
                    this.insert(node.getElem());
                    node = node.getNext();
                }
            }
        }
    }

    public T get(T elem) {
        int bucketIndex = hashPrimary(elem);
        return buckets[bucketIndex].remove(elem);
    }

    public void display() {
        int i = 0;
        for (SortedList<T> bucket : buckets) {
            if (bucket != null) {
                System.out.print("Bucket[" + i + "]: ");
                bucket.display();
                System.out.println();
            }
            i++;
        }
    }

    private int hashPrimary(T elem) {
        return elem.hashCode() % capacity;
    }


    private static class SortedList<T extends Comparable<T>> {
        private HashNode<T> root;
        private int size = 0;

        private SortedList<T> insert(T elem) {
            HashNode<T> newest = new HashNode<>(elem);

            if (isEmpty()) {
                root = newest;
                size++;
            }
            else {
                HashNode<T> current = this.root;

                while (current.getElem().compareTo(elem) < 0) {
                    if (current.getNext() == null) { //add last
                        insertLast(newest, current);
                        return this;
                    }

                    current = current.getNext();
                }

                if (current == root) {
                    insertFirst(newest);
                    return this;
                }

                insertAfter(current.getPrevious(), newest);
            }

            return this;
        }

        private T remove(T elem) {
            if (isEmpty()) {
                return null;
            }
            else {
                HashNode<T> current = this.root;
                while (current.getElem().compareTo(elem) != 0) {
                    if (current.getNext() == null) {
                        return null;
                    }
                    current = current.getNext();
                }

                size--;
                return unlink(current).getElem();
            }
        }

        private HashNode<T> unlink(HashNode<T> node) {
            HashNode<T> previous = node.getPrevious();
            HashNode<T> next = node.getNext();

            if (node == root) {
                root = node.getNext();
            }

            if (previous != null) previous.setNext(next);
            if (next != null) next.setPrevious(previous);

            return node;
        }

        private void insertLast(HashNode<T> newest, HashNode<T> current) {
            current.setNext(newest);
            newest.setPrevious(current);
            size++;
        }

        private void insertFirst(HashNode<T> newest) {
            newest.setNext(root);
            root.setPrevious(newest);
            root = newest;
            size++;
        }

        private void insertAfter(HashNode<T> current, HashNode<T> newest) {
            newest.setNext(current.getNext())
                    .setPrevious(current);
            current.getNext().setPrevious(newest);
            current.setNext(newest);
            size++;
        }

        private T remove() {
            HashNode<T> tmp = this.root;
            HashNode<T> next = root.getNext();
            next.setPrevious(null);
            root = next;
            root = null;
            return tmp.getElem();
        }

        private void display() {
            System.out.print(root + " -> ");
            HashNode tmp = null;
            if (!isEmpty()) tmp = root.next;
            while (tmp != null) {
                if (tmp.next == null)
                    System.out.print(tmp /*+ "\n"*/);
                else
                    System.out.print(tmp + " -> ");
                tmp = tmp.next;
            }
        }

        private boolean isEmpty() {
            return size == 0;
        }
    }

    private static class HashNode<T extends Comparable<T>> {
        private T elem;
        private HashNode<T> next;
        private HashNode<T> previous;

        public HashNode(T elem) {
            this.elem = elem;
        }

        public HashNode<T> getPrevious() {
            return previous;
        }

        public HashNode<T> setPrevious(HashNode<T> previous) {
            this.previous = previous;
            return this;
        }

        public HashNode<T> getNext() {
            return next;
        }

        public HashNode<T> setNext(HashNode<T> next) {
            this.next = next;
            return this;
        }

        public T getElem() {
            return elem;
        }

        @Override
        public String toString() {
            return String.valueOf(elem);
        }
    }
}
