package main.ctci.ch1.question4;

// O(n) time with O(1) space

// Questions
// Do whitespaces matter? (Assumption: no)
// Does capitalization matter? (Assumption: no)
// Which char set is used? (Assumption: ASCII)

import java.util.Locale;

public class Solution1 {

    static boolean palindromePermutation(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        // If Uppercase/Lowercase is important remove this line
        input = input.toLowerCase(Locale.ROOT);
        int odds = 0;

        int[] charCounter = new int[128];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                continue;
            }

            charCounter[input.charAt(i)]++;
            if (charCounter[input.charAt(i)] % 2 != 0) {
                odds++;
            } else {
                odds--;
            }
        }

        return odds <= 1;
    }
}
