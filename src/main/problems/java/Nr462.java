package main.problems.java;

import java.util.Arrays;

public class Nr462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            steps += Math.abs(median - nums[i]);
        }
        return steps;
    }
}
