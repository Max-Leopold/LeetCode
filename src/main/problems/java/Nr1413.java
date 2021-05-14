package main.problems.java;

public class Nr1413 {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = sumSoFar + nums[i] + startValue;
            if (currentSum < 1) {
                int difference = Math.abs(currentSum - 1);
                startValue += difference;
            }
            sumSoFar = sumSoFar + nums[i];
        }
        return startValue;
    }
}
