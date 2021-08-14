package main.problems.java;

public class Nr704 {
    public static void main(String[] args) {
        Nr704 nr704 = new Nr704();
        System.out.println(nr704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int pivot = (end + start) / 2;
        if (target == nums[pivot]) {
            return pivot;
        } else if (target < nums[pivot]) {
            return binarySearch(nums, target, start, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, end);
        }
    }
}
