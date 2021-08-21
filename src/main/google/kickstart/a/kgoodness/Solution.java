package main.google.kickstart.a.kgoodness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            int initialGoodness = calculateInitialGoodness(s);
            int steps = Math.abs(initialGoodness - k);
            System.out.println("Case #" + (i + 1) + ": " + steps);
        }
    }

    private static int calculateInitialGoodness(String s) {
        int goodness = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (isGoodPair(s, i, n - i - 1)) goodness++;
        }
        return goodness;
    }

    private static boolean isGoodPair(String s, int s1, int s2) {
        return s.charAt(s1) != s.charAt(s2);
    }
}
