package main.algorithms.sort;

public class MergeSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return null;
        }
        return divide(nums, 0, nums.length);
    }

    private static int[] divide(int[] nums, int start, int end) {
        if (end - start == 1) {
            return new int[]{nums[start]};
        } else if (end - start < 1) {
            return new int[0];
        }
        int[] left = divide(nums, start, (end + start) / 2);
        int[] right = divide(nums, ((end + start) / 2), end);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int pointerLeft = 0;
        int pointerRight = 0;
        while (pointerLeft < left.length && pointerRight < right.length) {
            if (left[pointerLeft] < right[pointerRight]) {
                mergedArray[pointerLeft + pointerRight] = left[pointerLeft];
                pointerLeft++;
            } else {
                mergedArray[pointerLeft + pointerRight] = right[pointerRight];
                pointerRight++;
            }
        }
        if (pointerLeft == left.length) {
            for (; pointerRight < right.length; pointerRight++) {
                mergedArray[pointerLeft + pointerRight] = right[pointerRight];
            }
        } else {
            for (; pointerLeft < left.length; pointerLeft++) {
                mergedArray[pointerLeft + pointerRight] = left[pointerLeft];
            }
        }
        return mergedArray;
    }
}
