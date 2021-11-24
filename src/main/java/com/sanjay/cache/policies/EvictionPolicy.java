package com.sanjay.cache.policies;

public interface EvictionPolicy<Key> {
    public void keyAccessed(Key key);

    Key evictKey();
}
