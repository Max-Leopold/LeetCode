package main.problems.java;

public class Nr1854 {
    public int maximumPopulation(int[][] logs) {
        int year = -1;
        int maxAlive = 0;
        int currentlyAlive = 0;
        for (int i = 1950; i <= 2050; i++) {
            for (int j = 0; j < logs.length; j++) {
                if (logs[j][0] == i) {
                    currentlyAlive++;
                } else if (logs[j][1] == i) {
                    currentlyAlive--;
                }
            }
            if (maxAlive < currentlyAlive) {
                maxAlive = currentlyAlive;
                year = i;
            }
        }
        return year;
    }
}
