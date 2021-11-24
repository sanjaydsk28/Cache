package com.sanjay.algorithms;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
    DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
    DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
    DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

    @Test
    void testDLLAddition() {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        dll.addNodeAtLast(node1);
        verifyDLL(dll, ImmutableList.of(1));

        dll.addNodeAtLast(node2);
        verifyDLL(dll, ImmutableList.of(1, 2));

        dll.addNodeAtLast(node3);
        verifyDLL(dll, ImmutableList.of(1, 2, 3));

        dll.addNodeAtLast(node4);
        verifyDLL(dll, ImmutableList.of(1, 2 ,3, 4));
    }

    @Test
    void testDetachNode() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        DoublyLinkedListNode<Integer> node1 = dll.addElementAtLast(1);
        DoublyLinkedListNode<Integer> node2 = dll.addElementAtLast(2);
        DoublyLinkedListNode<Integer> node3 = dll.addElementAtLast(3);
        DoublyLinkedListNode<Integer> node4 = dll.addElementAtLast(4);

        verifyDLL(dll, ImmutableList.of(1,2,3,4));

        dll.detachNode(node1);
        verifyDLL(dll, ImmutableList.of(2,3,4));

        dll.detachNode(node4);
        verifyDLL(dll, ImmutableList.of(2,3));

        dll.detachNode(node3);
        verifyDLL(dll, ImmutableList.of(2));

    }

    void verifyDLL(DoublyLinkedList<Integer> dll, List<Integer> expectedList) {
        assertEquals(expectedList.get(expectedList.size() - 1), dll.getLastNode().getElement());
        assertEquals(expectedList.get(0), dll.getFirstNode().getElement());

        DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();

        for (Integer expectedElement :  expectedList) {
            assertNotNull(currentNode);
            assertEquals(expectedElement, currentNode.getElement());
            currentNode = currentNode.next;
        }
//        assertNotNull(currentNode.next);
    }

}
