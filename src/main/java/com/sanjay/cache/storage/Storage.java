package com.sanjay.cache.storage;

import com.sanjay.cache.exceptions.NoKeyFoundException;
import com.sanjay.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {

    public void add(Key key, Value value) throws StorageFullException;

    public void remove(Key key) throws NoKeyFoundException;

    public Value get(Key key) throws NoKeyFoundException;
}
