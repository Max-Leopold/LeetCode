package main.problems.java;

public class Nr581 {
    public static void main(String[] args) {
        Nr581 nr581 = new Nr581();
        System.out.println(nr581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int minValueIndexInUnsortedArray = -1;
        for (int i = 1; i < nums.length; i++) {
            if (minValueIndexInUnsortedArray == -1) {
                if (nums[i] < nums[i - 1]) {
                    minValueIndexInUnsortedArray = i;
                }
            } else {
                if (nums[i] < nums[minValueIndexInUnsortedArray]) {
                    minValueIndexInUnsortedArray = i;
                }
            }
        }
        if (minValueIndexInUnsortedArray == -1) {
            return 0;
        }

        int maxValueIndexInUnsortedArray = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (maxValueIndexInUnsortedArray == -1) {
                if (nums[i] > nums[i + 1]) {
                    maxValueIndexInUnsortedArray = i;
                }
            } else {
                if (nums[i] > nums[maxValueIndexInUnsortedArray]) {
                    maxValueIndexInUnsortedArray = i;
                }
            }
        }

        int start = minValueIndexInUnsortedArray;
        for (int i = 0; i < minValueIndexInUnsortedArray; i++) {
            if (nums[i] > nums[minValueIndexInUnsortedArray]) {
                start = i;
                break;
            }
        }

        int end = maxValueIndexInUnsortedArray;
        for (int i = nums.length - 1; i > maxValueIndexInUnsortedArray; i--) {
            if (nums[i] < nums[maxValueIndexInUnsortedArray]) {
                end = i;
                break;
            }
        }

        return end - start < 0 ? 0 : end - start + 1;
    }
}
