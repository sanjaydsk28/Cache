package com.sanjay.cache;

import com.sanjay.cache.exceptions.NoKeyFoundException;
import com.sanjay.cache.exceptions.StorageFullException;
import com.sanjay.cache.policies.EvictionPolicy;
import com.sanjay.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException storageFullException) {
            System.out.println("Storage is full. Key will be evicted");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Storage full and No key to evict");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Removed the key and created the space");
            put(key, value);
        }
    }

    public  Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NoKeyFoundException exception) {
            System.out.println("Key Not found in the storage");
            return null;
        }
    }
}
