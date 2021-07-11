package main.problems.java;

public class Nr34 {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = binarySearch(nums, target, 0, nums.length - 1, true);
        if (startIndex == -1) {
            return new int[]{-1, -1};
        }
        int endIndex = binarySearch(nums, target, startIndex, nums.length - 1, false);
        return new int[]{
                startIndex,
                endIndex
        };
    }

    public int binarySearch(int[] nums, int target, int start, int end, boolean findFirst) {
        int result = -1;

        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                result = pivot;
                if (findFirst) {
                    end = pivot - 1;
                } else {
                    start = pivot + 1;
                }
            } else if (nums[pivot] < target) {
                start = pivot + 1;
            } else if (nums[pivot] > target) {
                end = pivot - 1;
            }
        }

        return result;
    }
}
