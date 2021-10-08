package main.problems.java;

public class Nr322 {
    public static void main(String[] args) {
        Nr322 nr322 = new Nr322();
        System.out.println(nr322.coinChange(
                new int[]{186, 419, 83, 408},
                6249
        ));
    }

    public int coinChange(int[] coins, int amount) {
        int[] minCoinsForAmount = new int[amount + 1];

        for (int coin : coins) {
            minCoinsForAmount[coin] = 1;
        }

        for (int i = 1; i < minCoinsForAmount.length; i++) {
            if (minCoinsForAmount[i] != 0) {
                for (int coin : coins) {
                    if (i + coin < minCoinsForAmount.length && i + coin > 0) {
                        int currentMinCoinsForAmount = minCoinsForAmount[i + coin];
                        if (currentMinCoinsForAmount == 0) {
                            minCoinsForAmount[i + coin] = minCoinsForAmount[i] + 1;
                        } else {
                            minCoinsForAmount[i + coin] = Math.min(minCoinsForAmount[i + coin], minCoinsForAmount[i] + 1);
                        }
                    }
                }
            }
        }

        return minCoinsForAmount[amount] == 0 ? -1 : minCoinsForAmount[amount];
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
