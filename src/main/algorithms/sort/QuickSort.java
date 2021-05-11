package main.algorithms.sort;

public class QuickSort {

    public static int[] sort(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private static int[] sort(int[] nums, int start, int end) {
        if (end <= start) {
            return nums;
        }
        int pivot = nums[start];
        int pivotIndex = partition(nums, start, end, pivot);
        sort(nums, start, pivotIndex);
        sort(nums, pivotIndex + 1, end);
        return nums;
    }

    private static int partition(int[] nums, int start, int end, int pivot) {
        start--;
        end++;
        while (true) {
            do {
                start++;
            } while (nums[start] < pivot);

            do {
                end--;
            } while (nums[end] > pivot);

            if (end <= start) {
                return end;
            }
            swap(nums, start, end);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
