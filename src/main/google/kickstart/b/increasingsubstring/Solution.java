package main.google.kickstart.b.increasingsubstring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            String s = in.next();
            String solution = solve(s);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(String s) {
        int currentLength = 1;
        char lastChar = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(currentLength);
        sb.append(" ");
        for (int i = 1; i < s.length(); i++) {
            if (lastChar < s.charAt(i)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            lastChar = s.charAt(i);
            sb.append(currentLength);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
