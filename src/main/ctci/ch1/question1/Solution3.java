package main.ctci.ch1.question1;

// Without additional data structures
// O(n), but String manipulation costs a lot

public class Solution3 {

    static boolean isUnique(String s) {

        for (int i = 0; i < s.length(); i++) {
            String character = s.substring(i, i + 1);
            s = s.substring(i + 1);
            if (s.contains(character)) {
                return false;
            }
        }

        return true;
    }
}
