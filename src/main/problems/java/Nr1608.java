package main.problems.java;

public class Nr1608 {
    public int specialArray(int[] nums) {
        int maxNumberWeSearchFor = nums.length;
        int[] counts = new int[maxNumberWeSearchFor + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumberWeSearchFor) {
                counts[maxNumberWeSearchFor]++;
            } else {
                counts[nums[i]]++;
            }
        }
        int numsSoFar = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            numsSoFar += counts[i];
            if (i == numsSoFar) {
                return i;
            }
        }
        return -1;
    }
}
