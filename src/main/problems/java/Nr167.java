package main.problems.java;

import java.util.Arrays;

public class Nr167 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int searchTarget = target - numbers[i];
            int secondIndex = Arrays.binarySearch(numbers, searchTarget);
            if (secondIndex > 0 && secondIndex != i) {
                int[] returnArray = new int[]{i + 1, secondIndex + 1};
                Arrays.sort(returnArray);
                return returnArray;
            }
        }

        throw new RuntimeException("This code should be unreachable");
    }
}
