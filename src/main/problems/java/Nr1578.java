package main.problems.java;

import java.util.Arrays;

public class Nr1578 {
    public int minCost(String colors, int[] neededTime) {
        char[] colorArr = colors.toCharArray();
        int cost = 0;
        int right = 1;
        for (int i = 0; i < colorArr.length - 1; i++) {
            if (colorArr[i] == '-') continue;

            while (right <= i || (right < colorArr.length && colorArr[right] == '-')) right++;

            if (right >= colorArr.length) return cost;

            if (colorArr[i] == colorArr[right]) {
                if (neededTime[i] < neededTime[right]) {
                    colorArr[i] = '-';
                    cost += neededTime[i];
                } else {
                    colorArr[right] = '-';
                    i--;
                    cost += neededTime[right];
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Nr1578 nr1578 = new Nr1578();
        System.out.println(nr1578.minCost(
                "abaac",
                new int[] {1,2,3,4,5}
        ));
    }
}
