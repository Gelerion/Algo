package com.denis.shuvalov.algo.adt.queue.list_based;

//FIFO
public class LinkBasedQueue {
    private Link first;
    private Link last;

    public void add(String elem) {
        Link link = new Link(elem);
        if(isEmpty())
            first = link;
        else
            last.next = link;

        last = link;
    }

    public String get() {
        return first.value;
    }

    public String remove() {
        String value = first.value;
        if(first.next == null) last = null;
        first = first.next;
        return value;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private class Link {
        String value;
        Link next;

        public Link(String value, Link next) {
            this.value = value;
            this.next = next;
        }

        Link(String value) {
            this.value = value;
        }
    }
}
