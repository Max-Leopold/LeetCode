package main.problems.java;

public class Nr961 {
    public int repeatedNTimes(int[] nums) {
        boolean[] seen = new boolean[10001];
        for (int i = 0; i < nums.length; i++) {
            if (seen[nums[i]]) {
                return nums[i];
            }
            seen[nums[i]] = true;
        }
        return -1;
    }
}
