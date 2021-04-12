package main.ctci.ch1.question2;

// O(n) where n is the length of the strings

// Questions:
// Which character set is used? ASCII? (I assume ASCII)
// String manipulation is allowed?
// Whitespaces significant?
// Upper-/lowercase significant?

public class Solution1 {

    static boolean checkPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] charCount = new int[128];
        for (int i = 0; i < first.length(); i++) {
            charCount[first.charAt(i)] += 1;
            charCount[second.charAt(i)] -= 1;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
