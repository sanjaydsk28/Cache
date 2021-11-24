package com.sanjay.cache.factories;

import com.sanjay.cache.Cache;
import com.sanjay.cache.policies.LRUEvictionPolicy;
import com.sanjay.cache.storage.HashMapStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> getDefaultCache(final int capcity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapStorage<Key, Value>(capcity));
    }
}
