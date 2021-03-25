package main.google.kickstart.h.retype;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long N = in.nextLong();
            long K = in.nextLong();
            long S = in.nextLong();

            System.out.println("Case #" + i + ": " + Math.min(N + K, N + (K - S) * 2));
        }
    }
}