package main.java.solutions;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 */

public class Nr1 {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }
}
