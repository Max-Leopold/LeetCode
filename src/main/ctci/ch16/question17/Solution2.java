package main.ctci.ch16.question17;

// Return indices of maximum subarray instead of only sum

public class Solution2 {

    static int[] contiguosSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        // Simple scanline
        int[] currentIndices = new int[2];
        int[] bestIndices = new int[2];
        int currentSum = 0;
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                currentIndices[1] = i;
                bestIndices[0] = currentIndices[0];
                bestIndices[1] = currentIndices[1];
            }
            if (currentSum < 0) {
                currentSum = 0;
                currentIndices[0] = i + 1;
                currentIndices[1] = i + 1;
            }
        }

        return bestIndices;
    }
}
