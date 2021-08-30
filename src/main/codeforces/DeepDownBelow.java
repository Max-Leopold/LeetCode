package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DeepDownBelow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int caves = sc.nextInt();

            List<int[]> monstersInCave = new ArrayList<>();
            for (int j = 0; j < caves; j++) {
                int numMonstersInCave = sc.nextInt();
                int[] monsters = new int[numMonstersInCave];
                for (int k = 0; k < numMonstersInCave; k++) {
                    monsters[k] = sc.nextInt();
                }
                monstersInCave.add(monsters);
            }

            int minPower = solve(monstersInCave);
            System.out.println(minPower);
        }
    }

    private static int solve(List<int[]> monstersInCave) {
        MinPowerWithCaveIndex[] minPowerPerCave = calculateMinPowerPerCave(monstersInCave);
        Arrays.sort(minPowerPerCave, Comparator.comparingInt(o -> o.minPower));
        int powerAdditionSum = 0;
        int currentMax = 0;
        for (int i = 0; i < minPowerPerCave.length; i++) {
            currentMax = Math.max(currentMax, minPowerPerCave[i].minPower - powerAdditionSum);
            powerAdditionSum += monstersInCave.get(minPowerPerCave[i].caveIndex).length;
        }
        return currentMax;
    }

    private static MinPowerWithCaveIndex[] calculateMinPowerPerCave(List<int[]> monstersInCave) {
        MinPowerWithCaveIndex[] minPowerPerCave = new MinPowerWithCaveIndex[monstersInCave.size()];
        for (int j = 0; j < monstersInCave.size(); j++) {
            int[] monsters = monstersInCave.get(j);
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < monsters.length; i++) {
                currentMax = Math.max(currentMax, monsters[i] - i);
            }
            minPowerPerCave[j] = new MinPowerWithCaveIndex(currentMax + 1, j);
        }
        return minPowerPerCave;
    }

    private static class MinPowerWithCaveIndex {
        private final int minPower;
        private final int caveIndex;

        private MinPowerWithCaveIndex(int minPower, int caveIndex) {
            this.minPower = minPower;
            this.caveIndex = caveIndex;
        }
    }
}
