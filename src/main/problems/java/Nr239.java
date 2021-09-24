package main.problems.java;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Nr239 {
	public static void main(String[] args) {
		Nr239 nr239 = new Nr239();
		System.out.println(Arrays.toString(nr239.maxSlidingWindow(
				new int[]{1, 3, -1, -3, 5, 3, 6, 7},
				3
		)));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] maximums = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			removeSmallerElements(nums, deque, i);
		}
		int windowStart = 0;
		int windowEnd = k - 1;

		while (windowEnd < nums.length - 1) {
			maximums[windowStart] = nums[deque.getFirst()];

			windowStart++;
			windowEnd++;

			removeSmallerElements(nums, deque, windowEnd);
			if (deque.getFirst() < windowStart) {
				deque.removeFirst();
			}
		}
		maximums[windowStart] = nums[deque.getFirst()];
		return maximums;
	}

	private void removeSmallerElements(int[] nums, Deque<Integer> deque, int index) {
		while (deque.size() > 0 && nums[deque.getLast()] < nums[index]) {
			deque.removeLast();
		}
		deque.addLast(index);
	}
}
