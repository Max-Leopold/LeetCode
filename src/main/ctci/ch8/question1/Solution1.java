package main.ctci.ch8.question1;

// Questions
// Can I "overshoot"? E.g. I'm on step from the end can I do 2 steps to get to the end? (No)
// Does the number of solutions fit in an integer?

public class Solution1 {

    static int wayOfRunning(int n) {
        if (n == 0) {
            throw new IllegalArgumentException();
        }

        int[] fromHere = new int[n + 1];
        fromHere[n] = 1;
        startRunning(n - 1, fromHere);
        return fromHere[0];
    }

    private static void startRunning(int start, int[] fromHere) {
        int solutions = 0;
        if (start + 1 < fromHere.length) {
            solutions += fromHere[start + 1];
        }
        if (start + 2 < fromHere.length) {
            solutions += fromHere[start + 2];
        }
        if (start + 3 < fromHere.length) {
            solutions += fromHere[start + 3];
        }

        fromHere[start] = solutions;
        if (start == 0) {
            return;
        }
        startRunning(start - 1, fromHere);
    }
}
