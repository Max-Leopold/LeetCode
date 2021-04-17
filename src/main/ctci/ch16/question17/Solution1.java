package main.ctci.ch16.question17;

// Questions
// if all ints are negative return 0 or the least negative number? (Least negative number)

public class Solution1 {

    static int contiguosSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        // Simple scanline
        int currentSum = 0;
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
