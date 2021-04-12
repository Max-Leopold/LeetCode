package main.ctci.ch1.question3;

// O(n) but less shift operations

public class Solution2 {

    static char[] urlify(char[] string, int realLength) {
        int whitespaces = 0;
        for (int i = 0; i < realLength; i++) {
            if (string[i] == ' ') {
                whitespaces++;
            }
        }

        int initialShift = whitespaces * 2;
        shiftRightAndReplace(string, initialShift);

        return string;
    }

    private static void shiftRightAndReplace(char[] string, int by) {
        for (int i = string.length - 1 - by; i >= 0; i--) {
            if (string[i] == ' ') {
                by -= 2;

                string[i + by] = '%';
                string[i + 1 + by] = '2';
                string[i + 2 + by] = '0';
            } else {
                string[i + by] = string[i];
            }
        }
    }
}
