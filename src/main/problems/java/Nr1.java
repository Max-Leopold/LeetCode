package main.problems.java;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 */

public class Nr1 {

  public int[] twoSumEfficient(int[] nums, int target) {
    HashMap<Integer, Integer> numsToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int searchFor = target - nums[i];
      if (numsToIndex.containsKey(searchFor)) {
        return new int[]{numsToIndex.get(searchFor), i};
      } else {
        numsToIndex.put(nums[i], i);
      }
    }
    throw new IllegalArgumentException();
  }

  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }
}
