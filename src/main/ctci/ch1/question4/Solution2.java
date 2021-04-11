package main.ctci.ch1.question4;

import java.util.Locale;

public class Solution2 {

    static boolean palindromePermutation(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        // If Uppercase/Lowercase is important remove this line
        input = input.toLowerCase(Locale.ROOT);

        int bitVector = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                continue;
            }

            bitVector = toggleBit(bitVector, input.charAt(i) - 'a');
        }

        int mask = bitVector - 1;
        return (bitVector & mask) == 0;
    }


    private static int toggleBit(int bitVector, int bit) {
        return bitVector ^ (1 << bit);
    }
}
