package main.problems.java;

public class Nr198 {
    public static void main(String[] args) {
        Nr198 nr198 = new Nr198();
        System.out.println(
                nr198.rob(new int[]{1, 2, 1, 1})
        );
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] maxProfit = new int[nums.length];
        maxProfit[maxProfit.length - 1] = nums[nums.length - 1];
        maxProfit[maxProfit.length - 2] = nums[nums.length - 2];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || i == nums.length - 2) {
                maxProfit[i] = nums[i];
            } else if (i == nums.length - 3) {
                maxProfit[i] = Math.max(nums[i] + maxProfit[nums.length - 1], nums[i + 1]);
            } else {
                maxProfit[i] = nums[i] + Math.max(maxProfit[i + 2], maxProfit[i + 3]);
            }
        }
        return Math.max(maxProfit[0], maxProfit[1]);
    }
}
