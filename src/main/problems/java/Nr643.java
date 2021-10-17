package main.problems.java;

public class Nr643 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / (double) k;
    }
}
