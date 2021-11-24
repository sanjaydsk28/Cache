package com.sanjay.cache.policies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUEvictionPolicyTest {
    private LRUEvictionPolicy<Integer> lruEvictionPolicy;

    @BeforeEach
    void setUp() {
        lruEvictionPolicy = new LRUEvictionPolicy<>();
    }

    @Test
    void testNoKeyToEvict() {
        assertNull(lruEvictionPolicy.evictKey());
    }

    @Test
    void testKeysAreEvictedInOrderOfAccessed() {
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);

        assertEquals(1, lruEvictionPolicy.evictKey());
        assertEquals(2, lruEvictionPolicy.evictKey());
        assertEquals(3, lruEvictionPolicy.evictKey());
        assertEquals(4, lruEvictionPolicy.evictKey());
    }

    @Test
    void testReOrderingTheKeyAccessingElements() {
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(2);

        assertEquals(3, lruEvictionPolicy.evictKey());
        assertEquals(1, lruEvictionPolicy.evictKey());
        assertEquals(4, lruEvictionPolicy.evictKey());
        assertEquals(2, lruEvictionPolicy.evictKey());
    }

}
