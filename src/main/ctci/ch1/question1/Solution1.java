package main.ctci.ch1.question1;

// With additional space
// O(n)

// Question:
// Can the String contain whitespaces?
// Are whitespaces also counted as characters?
// Is Uppercase = Lowercase?
// Are only letters characters?
// Does the String only contain ASCII letters or is it a different encoding? (e.g. UTF8)

public class Solution1 {

    static boolean isUnique(String s) {
        boolean[] charCounter = new boolean[128];

        for (char c : s.toCharArray()) {
            if (charCounter[c]) {
                return false;
            } else {
                charCounter[c] = true;
            }
        }

        return true;
    }
}
