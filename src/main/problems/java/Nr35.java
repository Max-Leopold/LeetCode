package main.problems.java;

import java.util.Arrays;

public class Nr35 {

    public static void main(String[] args) {
        Nr35 nr35 = new Nr35();
        System.out.println(nr35.searchInsert(
                new int[]{1, 3, 5, 7},
                6
        ));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start >= end) {
            if (nums[start] < target) {
                return start + 1;
            }
            return start;
        }
        int pivot = (start + end) / 2;
        if (nums[pivot] == target) {
            return pivot;
        } else if (nums[pivot] > target) {
            return binarySearch(nums, target, start, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, end);
        }
    }

    // Boring solution using built in binary search
    public int searchInsert2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return Math.abs(index + 1);
        }
        return index;
    }
}
