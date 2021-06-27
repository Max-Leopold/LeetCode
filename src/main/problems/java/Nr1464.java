package main.problems.java;

public class Nr1464 {
    public int maxProduct(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int min = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                min = max;
                max = nums[i];
            } else if (nums[i] > min) {
                min = nums[i];
            }
        }

        return (max - 1) * (min - 1);
    }
}
