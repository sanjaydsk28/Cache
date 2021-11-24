package com.sanjay.cache.storage;

import com.sanjay.cache.exceptions.NoKeyFoundException;
import com.sanjay.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @java.lang.Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) throw new StorageFullException("Capacity is full");
        storage.put(key, value);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }

    @java.lang.Override
    public void remove(Key key) throws NoKeyFoundException {
        if (!storage.containsKey(key)) throw new NoKeyFoundException(key + " not found in cache");
        storage.remove(key);
    }

    @java.lang.Override
    public Value get(Key key) throws NoKeyFoundException {
        if (!storage.containsKey(key)) throw new NoKeyFoundException(key + " not found in cache");
        return storage.get(key);
    }
}

