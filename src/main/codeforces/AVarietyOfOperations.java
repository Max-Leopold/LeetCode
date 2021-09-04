package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AVarietyOfOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            int minimalSteps = solve(c, d);
            System.out.println(minimalSteps);
        }
    }

    private static int solve(int c, int d) {
        int diff = Math.abs(c - d);
        if (c == 0 && d == 0) {
            return 0;
        } else if (diff % 2 != 0) {
            return -1;
        } else if (c == d) {
            return 1;
        } else {
            return 2;
        }
    }
}

