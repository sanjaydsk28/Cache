package com.sanjay.algorithms;

import com.sanjay.algorithms.exceptions.InvalidElementException;
import com.sanjay.algorithms.exceptions.NoSuchElementException;
import com.sanjay.cache.exceptions.NoKeyFoundException;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode tailPrev = dummyTail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidElementException("Element is Invalid");
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public boolean isListNotEmpty() {
        return dummyHead != dummyTail;
    }

    public DoublyLinkedListNode<E> getFirstNode() throws NoKeyFoundException {
        if (!isListNotEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return dummyHead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() throws NoKeyFoundException {
        if (!isListNotEmpty()) {
            throw new NoKeyFoundException("List is Empty");
        }
        return dummyTail.prev;
    }
}
