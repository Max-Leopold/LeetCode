package main.ctci.ch1.question1;

// With additional space
// O(n log n) -> Sorting

import java.util.Arrays;

public class Solution2 {

    public static boolean isUnique(String s) {
        char[] sortedChars = s.toCharArray();
        Arrays.sort(sortedChars);

        for (int i = 1; i < sortedChars.length; i++) {
            if (sortedChars[i] == sortedChars[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
