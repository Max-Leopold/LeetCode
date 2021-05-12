package main.algorithms.search;


public class BinarySearch {

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int start, int end) {
        int pivotIndex = (end + start) / 2;
        if (nums[pivotIndex] == target) {
            return (end + start) / 2;
        } else if (end <= start) {
            return -1;
        }
        if (nums[pivotIndex] < target) {
            return search(nums, target, pivotIndex + 1, end);
        } else {
            return search(nums, target, start, pivotIndex - 1);
        }
    }
}
