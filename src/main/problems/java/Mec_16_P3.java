package main.problems.java;

import java.util.Scanner;

public class Mec_16_P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int skills = sc.nextInt();
        int time = sc.nextInt();

        int[][] dp = new int[skills + 1][time + 1];

        for (int i = 1; i <= skills; i++) {
            int levels = sc.nextInt();
            int[][] skillLevels = new int[levels][2];
            for (int level = 0; level < levels; level++) {
                if (level > 0) {
                    skillLevels[level][0] = sc.nextInt() + skillLevels[level - 1][0];
                    skillLevels[level][1] = sc.nextInt() + skillLevels[level - 1][1];
                } else {
                    skillLevels[level][0] = sc.nextInt();
                    skillLevels[level][1] = sc.nextInt();
                }
            }

            for (int j = 1; j <= time; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int level = 0; level < skillLevels.length; level++) {
                    if (j >= skillLevels[level][0]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - skillLevels[level][0]] + skillLevels[level][1]);
                    }
                }
            }
        }

        System.out.println(dp[skills][time]);
    }
}
