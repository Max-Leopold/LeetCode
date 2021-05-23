package main.problems.java;

public class Nr377 {
    public static void main(String[] args) {
        Nr377 nr377 = new Nr377();
        System.out.println(nr377.combinationSum4(
                new int[]{9},
                3
        ));
    }

    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new int[target + 1]);
    }

    public int combinationSum4(int[] nums, int target, int[] waysToTarget) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < waysToTarget.length) waysToTarget[nums[i]] = 1;
        }
        for (int i = 1; i < waysToTarget.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    waysToTarget[i] = waysToTarget[i] + waysToTarget[i - nums[j]];
                }
            }
        }
        return waysToTarget[target];
    }
}
