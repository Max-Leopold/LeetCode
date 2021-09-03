package main.google.codejam.qualification.reversort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int length = in.nextInt();
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j] = in.nextInt();
            }

            int reverseOperations = 0;
            for (int j = 0; j < nums.length - 1; j++) {
                int minIndex = findMin(nums, j);
                reverseOperations += (minIndex - j) + 1;
                reverse(nums, j, minIndex);
            }
            System.out.println("Case #" + (i + 1) + ": " + reverseOperations);
        }
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
            from++;
            to--;
        }
    }

    private static int findMin(int[] nums, int from) {
        int minIndex = from;
        for (int i = from; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
