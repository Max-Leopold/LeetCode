package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharmedByTheGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            List<Integer> res = solve(a, b);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < res.size(); j++) {
                sb.append(res.get(j));
                sb.append(" ");
            }
            System.out.println(res.size());
            System.out.println(sb.toString().trim());
        }
    }

    private static List<Integer> solve(int a, int b) {
        int c = Math.abs(a - b);
        int n = a + b;
        int step = c % 2 == 0 ? 2 : 1;

        List<Integer> res = new ArrayList<>();
        int lower = c / 2;
        int higher = n - lower;
        for (; lower <= higher; lower += step) {
            res.add(lower);
        }
        return res;
    }
}
