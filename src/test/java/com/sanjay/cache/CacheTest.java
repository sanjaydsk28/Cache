package com.sanjay.cache;

import com.sanjay.cache.factories.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {
    Cache<Integer, Integer> cache;

    @BeforeEach
    public void setUp() {
        cache = new CacheFactory<Integer,Integer>().getDefaultCache(3);
    }

    @Test
    void testCache() {
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));

        cache.put(4, 3);
        assertEquals(3, cache.get(4));

        cache.put(5,5);
        assertNull(cache.get(2));

    }
}
