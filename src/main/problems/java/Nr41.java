package main.problems.java;

public class Nr41 {
    public int firstMissingPositive(int[] nums) {
        int biggestPositiveNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            } else {
                biggestPositiveNumber = Math.max(biggestPositiveNumber, nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int pointer = Math.abs(nums[i]);
            if (pointer != 0 && pointer <= nums.length) {
                if (nums[pointer - 1] != 0) {
                    nums[pointer - 1] = -Math.abs(nums[pointer - 1]);
                } else {
                    nums[pointer - 1] = -Math.abs(pointer);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return biggestPositiveNumber + 1;
    }
}
