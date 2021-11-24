package com.sanjay.algorithms;

public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return this.element;
    }
}
