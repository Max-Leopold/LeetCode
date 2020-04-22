package main.april.java;

import java.util.HashMap;

public class Day22 {

	public static void main(String[] args) {
		Day22 day22 = new Day22();
		System.out.println(day22.subarraySum(new int[]{-1, -1, 1}, 1));
	}

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> prefixSumOccurrences = new HashMap<>();
		int prefixSum = 0;
		int count = 0;

		prefixSumOccurrences.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSumOccurrences.containsKey(prefixSum - k)) {
				count += prefixSumOccurrences.get(prefixSum - k);
			}
			prefixSumOccurrences.put(prefixSum, prefixSumOccurrences.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}

}
