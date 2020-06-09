package main.problems.java;

public class Nr26 {
    public int removeDuplicates(int[] nums) {
        int slowPointer = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[slowPointer] = nums[i];
                slowPointer++;
            }
        }

        return slowPointer;
    }
}
