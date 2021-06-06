package main.problems.java;

import java.util.Arrays;

public class Nr1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Stone[] stones = new Stone[aliceValues.length];

        for (int i = 0; i < aliceValues.length; i++) {
            stones[i] = new Stone(i, aliceValues[i] + bobValues[i]);
        }

        Arrays.sort(stones, (a, b) -> Integer.compare(b.actualValue, a.actualValue));

        int aliceWorth = 0;
        int bobWorth = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i % 2 == 0) {
                aliceWorth += aliceValues[stones[i].index];
            } else {
                bobWorth += bobValues[stones[i].index];
            }
        }

        if (aliceWorth > bobWorth) {
            return 1;
        } else if (bobWorth > aliceWorth) {
            return -1;
        }
        return 0;
    }

    class Stone {

        int index;
        int actualValue;

        public Stone(int index, int actualValue) {
            this.index = index;
            this.actualValue = actualValue;
        }
    }
}
