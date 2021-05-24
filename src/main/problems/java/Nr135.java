package main.problems.java;

public class Nr135 {
    public static void main(String[] args) {
        Nr135 nr135 = new Nr135();
        System.out.println(nr135.candy(
                new int[]{1, 3, 4, 5, 2}
        ));
        System.out.println(nr135.candyOnePass(
                new int[]{1, 3, 4, 5, 2}
        ));
    }

    public int candyOnePass(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i] + 1;
        }
        return sum;
    }

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        boolean foundSolution = false;
        while (!foundSolution) {
            foundSolution = true;
            for (int i = 1; i < candies.length; i++) {
                if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    foundSolution = false;
                }
            }
            for (int i = candies.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    foundSolution = false;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i] + 1;
        }
        return sum;
    }
}
