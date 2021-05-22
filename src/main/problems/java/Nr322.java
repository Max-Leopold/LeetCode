package main.problems.java;

import java.util.Arrays;

public class Nr322 {
    public static void main(String[] args) {
        Nr322 nr322 = new Nr322();
        System.out.println(nr322.coinChange(
                new int[]{186, 419, 83, 408},
                6249
        ));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] minCoinsFromHereToEnd = new int[amount + 1];
        Arrays.fill(minCoinsFromHereToEnd, amount + 1);
        minCoinsFromHereToEnd[amount] = 0;
        for (int i = amount; i >= 0; i--) {
            for (int coin : coins) {
                if (i + coin <= amount && i + coin >= 0) {
                    minCoinsFromHereToEnd[i] = Math.min(
                            minCoinsFromHereToEnd[i],
                            minCoinsFromHereToEnd[i + coin] + 1
                    );
                }
            }
        }

        return minCoinsFromHereToEnd[0] < amount + 1 ? minCoinsFromHereToEnd[0] : -1;
    }

    // Greedy doesnt always find the best solution.
    // It only finds "a" solution
    public int coinChangeGreedy(int[] coins, int amount, int coinsUsed) {
        if (amount == 0) {
            return coinsUsed;
        }
        int smallestCoinIndex = -1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            smallestCoinIndex = i;
        }
        if (smallestCoinIndex == -1) {
            return -1;
        }
        int minAmountOfCoins = coinChangeGreedy(
                coins,
                amount - coins[smallestCoinIndex],
                coinsUsed + 1
        );
        while (minAmountOfCoins == -1 && smallestCoinIndex > 0) {
            smallestCoinIndex--;
            minAmountOfCoins = coinChangeGreedy(
                    coins,
                    amount - coins[smallestCoinIndex],
                    coinsUsed + 1
            );
        }
        return minAmountOfCoins;
    }
}
