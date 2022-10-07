package main.problems.java;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Nr732 {
    class MyCalendarThree {

        private final SortedMap<Integer, Integer> concurrentEvents = new TreeMap<>();

        public int book(int start, int end) {
            concurrentEvents.put(start, concurrentEvents.getOrDefault(start, 0) + 1);
            concurrentEvents.put(end, concurrentEvents.getOrDefault(end, 0) - 1);
            int maxConcurrentEvents = 0;
            int currentConcurrentEvents = 0;
            for (Integer events : concurrentEvents.values()) {
                currentConcurrentEvents += events;
                maxConcurrentEvents = Math.max(currentConcurrentEvents, maxConcurrentEvents);
            }

            return maxConcurrentEvents;
        }
    }
}
