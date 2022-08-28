package main.problems.java;

import java.util.Collections;
import java.util.PriorityQueue;

public class Nr295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {

        private final PriorityQueue<Integer> left_part;
        private final PriorityQueue<Integer> right_part;

        public MedianFinder() {
            // max heap for left array
            left_part = new PriorityQueue<>(Collections.reverseOrder());
            // min heap for right array
            right_part = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (!left_part.isEmpty() && left_part.peek() > num) {
                // Belongs in left part
                left_part.offer(num);
            } else {
                // Belongs in right part
                right_part.offer(num);
            }

            if (left_part.size() -1 > right_part.size()) {
                right_part.offer(left_part.poll());
            } else if (right_part.size() > left_part.size()) {
                left_part.offer(right_part.poll());
            }
        }

        public double findMedian() {
            if (left_part.size() == right_part.size()) {
                return (left_part.peek() + right_part.peek()) / 2.0;
            }

            return left_part.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
