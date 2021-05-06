package main.problems.java;

import java.util.Arrays;

public class Nr16 {

    public static void main(String[] args) {
        Nr16 nr16 = new Nr16();
        System.out.println(nr16.threeSumClosest(
                new int[]{1, 2, 5, 10, 11},
                12
        ));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);

        int currentClosestToTarget = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == target) {
                    return sum;
                } else if (Math.abs(target - sum) < Math.abs(target - currentClosestToTarget)) {
                    currentClosestToTarget = sum;
                }
                if (sum > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return currentClosestToTarget;
    }
}
