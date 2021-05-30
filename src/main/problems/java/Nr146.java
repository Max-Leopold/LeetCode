package main.problems.java;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Nr146 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

    }

    static class LRUCache {
        final int CACHE_CAPACITY;
        final HashMap<Integer, Integer> currentlyInCache;
        final Deque<Integer> cache;

        public LRUCache(int capacity) {
            CACHE_CAPACITY = capacity;
            currentlyInCache = new HashMap<>();
            cache = new LinkedList<>();
        }

        public int get(int key) {
            int val = currentlyInCache.getOrDefault(key, -1);
            if (val == -1) {
                return val;
            }
            cache.remove(key);
            cache.addFirst(key);
            return val;
        }

        public void put(int key, int value) {
            if (currentlyInCache.containsKey(key)) {
                cache.remove(key);
            } else {
                if (cache.size() >= CACHE_CAPACITY) {
                    currentlyInCache.remove(cache.removeLast());
                }
            }
            cache.addFirst(key);
            currentlyInCache.put(key, value);
        }
    }

    // Nice solution using advanced built in Java Datastructures
    static class LRUCache2 extends LinkedHashMap<Integer, Integer> {

        final int CACHE_CAPACITY;

        public LRUCache2(int capacity) {
            super(capacity, 0.75f, true);
            CACHE_CAPACITY = capacity;
        }

        @Override
        public Integer get(Object key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > CACHE_CAPACITY;
        }
    }
}
