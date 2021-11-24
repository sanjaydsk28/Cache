package com.sanjay.cache.policies;

import com.sanjay.algorithms.DoublyLinkedList;
import com.sanjay.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }

    @java.lang.Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)) {
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            map.put(key, newNode);
        }
    }

    @java.lang.Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if (first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}
