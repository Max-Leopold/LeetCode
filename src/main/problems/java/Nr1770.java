package main.problems.java;

public class Nr1770 {
    public int maximumScore(int[] nums, int[] multipliers) {
        return helper(
                nums,
                multipliers,
                0,
                nums.length - 1,
                0,
                new Integer[multipliers.length][multipliers.length]
        );
    }

    public int helper(int[] nums, int[] multipliers, int start, int end, int i, Integer[][] dp) {
        if (i == multipliers.length) return 0;
        if (dp[start][i] != null) return dp[start][i];

        // Choose left
        int leftScore = nums[start] * multipliers[i];
        leftScore += helper(nums, multipliers, start + 1, end, i + 1, dp);

        // Choose right
        int rightScore = nums[end] * multipliers[i];
        rightScore += helper(nums, multipliers, start, end - 1, i + 1, dp);

        int max = Math.max(leftScore, rightScore);
        dp[start][i] = max;
        return max;
    }
}
