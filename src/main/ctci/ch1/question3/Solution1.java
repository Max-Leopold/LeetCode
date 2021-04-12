package main.ctci.ch1.question3;

// O(n) but many shift operations

// Questions:
// Is the String exactly the size needed or could it be more?

public class Solution1 {

    static char[] urlify(char[] string, int realLength) {
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                shiftRight(string, 2, i + 1);
                string[i] = '%';
                string[i + 1] = '2';
                string[i + 2] = '0';
                i = i + 2;
            }
        }

        return string;
    }

    private static void shiftRight(char[] string, int by, int from) {
        for (int i = string.length - 1 - by; i >= from; i--) {
            string[i + by] = string[i];
        }
    }
}
