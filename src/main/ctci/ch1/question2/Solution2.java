package main.ctci.ch1.question2;

// O(n log n) -> sorting

import java.util.Arrays;

public class Solution2 {

    static boolean checkPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstChars = first.toCharArray();
        Arrays.sort(firstChars);
        char[] secondChars = second.toCharArray();
        Arrays.sort(secondChars);

        for (int i = 0; i < firstChars.length; i++) {
            if (firstChars[i] != secondChars[i]) {
                return false;
            }
        }

        return true;
    }
}
