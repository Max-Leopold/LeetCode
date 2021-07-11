package main.problems.java;

import java.util.Arrays;

public class Nr31 {

    public void nextPermutation(int[] nums) {
        boolean foundPermutation = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nextPermutation(nums, i)) {
                foundPermutation = true;
                break;
            }
        }
        if (!foundPermutation) {
            Arrays.sort(nums);
        }
    }


    private boolean nextPermutation(int[] nums, int front) {
        for (int i = nums.length - 1; i > front; i--) {
            if (nums[i] > nums[front]) {
                int tmp = nums[front];
                nums[front] = nums[i];
                nums[i] = tmp;
                Arrays.sort(nums, front + 1, nums.length);
                return true;
            }
        }
        return false;
    }
}
